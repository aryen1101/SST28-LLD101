Problem -> 
No Security: Every User has access to every files, any Student can read any internal file which only admin or faculty are supposed to read.
There was eagerLoading, content was loaded everytime we call the display method of ReportFile which is a very heavy process
and since this load process is happening everytime so even if the same person looked at the same report twice in a row, the system forgot it had just loaded it and did the slow disk-loading all over again.
We are using a ReportFile in ReportViewer.java and App.java since a higher level module is dependent on lower level module 
so DIP is violated.

Our Approach -> Proxy Design Pattern

Instead of letting everyone in, the Proxy first uses the AccessControl class to check permissions. If user is not allowed, the Proxy stops you immediately—before the slow disk-loading even starts.
We implemented Lazy Loading by keeping the RealReport reference null in ReportProxy until a valid request is made, saving memory and startup time. Now the heavy disc loading process will happen only when authorized user will click display.
We ensured the Proxy stores the RealReport after the first load, and now all next loads will be from the cache.
Now in App.java or ReportViewer instead of using ReportFile we will use ReportProxy in our code.