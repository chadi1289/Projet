cmake_minimum_required(VERSION 3.0)
project(xorcipher)

set(CMAKE_C_COMPILER "gcc")
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)
set(CMAKE_C_FLAGS "-std=c11 -Wall -Wextra -pedantic -Wfloat-equal -Wundef \
-Wstrict-prototypes -Wstrict-overflow=5 -Wwrite-strings -Wcast-qual -Werror \
-Wshadow -Wstrict-overflow -fno-strict-aliasing \
-Wno-missing-field-initializers -Wunreachable-code -Wconversion \
-fdiagnostics-color=always")
set(CMAKE_C_FLAGS_DEBUG "-DDEBUG")
set(CMAKE_C_FLAGS_RELEASE "-O2")

include_directories(src/)

SET(SOURCE_FILES
  src/json/json-builder.c
  src/json/json.c
  src/sha256/sha256.c
  src/sha256/utils.c
  src/block.c
  src/blockchain.c
  src/main.c
)

add_executable(
  duckduckcoin
  ${SOURCE_FILES})

target_link_libraries(duckduckcoin m)
