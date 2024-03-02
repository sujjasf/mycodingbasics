#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h> // Include for isalnum function

#define MAX_SIZE 100

// Stack structure
typedef struct {
    char data[MAX_SIZE];
    int top;
} Stack;

// Function prototypes
void push(Stack *s, char element);
char pop(Stack *s);
int isEmpty(Stack *s);
void postfixToInfix(char *postfix);

int main() {
    char postfix[MAX_SIZE];

    printf("Enter the postfix expression: ");
    fgets(postfix, sizeof(postfix), stdin);
    
    // Remove newline character from input
    postfix[strcspn(postfix, "\n")] = '\0';

    printf("Infix expression: ");
    postfixToInfix(postfix);

    return 0;
}

// Function to push an element onto the stack
void push(Stack *s, char element) {
    if (s->top == MAX_SIZE - 1) {
        printf("Stack Overflow\n");
        exit(EXIT_FAILURE);
    }
    s->data[++s->top] = element;
}

// Function to pop an element from the stack
char pop(Stack *s) {
    if (isEmpty(s)) {
        printf("Stack Underflow\n");
        exit(EXIT_FAILURE);
    }
    return s->data[s->top--];
}

// Function to check if the stack is empty
int isEmpty(Stack *s) {
    return s->top == -1;
}

// Function to convert postfix expression to infix expression
void postfixToInfix(char *postfix) {
    Stack s;
    s.top = -1;
    int len = strlen(postfix);

    for (int i = 0; i < len; i++) {
        char symbol = postfix[i];
        if (isalnum(symbol)) { // If the symbol is an operand
            push(&s, symbol);
        } else { // If the symbol is an operator
            if (s.top < 1) {
                printf("Invalid postfix expression: Not enough operands for the operator\n");
                exit(EXIT_FAILURE);
            }
            char operand2 = pop(&s);
            char operand1 = pop(&s);
            char infix[2 * MAX_SIZE]; // Infix expression can be at most twice the size of postfix
            sprintf(infix, "(%c%c%c)", operand1, symbol, operand2);
            push(&s, infix[0]); // Push the first character of infix expression onto the stack
        }
    }
    
    if (s.top != 0) {
        printf("Invalid postfix expression: Too many operands\n");
        exit(EXIT_FAILURE);
    }

    // The stack should contain only one element, which is the infix expression
    char *infix = s.data;
    printf("%s\n", infix);
}
