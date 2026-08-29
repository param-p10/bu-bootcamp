#include <stdio.h> 

void swap(int *a, int *b) {
    int temp = *a;   
    *a = *b;       
    *b = temp;
}

void broken_swap(int a, int b) {
    int temp = a;   
    a = b;       
    b = temp;
}

int main() { 
    int x = 4;
    int y = 3;

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("Before swap: x = %d, y = %d\n", x, y);

    broken_swap(x, y);
    printf("Broken swap: x = %d, y = %d\n", x, y);
    /*Takes values, so does not workgit add module6/  */ 
} 


