<h1>(TA)sker</h1>

<h2>Task Management System for Teaching Assistants</h2>

*(TA)sker*  provides a way for course coordinators or department heads
to assign Teaching Assistants to different tasks, such as but not limited to:
- Labs
- Office Hours
- Tutorials
- Exam Invigilation

During this time of online learning, managing schedules for course staff
spread out across the world has become **significantly** harder; *(TA)sker* 
aims to streamline workflows across departments by providing a central assignment
system. 


<h4>User Stories:</h4>
- As a user, I want to be able to create tasks/labs/tutorials for a course of 
my choice.
- As a user, I want to view all the tasks/labs/tutorials I have created. 
- As a user, I want to be able to select a task and mark it as complete.
- As a user, I want to be able to add an unspecified number of Tasks, Labs, or 
Tutorials to the schedule.
- As a user, I want to be able to save my schedule to file.
- As a user, I want to be able to load my schedule from a file and continue
with all scheduled events unchanged.

<h3>Phase 4: Task 3</h3>

Overall, I am quite happy with the design and implementation of my project. I needed to implement two very similar
objects, and I was able to create a type hierarchy by creating an abstract class. That minimized code duplication
and made testing both sub-classes easier. Other than that, the design of the model package was fairly 
straightforward and does not require any further refactoring. 

As it stands, my GUI class (TaskerGUI2) and the console-based application (TaskerApp) can be considered difficult
to read, even with all the methods documented appropriately. I could have refactored these classes to break them
down into classes that focused more on a specific function of the application, thus increasing readability
and cohesion between classes (single responsibility principle).  

Its possible that the code overall could have been a little neater had I used a Map to organize courses from 
the very beginning, however that itself wouldn't alter any functionality that the application currently 
performs.  



