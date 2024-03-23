#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ACCOUNTS 100
#define MAX_TRANSACTIONS 1000

typedef struct
{
    int account_number;
    char owner_name[50];
    double balance;
} Account;

typedef struct
{
    int transaction_id;
    int account_number;
    double amount;
    char type[20]; // "Deposit", "Withdrawal", "Transfer"
} Transaction;

Account accounts[MAX_ACCOUNTS];
Transaction transactions[MAX_TRANSACTIONS];

int numAccounts = 0;
int numTransactions = 0;

void displayMenu();
void createAccount();
void deposit();
void withdraw();
void transfer();
void viewBalance();
void viewTransactions();

int main()
{
    int choice;

    do
    {
        displayMenu();
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            createAccount();
            break;
        case 2:
            deposit();
            break;
        case 3:
            withdraw();
            break;
        case 4:
            transfer();
            break;
        case 5:
            viewBalance();
            break;
        case 6:
            viewTransactions();
            break;
        case 7:
            printf("Exiting the program.\n");
            exit(0);
        default:
            printf("Invalid choice. Please try again.\n");
        }
    } while (1);

    return 0;
}

void displayMenu()
{
    printf("\n=== Banking System Menu ===\n");
    printf("1. Create Account\n");
    printf("2. Deposit\n");
    printf("3. Withdraw\n");
    printf("4. Transfer\n");
    printf("5. View Balance\n");
    printf("6. View Transactions\n");
    printf("7. Exit\n");
}

void createAccount()
{
    if (numAccounts >= MAX_ACCOUNTS)
    {
        printf("Cannot create more accounts. Maximum limit reached.\n");
        return;
    }

    Account newAccount;
    printf("Enter account number: ");
    scanf("%d", &newAccount.account_number);

    // Check if account number already exists
    for (int i = 0; i < numAccounts; i++)
    {
        if (accounts[i].account_number == newAccount.account_number)
        {
            printf("Account number already exists. Please choose a different one.\n");
            return;
        }
    }

    printf("Enter owner name: ");
    scanf("%s", newAccount.owner_name);
    printf("Enter initial balance: ");
    scanf("%lf", &newAccount.balance);

    accounts[numAccounts++] = newAccount;
    printf("Account created successfully.\n");
}

void deposit()
{
    int account_number;
    double amount;
    printf("Enter account number: ");
    scanf("%d", &account_number);

    int index = -1;
    for (int i = 0; i < numAccounts; i++)
    {
        if (accounts[i].account_number == account_number)
        {
            index = i;
            break;
        }
    }

    if (index == -1)
    {
        printf("Account not found.\n");
        return;
    }

    printf("Enter deposit amount: ");
    scanf("%lf", &amount);

    if (amount <= 0)
    {
        printf("Invalid deposit amount.\n");
        return;
    }

    accounts[index].balance += amount;

    // Add transaction
    transactions[numTransactions].transaction_id = numTransactions + 1;
    transactions[numTransactions].account_number = account_number;
    transactions[numTransactions].amount = amount;
    strcpy(transactions[numTransactions].type, "Deposit");
    numTransactions++;

    printf("Deposit successful.\n");
}

void withdraw()
{
    int account_number;
    double amount;
    printf("Enter account number: ");
    scanf("%d", &account_number);

    int index = -1;
    for (int i = 0; i < numAccounts; i++)
    {
        if (accounts[i].account_number == account_number)
        {
            index = i;
            break;
        }
    }

    if (index == -1)
    {
        printf("Account not found.\n");
        return;
    }

    printf("Enter withdrawal amount: ");
    scanf("%lf", &amount);

    if (amount <= 0 || amount > accounts[index].balance)
    {
        printf("Invalid withdrawal amount.\n");
        return;
    }

    accounts[index].balance -= amount;

    // Add transaction
    transactions[numTransactions].transaction_id = numTransactions + 1;
    transactions[numTransactions].account_number = account_number;
    transactions[numTransactions].amount = amount;
    strcpy(transactions[numTransactions].type, "Withdrawal");
    numTransactions++;

    printf("Withdrawal successful.\n");
}

void transfer()
{
    int from_account, to_account;
    double amount;
    printf("Enter account number to transfer from: ");
    scanf("%d", &from_account);

    int from_index = -1;
    for (int i = 0; i < numAccounts; i++)
    {
        if (accounts[i].account_number == from_account)
        {
            from_index = i;
            break;
        }
    }

    if (from_index == -1)
    {
        printf("Account not found.\n");
        return;
    }

    printf("Enter account number to transfer to: ");
    scanf("%d", &to_account);

    int to_index = -1;
    for (int i = 0; i < numAccounts; i++)
    {
        if (accounts[i].account_number == to_account)
        {
            to_index = i;
            break;
        }
    }

    if (to_index == -1)
    {
        printf("Destination account not found.\n");
        return;
    }

    printf("Enter transfer amount: ");
    scanf("%lf", &amount);

    if (amount <= 0 || amount > accounts[from_index].balance)
    {
        printf("Invalid transfer amount.\n");
        return;
    }

    accounts[from_index].balance -= amount;
    accounts[to_index].balance += amount;

    // Add transactions
    transactions[numTransactions].transaction_id = numTransactions + 1;
    transactions[numTransactions].account_number = from_account;
    transactions[numTransactions].amount = amount;
    strcpy(transactions[numTransactions].type, "Transfer");
    numTransactions++;

    transactions[numTransactions].transaction_id = numTransactions + 1;
    transactions[numTransactions].account_number = to_account;
    transactions[numTransactions].amount = amount;
    strcpy(transactions[numTransactions].type, "Received");
    numTransactions++;

    printf("Transfer successful.\n");
}

void viewBalance()
{
    int account_number;
    printf("Enter account number: ");
    scanf("%d", &account_number);

    int index = -1;
    for (int i = 0; i < numAccounts; i++)
    {
        if (accounts[i].account_number == account_number)
        {
            index = i;
            break;
        }
    }

    if (index == -1)
    {
        printf("Account not found.\n");
        return;
    }

    printf("Account balance: %.2f\n", accounts[index].balance);
}

void viewTransactions()
{
    int account_number;
    printf("Enter account number: ");
    scanf("%d", &account_number);

    printf("Transactions for account number %d:\n", account_number);
    for (int i = 0; i < numTransactions; i++)
    {
        if (transactions[i].account_number == account_number)
        {
            printf("Transaction ID: %d, Type: %s, Amount: %.2f\n", transactions[i].transaction_id, transactions[i].type, transactions[i].amount);
        }
    }
}
