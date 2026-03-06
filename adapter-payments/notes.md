Problem ->

The original code for the OrderService is difficult to maintain and scale due to several architectural issues:
OrderService depends on two different payment SDKs (FastPayClient and SafeCashClient) that use different method names and logic.
The service has to handle for each specific SDK—such as FastPay's single-step payNow and  SafeCash's two-step process involving createPayment and confirm.
The service relies on branching logic like if/else blocks to decide which SDK to call based on a string provider name if interface is not present.
Adding a new payment provider would require modifying the internal code of OrderService, hence violating OCP.

Our Approach(The Adapter Pattern) ->

Since we have a interface PaymentGateway so we will make sure that now it is the only contract OrderService needs to understand.

Gemini said
The Problem: Incompatible SDKs and Tight Coupling
The current state of the OrderService is inefficient and difficult to maintain due to how it handles external payment providers:

Mismatched Interfaces: The OrderService is forced to deal with two different SDKs (FastPayClient and SafeCashClient) that have completely different method names and logic.

Duplicate Glue Logic: The service originally had to know the specific "how-to" for each SDK—such as FastPay's single-step payNow versus SafeCash's multi-step process involving createPayment and confirm.

Provider Branching: The service relies on "branching" logic (like switch statements or if/else blocks) to decide which SDK to call based on a string provider name.

Violation of Open-Closed Principle: Adding a new payment provider (like PayPal) would require modifying the internal code of OrderService, making the system fragile.

Our Approach: The Adapter Pattern
We solve this by introducing a middle layer that translates the specific SDK calls into a single, uniform interface.

We create classes that wrap the messy SDKs and make them look like a standard PaymentGateway:
FastPayAdapter: Implements PaymentGateway and internally calls FastPayClient.payNow().
SafeCashAdapter: Implements PaymentGateway and handles the complex logic of creating a SafeCashPayment and then calling confirm()
Both of these adapter will call a method charge from PaymentGateway and our OrderService will depend on Interface rather than concrete class 
In App.java, we create a Map that acts as a Registry for our adapters.
We inject this map into the OrderService via its constructor.
OrderService now just pulls a PaymentGateway from the map and calls .charge(). It doesn't know—and doesn't care—which SDK is actually running.
Now if have to add a new Provider then we can create a adapter for it and add it to the map in App.java and there is no need to change anything in OrderService.java.