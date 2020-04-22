#include <stdio.h>
#include <stdlib.h>
#include <float.h>
#include <math.h>

#define MAX_STRING 255
#define NUMBER_ALPHABETIC 26

double build_calculate(char* inputText, int length_text, double* observed_frequencies, double* expected_frequencies){

   int i = 0;
   while(i != length_text){
      if(inputText[i] >= 65 && inputText[i] <= 90) observed_frequencies[inputText[i] - 65] += 1;
      if(inputText[i] >= 97 && inputText[i] <= 122) observed_frequencies[inputText[i] - 97] += 1;
      i++;
   }

   //Frequence portuguese
   /*double probabilistic_frequency[] = {0.1463, 0.0104, 0.0388, 0.0499, 0.1257, 0.0102,
                                     0.013, 0.0128, 0.0618, 0.004, 0.0002, 0.0278,
                                     0.0474, 0.0505, 0.1073, 0.0252, 0.012, 0.0653,
                                     0.0781, 0.0434, 0.0463, 0.0167, 0.0001, 0.0021,
                                     0.0001, 0.0047};*/

   //Frequence english
   double probabilistic_frequency[] = {0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228,
                                     0.02015, 0.06094, 0.06966, 0.00153, 0.00772, 0.04025,
                                     0.02406, 0.06749, 0.07507, 0.01929, 0.00095, 0.05987,
                                     0.06327, 0.09056, 0.02758, 0.00978, 0.02360, 0.00150,
                                     0.01974, 0.00074};

   for(i = 0; i < NUMBER_ALPHABETIC;i++){
      expected_frequencies[i] = length_text * probabilistic_frequency[i];
   }

   double qui_square[NUMBER_ALPHABETIC];
   for(int i = 0; i < NUMBER_ALPHABETIC; i++)
        qui_square[i] = pow(observed_frequencies[i] - expected_frequencies[i], 2) / expected_frequencies[i];

   double qui_square_sum = 0;
   for(int i = 0; i < NUMBER_ALPHABETIC; i++) qui_square_sum += qui_square[i];

   return qui_square_sum;
}

double get_qui_square_text(char* inputText, int length_text){
   double observed_frequencies[NUMBER_ALPHABETIC];
   double expected_frequencies[NUMBER_ALPHABETIC];

   for(int i = 0; i < NUMBER_ALPHABETIC; i++) observed_frequencies[i] = 0.0;
   for(int i = 0; i < NUMBER_ALPHABETIC; i++) expected_frequencies[i] = 0.0;

   double qui_square_result = build_calculate(inputText, length_text, &observed_frequencies, &expected_frequencies);
   return qui_square_result;
}

int get_length_text(char* inputText){
    int i = 0;
    while(inputText[i] != NULL) i++;
    return i;
}

void main(){
   printf("Text encoded:\n");
   char* inputText = malloc(MAX_STRING);
   gets(inputText);

   int length_text = get_length_text(inputText);

   char candidates_text[NUMBER_ALPHABETIC][length_text];
   for(int i = 0; i < length_text; i++) candidates_text[0][i] = inputText[i];
   for(int i = 1; i < NUMBER_ALPHABETIC; i++){
       for(int j = 0; j < length_text; j++){
           if(candidates_text[i - 1][j] >= 65 && candidates_text[i - 1][j] <= 90) {
                if (candidates_text[i - 1][j] == 65) candidates_text[i][j] = 90;
                else candidates_text[i][j] = candidates_text[i - 1][j] - 1;
           }
           if(candidates_text[i - 1][j] >= 97 && candidates_text[i - 1][j] <= 122) {
                if (candidates_text[i - 1][j] == 97) candidates_text[i][j] = 122;
                else candidates_text[i][j] = candidates_text[i - 1][j] - 1;
           }
       }
   }
   double qui_square_min = DBL_MAX;
   int index_min = 0;
   for(int i = 0; i < NUMBER_ALPHABETIC; i++){
       double qui_square = get_qui_square_text(candidates_text[i], length_text);
       if(qui_square < qui_square_min){
            qui_square_min = qui_square;
            index_min = i;
       }
   }

   printf("\n\nText decoded: \n");
   printf("\nQui_square: %f\n\n", qui_square_min);
   for(int i = 0; i < length_text; i++) printf("%c", candidates_text[index_min][i]);
}
