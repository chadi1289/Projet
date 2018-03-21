#include "utils.h"

void sha256ofString(BYTE* str, char hashRes[SHA256_BLOCK_SIZE * 2 + 1])
// attention tous vos hash doivent avoir ce format. Char * ne convient pas.
// J'ai perdu deux jours avec cette subtilité
{
  BYTE buf[SHA256_BLOCK_SIZE];
  SHA256_CTX ctx;
  int bufferSize = SHA256_BLOCK_SIZE;
  // char hashRes[bufferSize*2 + 1];

  sha256_init(&ctx);
  sha256_update(&ctx, str, strlen((char*)str));
  sha256_final(&ctx, buf);  // buf contient le hash de str
  int charCount = 0;
  for (int i = 0; i < bufferSize; i++) {
    charCount += sprintf(&hashRes[i * 2], "%02x", buf[i]);
  }
}
