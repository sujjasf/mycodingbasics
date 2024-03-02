#include <stdio.h> // Declaration of necessary library

char st[100];
int top = -1;

void push(char el)
{
  st[++top] = el; 
}

char pop()
{
  return st[top--];
}

int isop(char val)
{
  if (val == '+' || val == '-' || val == '*' || val == '/' || val == '%')
  {
    return 1;
  } else {
    return 0;
  }
}

int main() // Correct return type for main
{
  char exp[50], v1, v2, ex;
  int i = 0;

  printf("Enter the expression: ");
  fgets(exp, sizeof(exp), stdin); // Using fgets instead of gets

  while(exp[i] != '\0')
  {
    if(isop(exp[i]))
    {
      v1 = pop();
      v2 = pop();
      ex = exp[i];
      
      // Perform the operation
      int result;
      switch(ex) {
        case '+':
          result = v2 + v1;
          break;
        case '-':
          result = v2 - v1;
          break;
        case '*':
          result = v2 * v1;
          break;
        case '/':
          result = v2 / v1;
          break;
        case '%':
          result = v2 % v1;
          break;
      }
      
      // Push the result back onto the stack
      push(result);
    } else {
      push(exp[i]);
    }
    i++;
  }

  printf("Result: %d\n", st[top]); // Print the final result
  return 0; // Returning 0 to indicate successful execution
}
