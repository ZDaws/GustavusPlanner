# GustavusPlanner
GustavusPlanner is a course planning app for Gustavus Adolphus College made in MCS-270 (Object-Oriented Software).
Our app will provide Gustavus students with an easy way to visually plan out their schedules.
Students will be able to search from a master list of possible classes. After selecting a class, 
a visual block will appear on the weekly calendar. The ability to have a visual calendar indicates 
whether a possible schedule will work for students, or if a certain combination of classes cannot 
be taken in the same semester.
## Requirements
* Should be original and unique. Should meet some need.
  * GustavusPlanner is original because no such app exists for Gustavus students.
* Should use at least one external service
  * GustavusPlanner uses http to get the list of classes from the WebAdvisor database.
* Should use at least one device sensor
  * GustavusPlanner uses the accelerometer to determine if the user is holding the device in portrait or landscape mode.
* Must have a UI
  * GustavusPlanner is entirely UI based.
* Must have at least three domain objects
  * We would at least need one class for a schedule, one for a course, and classes for the different views within the app.
* Must have data that is persistent across sessions
  * GustavusPlanner will use an SQLite database to store the users schedules in the main memory so that they will be saved when the user closes the app.
## Schematics
This is an example of what the main schedule view will look like:
![Main schedule view](https://github.com/ZDaws/GustavusPlanner/blob/master/Schematics/Schedule%20mockup.png?raw=true)

The image on top is what the toolbar could look like and the image below is an example pop-up the user will recieve when adding a new course or extra curricular to their schedule:
![Tool bar view](https://github.com/ZDaws/GustavusPlanner/blob/master/Schematics/UI%20Planner.jpg?raw=true)
