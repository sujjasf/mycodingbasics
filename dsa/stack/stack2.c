#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 100

// Define a structure for each item in the list
typedef struct {
    int id;
    char name[50];
} Item;

// Define the list structure
typedef struct {
    Item items[MAX_SIZE];
    int size;
} ArrayList;

// Function prototypes
void initialize(ArrayList *list);
void insert_front(ArrayList *list, Item item);
void insert_end(ArrayList *list, Item item);
void insert_after(ArrayList *list, Item item_to_insert, Item item_after);
void insert_before(ArrayList *list, Item item_to_insert, Item item_before);
Item remove_front(ArrayList *list);
Item remove_end(ArrayList *list);
Item remove_item(ArrayList *list, Item item);
void list_items(ArrayList list);
Item *search_item_by_field(ArrayList list, char field[], char value[]);
void print_item(Item item);
void print_menu();

int main() {
    ArrayList list;
    initialize(&list);

    int choice;
    Item item, item_after, item_before, *found_item;
    char field[50], value[50];

    do {
        print_menu();
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter ID and Name of the item to insert at the front: ");
                scanf("%d %s", &item.id, item.name);
                insert_front(&list, item);
                break;
            case 2:
                printf("Enter ID and Name of the item to insert at the end: ");
                scanf("%d %s", &item.id, item.name);
                insert_end(&list, item);
                break;
            case 3:
                printf("Enter ID and Name of the item to insert: ");
                scanf("%d %s", &item.id, item.name);
                printf("Enter ID and Name of the item after which to insert: ");
                scanf("%d %s", &item_after.id, item_after.name);
                insert_after(&list, item, item_after);
                break;
            case 4:
                printf("Enter ID and Name of the item to insert: ");
                scanf("%d %s", &item.id, item.name);
                printf("Enter ID and Name of the item before which to insert: ");
                scanf("%d %s", &item_before.id, item_before.name);
                insert_before(&list, item, item_before);
                break;
            case 5:
                item = remove_front(&list);
                printf("Removed item from the front: ");
                print_item(item);
                break;
            case 6:
                item = remove_end(&list);
                printf("Removed item from the end: ");
                print_item(item);
                break;
            case 7:
                printf("Enter ID and Name of the item to remove: ");
                scanf("%d %s", &item.id, item.name);
                item = remove_item(&list, item);
                printf("Removed item: ");
                print_item(item);
                break;
            case 8:
                printf("List items:\n");
                list_items(list);
                break;
            case 9:
                printf("Enter the field to search by (id/name): ");
                scanf("%s", field);
                printf("Enter the value to search for: ");
                scanf("%s", value);
                found_item = search_item_by_field(list, field, value);
                if (found_item != NULL) {
                    printf("Item found: ");
                    print_item(*found_item);
                } else {
                    printf("Item not found.\n");
                }
                break;
            case 10:
                printf("Exiting program.\n");
                exit(0);
            default:
                printf("Invalid choice. Please enter a number between 1 and 10.\n");
        }
    } while (1);

    return 0;
}

// Initialize the list
void initialize(ArrayList *list) {
    list->size = 0;
}

// Insert an item at the front of the list
void insert_front(ArrayList *list, Item item) {
    if (list->size < MAX_SIZE) {
        for (int i = list->size; i > 0; i--) {
            list->items[i] = list->items[i - 1];
        }
        list->items[0] = item;
        list->size++;
    } else {
        printf("List is full. Cannot insert.\n");
    }
}

// Insert an item at the end of the list
void insert_end(ArrayList *list, Item item) {
    if (list->size < MAX_SIZE) {
        list->items[list->size++] = item;
    } else {
        printf("List is full. Cannot insert.\n");
    }
}

// Insert an item after a specified item in the list
void insert_after(ArrayList *list, Item item_to_insert, Item item_after) {
    int i, found = 0;
    for (i = 0; i < list->size; i++) {
        if (list->items[i].id == item_after.id && strcmp(list->items[i].name, item_after.name) == 0) {
            found = 1;
            break;
        }
    }
    if (found) {
        if (list->size < MAX_SIZE) {
            for (int j = list->size; j > i + 1; j--) {
                list->items[j] = list->items[j - 1];
            }
            list->items[i + 1] = item_to_insert;
            list->size++;
        } else {
            printf("List is full. Cannot insert.\n");
        }
    } else {
        printf("Item not found in the list.\n");
    }
}

