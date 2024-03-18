#include <stdio.h>
#include <stdlib.h>

int main() {
    int *ptr;
    int n = 5; // Number of elements

    // Allocate memory for n integers
    ptr = (int*)malloc(n * sizeof(int));

    if (ptr == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    // Initialize the allocated memory
    for (int i = 0; i < n; i++) {
        ptr[i] = i + 1;
    }

    // Print the allocated integers
    for (int i = 0; i < n; i++) {
        printf("%d ", ptr[i]);
    }

    // Free the allocated memory
    free(ptr);

    return 0;
}
