## Deli-cious Deli Application
### Description
The Deli-cious Deli Application is an interactive Java-based program designed to streamline the process of creating and managing custom sandwich orders in a deli environment. Customers can build their sandwiches step-by-step by selecting bread types, sandwich sizes, toppings, sauces, and additional extras such as extra meat, cheese, or toasted options. The application also allows users to add drinks with multiple size options and chips to their orders.

### Key Features
**Customizable Sandwiches:**

The application allows users to fully customize their sandwiches:
Choose bread type.
Select one size (Small, Medium, Large) with tiered pricing.
Add one meat and one cheese, with an option for extra servings.
Add multiple regular toppings (e.g., lettuce, tomatoes).
Option to toast the sandwich.

**Dynamic Pricing:**

Prices are calculated dynamically based on:
Sandwich size.
Extra servings of premium toppings (meats and cheeses).
Toasting option ($0.50 extra).
Add-Ons:
Users can add drinks (Small, Medium, Large) and chips with predefined pricing.

**Order Management:**

Supports adding multiple items (sandwiches, drinks, chips) to a single order.
Displays a detailed order summary with the total price.

**Receipts Management:**

Generates a text file receipt for each order.
Saves receipts to a directory (receipts) with a timestamp-based filename (e.g., 20241202-221831.txt).'

### Object Oriented Programming (OOP) Concepts Learned

**Modular Design**
- I learned that separating functionality into distinct classes like Order, Sandwich, and ReceiptsManager helps with clarity and reusability.

**Abstraction**
  - Simplifying complex features like pricing and toppings with reusable interfaces and methods helps with making the program easier to understand and maintain by exposing only necessary functionalities required for the project. 

**Polymorphism**
- Through creating dynamic programming logic or rules, the same methods or interfaces can be used to perform different tasks; for example, by using @Overide to customize a method's beavior.

**Inheritance**
- Inheritance can allow code to be reusable across different classes, which reduces redundancy. It also helps to encapsulate shared properties and methods which are used. 

**Application CLI**

![Delicious Deli UI (1)](https://github.com/user-attachments/assets/4f9f4336-f5a6-4e41-ac44-3ab4d41f4475)
