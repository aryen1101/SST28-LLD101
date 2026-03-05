Problem ->

The original code for the GeoDash CLI tool is inefficient because of how it handles map markers.
We are trying to render 30,000 map pins on a map. with Every single pin stores its own copy of its style
If we have 10,000 markers that are all same the computer creates 10,000 identical objects in memory. This causes the application to use much more RAM than it actually needs.

Our Approach ->

We make this MarkerStyle immutable (using final fields and no setters) so that one marker cannott accidentally change the style for other.
Instead of creating a new style every time, we use a MarkerStyleFactory.
When a marker needs a style, it asks the Factory.
The Factory checks its cache
If that style already exists, the Factory gives the marker a reference (a pointer) to the existing one.
If it doesn't exist, the Factory creates it once and saves it for later.'
The MapMarker now only stores its unique location and label. For the style, we will have a MarkerStyle in the constructor of MapMarker which we will inject in MapMarker.
Now if we have 20000 objects but only 100 unique object then only 96 unique instance will be created.