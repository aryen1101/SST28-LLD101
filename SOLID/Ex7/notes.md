1. The Problem: The "Fat" Interface
Originally, the SmartClassroomDevice interface was overloaded with unrelated methods. This forced the AirConditioner to include dummy code for scanning attendance and the AttendanceScanner to implement power buttons it didn't have. This made the code rigid and misleading, as the interface didn't accurately model what the hardware could actually do.It is breaking the interface segregating principle

2. Our Approach: Capability-Based Interfaces
To solve this, we split the device capabilities into multiple, small interfaces:

Focused Interfaces: We created Powerable, BrightnessControllable, TempControllable, Scanable, and Connectable.

Clean Implementation: Now, the AirConditioner only implements Powerable and TempControllable. It no longer has "dummy" methods for brightness or HDMI inputs.

Registry-Based Selection: The DeviceRegistry uses generic types to return only the devices that support a specific capability. The ClassroomController now depends on these specific interfaces rather than one giant class.

Example

The Old Way (Problem):
If we added a Smart Board, we would have been forced to implement the entire SmartClassroomDevice interface. We would have had to write useless code for setTemperatureC() and scanAttendance() for SmartBoard making the code bad and violation ISP.

The New Way (Solution):

Select Capabilities: The SmartBoard would simply implement Powerable and Connectable.

No Junk Code: You don't have to write a single line of code for temperature or scanning.

Result: When the controller asks for all Powerable devices to shut them down, the Smart Board is automatically included in the list without the controller needing to know its specific class.