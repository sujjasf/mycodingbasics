#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 100

// Stack implementation
struct Stack {
    int top;
    char items[MAX_SIZE];
};

// Function prototypes
void push(struct Stack *stack, char item);
char pop(struct Stack *stack);
int is_operator(char c);
int precedence(char c);
void infix_to_prefix(char infix[], char prefix[]);
void reverse_string(char str[]);

int main() {
    char infix[MAX_SIZE], prefix[MAX_SIZE];

    // Input infix expression
    printf("Enter an infix expression: ");
    fgets(infix, MAX_SIZE, stdin);
    infix[strcspn(infix, "\n")] = '\0'; // Remove newline character if present

    // Convert infix to prefix
    infix_to_prefix(infix, prefix);

    // Output prefix expression
    printf("Prefix expression: %s\n", prefix);

    return 0;
}

// Function to push an item onto the stack
void push(struct Stack *stack, char item) {
    if (stack->top == MAX_SIZE - 1) {
        printf("Stack Overflow\n");
        exit(EXIT_FAILURE);
    } else {
        stack->top++;
        stack->items[stack->top] = item;
    }
}

// Function to pop an item from the stack
char pop(struct Stack *stack) {
    if (stack->top == -1) {
        printf("Stack Underflow\n");
        exit(EXIT_FAILURE);
    } else {
        return stack->items[stack->top--];
    }
}

// Function to check if a character is an operator
int is_operator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/');
}

// Function to determine the precedence of an operator
int precedence(char c) {
    switch (c) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        default:
            return 0;
    }
}

// Function to convert infix expression to prefix expression
void infix_to_prefix(char infix[], char prefix[]) {
    struct Stack stack;
    stack.top = -1;
    char reversed_infix[MAX_SIZE], postfix[MAX_SIZE], c;
    int i, j = 0;

    // Reverse the infix expression
    reverse_string(infix);
    strcpy(reversed_infix, infix);

    // Convert '(' to ')' and vice versa
    for (i = 0; reversed_infix[i] != '\0'; i++) {
        if (reversed_infix[i] == '(')
            reversed_infix[i] = ')';
        else if (reversed_infix[i] == ')')
            reversed_infix[i] = '(';
    }

    // Infix to Postfix Conversion
    for (i = 0; reversed_infix[i] != '\0'; i++) {
        if (reversed_infix[i] == ' ') {
            continue; // Skip whitespace
        } else if (isalnum(reversed_infix[i])) {
            postfix[j++] = reversed_infix[i];
        } else if (reversed_infix[i] == '(') {
            push(&stack, reversed_infix[i]);
        } else if (reversed_infix[i] == ')') {
            while ((c = pop(&stack)) != '(')
                postfix[j++] = c;
        } else {
            while (stack.top != -1 && precedence(stack.items[stack.top]) >= precedence(reversed_infix[i]))
                postfix[j++] = pop(&stack);
            push(&stack, reversed_infix[i]);
        }
    }
    while (stack.top != -1)
        postfix[j++] = pop(&stack);
    postfix[j] = '\0';

    // Reverse the postfix expression to get prefix expression
    reverse_string(postfix);
    strcpy(prefix, postfix);
}

// Function to reverse a string
void reverse_string(char str[]) {
    int length = strlen(str);
    int i, j;
    char temp;
    for (i = 0, j = length - 1; i < j; i++, j--) {
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
