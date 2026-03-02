1 -> The Problem: Multiple Responsibilities in One Method
Originally, the CafeteriaSystem.checkout method was a "God Method" that handled everything. If you needed to change one small detail, you had to modify the entire core logic.

Hard-coded Logic: The tax and discount rules were written as if-else blocks inside the class.

Tight Coupling: The system was locked into using FileStore for saving and a specific format for printing.

Fragile Code: Changing the invoice layout meant potentially breaking the calculation logic because they were mixed together.

2 -> Our Approach: Decoupling via Strategy & Interfaces
We applied the Single Responsibility Principle (SRP) and Dependency Inversion Principle (DIP) to break the method apart:

TaxCalculator & DiscountCalculator Interfaces: We moved the "rules" out of the system. Now, the rules are separate objects passed into the method.

InvoicePrinter Class: We moved all StringBuilder and String.format logic to this dedicated class.

InvoiceStore Interface: We created an abstraction so the system doesn't know where it is saving (Database, File, or Memory).

InvoiceData DTO: We created a simple data holder to carry the calculated results from the math section to the printing section.

Gemini said
The Problem: Multiple Responsibilities in One Method
Originally, the CafeteriaSystem.checkout method was a "God Method" that handled everything. If you needed to change one small detail, you had to modify the entire core logic.

Hard-coded Logic: The tax and discount rules were written as if-else blocks inside the class.

Tight Coupling: The system was locked into using FileStore for saving and a specific format for printing.

Fragile Code: Changing the invoice layout meant potentially breaking the calculation logic because they were mixed together.

Our Approach: Decoupling via Strategy & Interfaces
We applied the Single Responsibility Principle (SRP) and Dependency Inversion Principle (DIP) to break the method apart:

TaxCalculator & DiscountCalculator Interfaces: We moved the "rules" out of the system. Now, the rules are separate objects passed into the method.

InvoicePrinter Class: We moved all StringBuilder and String.format logic to this dedicated class.

InvoiceStore Interface: We created an abstraction so the system doesn't know where it is saving (Database, File, or Memory).

InvoiceData DTO: We created a simple data holder to carry the calculated results from the math section to the printing section.

Specific Example: Adding a "Staff" Discount
1. The Old Way (Problem):
To add a new discount, type or change in existing we would have to open DiscountRules.java and modify a long if-else chain. If you made a typo, you might break the "Student" discount by accident.

2. The New Way (Solution):
We create a brand new class called New DiscountCalculator that implements the DiscountCalculator interface.

You write the logic only for staff in that new file.

In Main.java, you just pass this new object into the checkout method.

Result: You added a feature without changing any existing code in CafeteriaSystem or StudentDiscountCalculator.