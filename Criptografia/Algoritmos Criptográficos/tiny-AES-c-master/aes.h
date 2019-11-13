#ifndef _AES_H_
#define _AES_H_

#include <stdint.h>


// #define the macros below to 1/0 to enable/disable the mode of operation.
//
// CBC enables AES encryption in CBC-mode of operation.
// ECB enables the basic ECB 16-byte block algorithm. Both can be enabled simultaneously.

// The #ifndef-guard allows it to be configured before #include'ing or at compile time.

#ifndef ECB
  #define ECB 1
#endif

#ifndef CBC
  #define CBC 1
#endif

#ifndef CTR
  #define CTR 1
#endif // CTR

#ifndef GCM
  #define GCM 1
#endif // GCM

#define AES128 1
//#define AES192 1
//#define AES256 1

#if defined(ECB) && (ECB == 1)

void AES_ECB_encrypt(const uint8_t* input, const uint8_t* key, uint8_t *output, const uint32_t length);
void AES_ECB_decrypt(const uint8_t* input, const uint8_t* key, uint8_t *output, const uint32_t length);

#endif // #if defined(ECB) && (ECB == !)

#if defined(CBC) && (CBC == 1)

void AES_CBC_encrypt(const uint8_t* input, const uint8_t* key, uint8_t* output, const uint32_t length, const uint8_t* iv);
void AES_CBC_decrypt(const uint8_t* input, const uint8_t* key, uint8_t* output, const uint32_t length, const uint8_t* iv);

#endif // defined

#if defined(CTR) && (CTR == 1)

void AES_CTR_encrypt(const uint8_t* input, const uint8_t* key, uint8_t* output, const uint32_t length, const uint8_t* iv);
void AES_CTR_decrypt(const uint8_t* input, const uint8_t* key, uint8_t* output, const uint32_t length, const uint8_t* iv);

#endif // defined

#if defined(GCM) && (GCM == 1)

void AES_GCM_encrypt(const uint8_t* input, const uint8_t* key, uint8_t* output, const uint32_t length, const uint8_t* iv, const uint8_t* aad, uint8_t* t);
void AES_GCM_decrypt(const uint8_t* input, const uint8_t* key, uint8_t* output, const uint32_t length, const uint8_t* iv, const uint8_t* aad, uint8_t* t);

#endif // defined

#endif //_AES_H_
