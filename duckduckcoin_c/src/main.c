#include <stdio.h>

#include "block.h"
#include "utils.h"

int main(void) {
  char genesis_hash[64] = "hey";
  Block b = create_block(0, genesis_hash);
  mine_block(&b, 3);
  print_block(b);
}
