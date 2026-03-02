1. The Problem in the existing code was that
Originally, the EvaluationPipeline was directly creating its own workers using the new keyword.
If you wanted to change how plagiarism was checked, you had to modify the EvaluationPipeline.java file.
No Abstractions: The high-level "Policy" (how to evaluate a student) was dependent on low-level "Details" (how to write a file or calculate a score).

2. Our Approach: Dependency Injection
To solve this, you "inverted" the relationship by following these steps:

Defined Interfaces: You created IPlagiarismChecker, ICodeGrader, and IReportWriter. These act as the "contracts" that the pipeline depends on.

Constructor Injection: The EvaluationPipeline no longer creates its own tools. Instead, it asks for them in its constructor.

Decoupled Main: In Main.java, you now instantiate the concrete versions (like PlagiarismChecker) and "inject" them into the pipeline.

Example

Lets take an example suppose we have to add a new type of code grader
So in the old example if we are changing code grader so we will have to change our code in 
evaluationpipeline from existing code grader to new code grader where errors can happen 
But in the new way, we can directly create a new type of codegrader which will implement the already existing interface and since evaluation pipeline depends on interface so we will not have to change anything in pipeline
We can go to Main and inject the new type of codegrader in pipeline