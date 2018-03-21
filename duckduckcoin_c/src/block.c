#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <time.h>

#include "block.h"
#include "json/json-builder.h"
#include "sha256/utils.h"

static json_serialize_opts options = {.mode = json_serialize_mode_multiline,
                                      .indent_size = 2};

static json_serialize_opts hashOptions = {.mode = json_serialize_mode_packed};

Block create_block(int index, char previousHash[64]) {
  time_t timestamp = time(NULL);
  Block b = {.index = index, .timestamp = timestamp};
  strncpy(b.previousHash, previousHash, 64);
  return b;
}

json_value* to_json(Block block) {
  json_value* obj = json_object_new(0);
  json_object_push(obj, "index", json_integer_new(block.index));
  json_object_push(obj, "nonce", json_integer_new(block.nonce));
  json_object_push(obj, "timestamp", json_integer_new(block.timestamp));
  json_object_push(obj, "previousHash", json_string_new(block.previousHash));
  json_object_push(obj, "merkleRoot", json_string_new(block.merkleRoot));

  return obj;
}

void print_block(Block block) {
  json_value* obj = to_json(block);
  json_object_push(obj, "hash", json_string_new(block.hash));

  char* buf = malloc(json_measure_ex(obj, options));
  json_serialize_ex(buf, obj, options);

  printf("%s\n", buf);

  json_builder_free(obj);
  free(buf);
}

void update_block(Block* block) {
  json_value* obj = to_json(*block);
  char* buf = malloc(json_measure_ex(obj, options));
  json_serialize_ex(buf, obj, hashOptions);

  sha256ofString((BYTE*)buf, block->hash);

  json_builder_free(obj);
  free(buf);
}

void mine_block(Block* block, int difficulty) {
  update_block(block);

  while (true) {
    bool mined = true;
    for (int i = 0; i < difficulty; i++) {
      if (block->hash[i] != '0') {
        mined = false;
        break;
      }
    }

    if (mined)
      break;

    block->nonce += 1;
    update_block(block);
  }
}
