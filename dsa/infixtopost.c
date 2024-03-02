#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 100

char stack[MAX];
char infix[MAX], postfix[MAX];
int top = -1;

int precedence(char);
void inToPostfix();
void push(char);
char pop();
int isEmpty();


int main()
{
    printf("Enter the infix expression : ");
    gets(infix);

    inToPostfix();
    printf("Postfix expression: %s\n", postfix); // Print the postfix expression

    return 0;
}

void inToPostfix() {
    int i, j=0;
    char symbol, next;
    for(i=0; i<strlen(infix); i++) {
        symbol = infix[i];
        switch(symbol) {
            case '(':
            push(symbol);
            break;
            case ')':
            while((next=pop()) != '('){
                postfix[j++] = next;
            }
            break;
            case '+':
            case '-':
            case '/':
            case '*':
            case '^':
            while(!isEmpty() && precedence(stack[top]) >= precedence(symbol)){
                postfix[j++] = pop();
            }
            push(symbol);
            break;
            default:
            postfix[j++] = symbol;
        }
    }
    while(!isEmpty()){
        postfix[j++] = pop();
    }
    postfix[j] = '\0';
}
//if symbol is opetator then we will check precedence of the operators


int precedence(char symbol)
{
    switch(symbol)
    {
        //Higher value means greater precenence..
        case '^':
        return 3;
        case '/':
        case '*':
        return 2;
        case '+':
        case '-':
        return 1;
        default:
        return 0;
    }
}

void push(char item) {
    if (top == MAX - 1) {
        printf("Stack Overflow\n");
        return;
    }
    top++;
    stack[top] = item;
}

char pop() {
    if (top == -1) {
        printf("Stack Underflow\n");
        return -1;
    }
    char item = stack[top];
    top--;
    return item;
}

int isEmpty() {
    return top == -1;
}
