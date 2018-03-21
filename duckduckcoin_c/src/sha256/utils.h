#pragma once

#include <stdio.h>
#include <string.h>

#include "sha256.h"

void sha256ofString(BYTE* str, char hashRes[SHA256_BLOCK_SIZE * 2 + 1]);
