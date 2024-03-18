// Here's a simple program that demonstrates how to insert (push) an item into a stack implemented with an array:

#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 10  // Defining the maximum size of the stack

int stack[MAX_SIZE]; // Stack array declaration
int top = -1;        // Initially, the stack is empty so the top is -1

// Function to push an element into the stack
void push(int element) {
    // Checking if the stack is full
    if(top == MAX_SIZE - 1) {
        printf("Stack Overflow\n");
    } else {
        top = top + 1;         // Increment top
        stack[top] = element;  // Insert element at the top
        printf("%d pushed to stack\n", element);
    }
}

// Function to display the stack elements
void display() {
    if(top == -1) {
        printf("Stack is empty\n");
    } else {
        printf("Stack elements are:\n");
        for(int i = top; i >= 0; i--) {
            printf("%d\n", stack[i]);
        }
    }
}

int main() {
    push(10); // Inserting elements into the stack
    push(20);
    push(30);

    display(); // Displaying the stack elements

    return 0;
}
