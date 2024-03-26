#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 10

int stack[MAX_SIZE];
int top = -1;

void push(int element) {
    if(top >= MAX_SIZE - 1) {
        printf("Stack Overflow\n");
    } else {
        stack[++top] = element;  // Increment top and add the element
        printf("%d pushed to stack\n", element);
    }
}


int pop() {
    if(top == -1) {
        printf("Stack Underflow\n");
        return -1;
    } else {
        int poppedElement = stack[top]; // Retrieve the top element
        top--;  // Decrement top
        printf("%d popped from stack\n", poppedElement);
        return poppedElement;
    }
}

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

void clearStack() {
    top = -1;  // Simply set top to -1 to clear the stack
    printf("Stack cleared\n");
}

int main() {
    int choice, value;

do{
 printf("\n*** Stack Menu ***\n");
        printf("1. Push\n2. Pop\n3. Display\n4. Clear Stack\n5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1: 
                printf("Enter the value to push: ");
                scanf("%d", &value);
                push(value);
                break;
            case 2: 
                pop();
                break;
            case 3: 
                display();
                break;
            case 4:
                clearStack();
                break;
            case 5: 
                printf("Exiting program\n");
                exit(0);
                break;
            default:
                printf("Invalid choice\n");
}
    while(1) ;
       
        
    }
    return 0;
}
