The Problem -> 
Originally, the OnboardingService was a monolithic method that handled five distinct tasks: parsing raw strings, validating business rules, generating IDs, persisting data, and formatting console output. This made the code rigid (hard to change) and fragile (hard to test in isolation).

Our Approach: Decoupling via Composition
To solve this, we applied the Single Responsibility Principle (SRP) by breaking the "God Method" into specialized classes:

InputParser: Handles the extraction of data from the raw semicolon-delimited string into a structured StudentData object.
StudentValidator: Isolates the business rules (email format, program types) from the rest of the flow.
StudentRepository (Interface): Introduced an abstraction for data storage. By making OnboardingService depend on the interface rather than FakeDb, we satisfied the Dependency Inversion Principle (DIP).
OnBoardingPrinter: Moved all System.out.println calls here. Now, if the UI changes from a console to a GUI or a web response, we only need to swap or update this printer.
The OnboardingService now acts as a Coordinator. It doesn't "know" how to parse or how to save; it simply asks its helper components to perform their specific tasks in order.

Lets take an example, Suppose we have to add a new validation rule, then in the existing code we will have to search for the if 
else strings in the OnbaordingService but with the updated code, we can directly go to StudentValidator and add a new rule without changing other code hence preserving srp.

