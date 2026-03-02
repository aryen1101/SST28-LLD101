The Problem -> 
The starter code failed to be a Singleton because it left three major doors open for extra instances to be created:
The getInstance() method wasn't protected. If two threads asked for the instance at the exact same time, both would see INSTANCE as null and both would create their own separate objects.
To Solve this We used Double-Checked Locking with the volatile keyword.
Before creating the object, the code checks if it exists. If not, it locks the class so only one thread can go inside. Inside the lock, it checks one more time to be absolutely sure no one else finished the job while it was waiting.

Another problem was that 
The constructor was public. This meant anyone can simply type new MetricsRegistry() anywhere in the code, creating as many registries as they wanted.
Even if the constructor were private, anyone could use Java's reflection tools to force the constructor open and create more instance.
To solve this we  made the constructor private and added an Internal Guard.
If someone tries to use Reflection to force the constructor to run a second time, code checks: Does an instance already exist?
If it does, your code throws a RuntimeException, and no new instance will be created.

One more thing that
When Java saves an object to a file (serialization) and reads it back (deserialization), it normally ignores the Singleton rules and creates a new copy of the object.
To solve this
We implemented the readResolve() method.
This is a special hook for Java. When Java tries to load the registry from a file, readResolve() will not allow it create new instance it will return the one we already have in memory

Now instead of creating MetricsRegistry using new Keyword in MetricsLoader we will use MetricsRegistry.getInstance() method 
and it will return the instance and now our singleton design is preserved.