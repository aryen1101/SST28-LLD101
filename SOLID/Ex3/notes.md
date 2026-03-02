
Design Analysis: Placement Eligibility (OCP & SRP Solutions)
1. The Problem: The "Hard-Coded" Chain
Originally, the EligibilityEngine was a single method filled with if-else blocks. This made the code rigid because any new rule required changing the engine itself, and fragile because all rules were tangled together. If you wanted to change the CGR threshold from 8.0 to 7.5, you had to find and edit the value directly inside the logic.

2. Our Approach: Rule Abstraction
To solve this, we applied the Strategy Pattern to separate the "Checking Logic" from the "Engine Execution".

EligibilityRule (Interface): We created a shared contract. Now, the engine doesn't need to know what it is checking; it only knows that every rule has a .check() method.

Specialized Classes: We created CGRRule, AttendanceRule, CreditsRule, and DisciplinaryRule. Each class has only one reason to change, satisfying the Single Responsibility Principle (SRP).

The List Injection: In Main.java, we create a List<EligibilityRule> and pass it into the engine. This means the engine is now a "Coordinator" that simply loops through whatever rules you give it.

example ->

The Old Way (Problem):
To add a rule that students must have zero F grade, we would have to open EligibilityEngine.java, find the middle of the evaluation method, and insert a new if-else block. One small mistake could break the existing attendance or CGR checks.

The New Way (Solution):

Create a New File: Write a BacklogRule.java that implements the EligibilityRule interface.

Plug it in: In Main.java, simply add new BacklogRule() to the list of rules.

Result: You added the feature without touching a single line of code in the EligibilityEngine or the other rule classes. This is the Open-Closed Principle in action—the engine is "closed" for changes but "open" for new rules.

Clean Engine: EligibilityEngine is now generic; it works for placement, internships, or scholarships just by changing the list of rules provided to it.

Configurable: By passing RuleInput values into the rule constructors, you can change thresholds (like min attendance) without editing the logic of the rules themselves.