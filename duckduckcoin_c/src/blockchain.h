#pragma once

#include "block.h"

typedef struct BlockChain {
  int difficulty;
  Block* blocks;
  // Transaction transaction[MAX_TRANSACTIONS_PER_BLOCK];

  int blockCount;
  int blockCapacity;
} BlockChain;

BlockChain create_blockchain(int difficulty);
