# Java Programming: Solving Problems With Software
My notes and code produced when going through [Duke University Coursera Course](https://www.coursera.org/learn/java-programming/home)

## Week 1
Mostly introductory videos plus some [programming resources](https://www.dukelearntoprogram.com//course2/index.php) and instructions how to use BlueJ

### Tips for Learning Programming
1. Do a little every day
2. Don't give up
3. Follow the seven-step process
4. Read the documentation
5. Use the live coding videos and assignments
6. Ask for help in the forums!

### Using Forums: How to Ask for Help Effectively
1. Check FAQ pages and existing threads before creating a new thread
2. Start a new thread if you have a new question
3. If you need to post code, use the code formatting box

## Fundamental Java Syntax and Semantics Module

> Information about BlueJ <br> - I am skipping this as I want to get used to IntelliJ
> <br><br>The BlueJ Environment download, documentation, and programming resources are available at:<br>
> http://www.dukelearntoprogram.com/course2/index.php
> <br><br>(Note that if you have already downloaded a version of BlueJ, you will need to uninstall and download this one to get the edu.duke library.)
> <br><br>BlueJ has provided a [playlist](https://www.youtube.com/watch?v=CPUaTT0Xoo4&list=PLYPWr4ErjcnzWB95MVvlKArO6PIfv1fHd) of videos explaining some key Java terminology and how to use BlueJ.
<br><br>

> [Getting edu.duke.* as External Library in IntelliJ](https://stackoverflow.com/questions/34445631/project-hierarchy-idea-rather-then-bluej)
> <br><br>
> [edu.duke.* course specific documentation](https://www.dukelearntoprogram.com/course2/doc/)

-> checkout the notes on your completed [previous course](https://github.com/aktyz/OReilly-the-complete-java)

## Solving Programming: A Seven-Step Approach
1. Work Example By Hand
2. Write Down What You Did
3. Find Patterns
4. Check By Hand
5. Translate To Code
6. Run Test Cases
7. Debug Failed Test Cases

Example: Finding the perimeter of a shape
1. Work Example By Hand - Draw any shape you want, mark its points and write their position, calculate the distance of each side of the shape, sum it to get perimeter
2. Write Down What You Did:<br>
   a. Found distance from 1st point to 2nd point<br>
   b. Found distance from 2nd point to 3rd point<br>
   c. Added two distances, creating its sum<br>
   d. Found distance from 3rd point to 4th point<br>
   e. Added new distance to our previous sum<br>
   f. Found distance from 4th point to 1st point<br>
   g. Added new distance to our previous sum<br>
   h. When we arrive back at 1st point, our sum is the answer<br>
3. Find Patterns, reorder & generalize:<br>
   a. Found distance from 1st point to 2nd point<br>
   b. Add new distance to 0, starting point for out sum
   c. Found distance from 2nd point to 3rd point<br>
   d. Added new distance to our previous sum<br>
   e. Found distance from 3rd point to 4th point<br>
   f. Added new distance to our previous sum<br>
   g. Found distance from 4th point to 1st point<br>
   h. Added new distance to our previous sum<br>
   i. When we arrive back at 1st point, our sum is the answer<br>
   <br>To arrive at:<br>
   ![](C:\Users\Zyta\Desktop\projekt\Duke_Java_Programming\Solving_Problems_With_Software\resources\getPerimeterPattern.PNG)
   <br>
4. Check By Hand - Test in writing on a different instance of a problem, for this example we will switch from trapezoid to triangle
5. Translate To Code - Have a look at the PerimeterRunner.java class in week1 package
6. Run Test Cases
7. Debug Failed Test Cases