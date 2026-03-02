1. The Problem: The "Hard-Coded" Switch
Originally, the HostelFeeCalculator had a major Open-Closed Principle (OCP) violation. All room prices were trapped inside a switch-case block, and all add-on prices were inside if-else chains. To change the price of a "Single" room or add a "WiFi" service, you had to modify the core calculation file, which makes the system rigid and fragile. Additionally, the calculator was handling math, printing, and saving all in one place, violating the Single Responsibility Principle (SRP).

2. Our Approach: Pricing Strategies & Dependency Injection
To solve this, we used Polymorphism to make the pricing rules "pluggable":

Pricing Interfaces: We created RoomPricing and AddOnPricing interfaces. This allows the calculator to ask for a price without knowing which specific room or service it is dealing with.

Concrete Strategy Classes: We moved the data for each room (e.g., SingleRoomPricing, DeluxeRoomPricing) and service (e.g., MessPricing, GymPricing) into their own classes.

Map-Based Lookup: The HostelFeeCalculator now uses Maps to store these strategies. It simply looks up the correct price based on the BookingRequest.

Decoupled Logic: Formatting was moved to ReceiptPrinter, and persistence remained in FakeBookingRepo, leaving the calculator to focus strictly on coordinating the fee sum.