# Grocery List Manager

A command-line grocery list application in Java demonstrating object-oriented 
design, method overloading, and defensive input handling.

## Features
- Add items to the list with duplicate detection
- Remove items by name or by list position
- Check off items by name or by list position
- Print formatted list with completion status
- Case-insensitive matching for item lookups
- Input validation for blank entries and mixed data types

## Key Concepts
- Object-oriented design with separated runner and manager classes
- Method overloading for flexible user input (name or index-based operations)
- Array-based list management with insertion, deletion, and shift operations
- Defensive programming with bounds checking and null-safety
- StringBuilder for efficient string construction

## How to Run

javac GroceryList.java


## Usage
The program presents a menu with five options, will repeat until exited:
1. Add item — enter an item name to add to the list
2. Remove item — enter an item name or list position (1-based) to remove
3. Check off item — enter an item name or list position to mark complete
4. Print list — display all items with completion status (x = checked, - = unchecked)
5. Exit — quit the program

## Known Limitations / Future Improvements
- Fixed 50-item capacity — would migrate to `ArrayList` in a rewrite
- No unit tests — would add JUnit tests for the manager class
