#pragma once

#include <time.h>

typedef struct Block {
  int index;
  int nonce;
  time_t timestamp;
  char previousHash[64];

  char hash[64];
  char merkleRoot[64];
} Block;

Block create_block(int index, char previousHash[64]);
void print_block(Block b);
void mine_block(Block* b, int difficulty);
