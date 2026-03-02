1. The Problem: The Monolithic "Fat" Interface
Originally, the system used a single ClubAdminTools interface that bundled financial, minute-taking, and event-planning operations together. This forced the TreasurerTool to include irrelevant methods like addMinutes() and the SecretaryTool to include dummy logic for financial roles. This design led to "fat" classes filled with no-op or dummy implementations that were misleading and difficult to maintain.

2. Our Approach: Role-Based Interface Segregation
To solve this, we split the responsibilities into three distinct, specialized interfaces:

FinanceTools: Contains only methods related to club finances (addIncome, addExpense).

MinutesTools: Dedicated strictly to recording meeting minutes (addMinutes).

PlanningTools: Focused solely on event management (createEvent, getEventsCount).

By having SecretaryTool only implement MinutesTools and TreasurerTool only implement FinanceTools, EventLeadTool only implementing Planning Tool , we eliminated all irrelevant method implementations.

Example

Imagine you want to add a person who only handles SocialMedia for the club.

The Old Way: We would have to force them to use the ClubAdminTools interface. Because that interface has "everything," your new Publicity Lead would be forced to write "dummy" code for the bank account and meeting minutes just to get their Instagram code to compile.

The Result: You have a "messy" class full of code that says // irrelevant or return 0.

Gemini said
Here is a straightforward example of why this refactor matters using a Publicity Lead role.

The Problem: The "Fat" Interface
Imagine you want to add a person who only handles Instagram posts for the club.

The Old Way: You would have to force them to use the ClubAdminTools interface. Because that interface has "everything," your new Publicity Lead would be forced to write "dummy" code for the bank account and meeting minutes just to get their Instagram code to compile.

The Result: You have a "messy" class full of code that says // irrelevant or return 0.

The New Way: You simply create a new, tiny interface called PublicityTools with one method: postToSocialMedia().

The Result: The Publicity Lead only implements PublicityTools. They don't see the finance rools , or any other irrelevant details they don't see the meeting minutes, and they don't have any "dummy" code.