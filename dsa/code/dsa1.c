#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 100
#define TRUE 1
#define FALSE 0

void main()
{
    char exp[MAX];
    struct stack s;
    char symb;
    int i=0, valid=TRUE;
    s.tos=-1;
    printf("Enter your expression : ");
    gets(exp);
    char pop(struct stack*s)
    {
        if(isEmpty)
    }
    while( i<strlen(exp))
    {
        symb=exp[i];
        if(symb=='(' || symb=='{' || symb=='{')
        push(&s,symb);
        else if(symb==')' || symb=='}' || symb=='}')
        if(isEmpty(&s))
        valid = FALSE;
    }



}