// Insert an item before a specified item in the list
void insert_before(ArrayList *list, Item item_to_insert, Item item_before) {
    int i, found = 0;
    for (i = 0; i < list->size; i++) {
        if (list->items[i].id == item_before.id && strcmp(list->items[i].name, item_before.name) == 0) {
            found = 1;
            break;
        }
    }
    if (found) {
        if (list->size < MAX_SIZE) {
            for (int j = list->size; j > i; j--) {
                list->items[j] = list->items[j - 1];
            }
            list->items[i] = item_to_insert;
            list->size++;
        } else {
            printf("List is full. Cannot insert.\n");
        }
    } else {
        printf("Item not found in the list.\n");
    }
}

// Remove the item from the front of the list
Item remove_front(ArrayList *list) {
    Item removed_item;
    if (list->size > 0) {
        removed_item = list->items[0];
        for (int i = 0; i < list->size - 1; i++) {
            list->items[i] = list->items[i + 1];
        }
        list->size--;
        return removed_item;
    } else {
        printf("List is empty. Cannot remove.\n");
        removed_item.id = -1; // Return a dummy item indicating failure
        strcpy(removed_item.name, "N/A");
        return removed_item;
    }
}

// Remove the item from the end of the list
Item remove_end(ArrayList *list) {
    Item removed_item;
    if (list->size > 0) {
        removed_item = list->items[--list->size];
        return removed_item;
    } else {
        printf("List is empty. Cannot remove.\n");
        removed_item.id = -1; // Return a dummy item indicating failure
        strcpy(removed_item.name, "N/A");
        return removed_item;
    }
}

// Remove a specified item from the list
Item remove_item(ArrayList *list, Item item) {
    Item removed_item;
    int i, found = 0;
    for (i = 0; i < list->size; i++) {
        if (list->items[i].id == item.id && strcmp(list->items[i].name, item.name) == 0) {
            found = 1;
            break;
        }
    }
    if (found) {
        removed_item = list->items[i];
        for (int j = i; j < list->size - 1; j++) {
            list->items[j] = list->items[j + 1];
        }
        list->size--;
        return removed_item;
    } else {
        printf("Item not found in the list.\n");
        removed_item.id = -1; // Return a dummy item indicating failure
        strcpy(removed_item.name, "N/A");
        return removed_item;
    }
}

// Display all items in the list
void list_items(ArrayList list) {
    if (list.size == 0) {
        printf("List is empty.\n");
    } else {
        for (int i = 0; i < list.size; i++) {
            printf("%d %s\n", list.items[i].id, list.items[i].name);
        }
    }
}

// Search for an item in the list based on a specified field
Item *search_item_by_field(ArrayList list, char field[], char value[]) {
    static Item found_item; // Define a static variable to store the found item
    for (int i = 0; i < list.size; i++) {
        if (strcmp(field, "id") == 0) {
            if (list.items[i].id == atoi(value)) {
                found_item = list.items[i]; // Update the static variable with the found item
                return &found_item; // Return a pointer to the static variable
            }
        } else if (strcmp(field, "name") == 0) {
            if (strcmp(list.items[i].name, value) == 0) {
                found_item = list.items[i]; // Update the static variable with the found item
                return &found_item; // Return a pointer to the static variable
            }
        }
    }
    return NULL;
}


// Print an item
void print_item(Item item) {
    printf("%d %s\n", item.id, item.name);
}

// Print the menu options
void print_menu() {
    printf("\n1. Insert at front\n");
    printf("2. Insert at end\n");
    printf("3. Insert after an item\n");
    printf("4. Insert before an item\n");
    printf("5. Remove from front\n");
    printf("6. Remove from end\n");
    printf("7. Remove any item\n");
    printf("8. List items\n");
    printf("9. Search item by field\n");
    printf("10. Exit\n");
}
