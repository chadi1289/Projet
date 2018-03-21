#include <stdlib.h>

#include "block.h"
#include "blockchain.h"

BlockChain create_blockchain(int difficulty) {
  BlockChain b = {.difficulty = difficulty};
  b.blocks = malloc(sizeof(Block) * 10);
  b.blockCapacity = 10;
  b.blockCount = 0;
  return b;
}

void mine(BlockChain* b) {
  Block b = create_block(b->blockCount + 1, b->blocks[b->blockCount - 1].hash);
  b.
}
