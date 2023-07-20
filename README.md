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

## Perimeter Assignment: Part 1

### Introduction

In this assignment, you will complete the PerimeterAssignmentRunner class to calculate lots of interesting facts about shapes. This class has been started for you in the BlueJ project called PerimeterAssignmentRunner (this is the same project file that we were looking at in the previous reading, so feel free to open the one you downloaded for the last reading). This project also contains several data files. In addition, you will need to look at the documentation for the Shape class and the Point class, which we went over in the last reading.

Our goals for this exercise are to:

1a. Complete writing the method getNumPoints that has one parameter s that is of type Shape. This method returns an integer that is the number of points in Shape s.

1b. Add code in the method testPerimeter to call getNumPoints and to print the result.

2a. Complete writing the method getAverageLength that has one parameter s that is of type Shape. This method returns a number of type double that is the calculated average of all the sides’ lengths in the Shape S.

2b. Add code in the method testPerimeter to call the method getAverageLength and to print out the result.
### Discussion
#### Complete the method getNumPoints

For this section, we need to complete the code for the method getNumPoints. We are instructed that the method has one parameter, s, that is a Shape-type object. This makes sense with the other code we’ve seen in this project, as the only shape-type object we’ve created is, in fact, named s. To understand how to show what parameter a method has, check out the code review we did in the last reading. (Hint: the getPerimeter method also has a parameter named s that is of type shape, but the getPerimeter method returns a double-type variable, whereas we want getNumPoints to return an int-type variable).

After passing the parameter along, we’ll need to write some language that will allow for this method to return an int that is the number of points in Shape s. This immediately tells us that at some point, we will need to declare an int-type variable to return at the end of this method (review the video about variables and types if you’re having trouble with variable declaration). This variable will be a counter for the number of points within a given shape, s, which means that it will need to be increased for each point in the shape, s. This tells us quite a bit about how we might translate that action into java syntax, namely that we’ll be using some sort of loop. For more information about writing code that iterates over an entire object, see the video “Seven Steps in Action: Translating to Code” and look into the code review for this exercise (Hint: the getPerimeter method has both a for each loop, and a variable that updates after each iteration).
Add Code in the Method testPerimeter to output the result

In this case, we’re simply looking to write some code that will output the result of the getNumPoints method. This tells us that within the testPerimeter method we’ll need to add a variable to correspond to the output of the getNumPoints method. The prompt told us that this method is supposed to output an int-type variable, which means that whatever variable we declare here will also need to be int-type. We’ll then need to initialize it to the output of the getNumPoints method for the shape s. After initialization, we’ll just need to add some code that will cause the system to output some text and our variable (Hint: the testPerimeter method already has examples of all of these processes).

At this point, it’s worth compiling your code and running it on some of the example text files included with the BlueJ project file. For the sake of this example, we’ll only use the example1.txt. When you run your program on example1.txt, it should tell you that the shape has four points. And if we open the text file itself, we can see that the shape does indeed have four points, so that checks out. You should run it on the other text files as well, to verify that it does check for the number of points in the shape, and does not just always output 4 points.
#### Complete the method getAverageLength

Before we can think about what code we would need to write to figure out the average side length for the shape s, we need to understand exactly what we’re trying to calculate, and then translate that to java syntax. In this case, a couple of things that help us, we know that the way to calculate the average side length is the (sum of all sides lengths) / (number of sides). Additionally, we know that the number of sides is equal to the number of points in a two dimensional shape. We already know how to code a method that can calculate the perimeter of a shape, and we know how to code a method that can count the number of points in a shape, so now it’s just a matter of writing a method that can do both and return a double-type variable that is the quotient of those two quantities.

One thing to keep in mind, however, is types. It’s important to remember that when you’ll be doing operations on more than one variable, you may need to make sure they’re the same type, or that you’re casting your variables correctly for the operation you’re attempting. For more information on types and casting, see the “Types” video. For example, the getPerimeter method uses double-type variables, and the getNumPoints method uses int-type variables.
#### Add Code to testPerim to output the result of getAverageLength

You’ll do this almost exactly the same you did for the getNumPoints method.

At this point, it’s worth testing your program again, and when you compile and run it on example1.txt, it should tell you that “the average length of a side in your shape is 4.0”.

This is where we’ll leave off with this exercise, but you’ll want to make sure you save all of your project files, as we’ll be using the exact same project files for the next few activities.

## Perimeter Assignment: Part 2

### Introduction
In this assignment, you will complete the PerimeterAssignmentRunner class to calculate lots of interesting facts about shapes. This class has been started for you in the BlueJ project called PerimeterAssignmentRunner (this is the same project file that you were using in the last exercise, so feel free to open it up again and continue working). The goals for this exercise are as follows:

1a. Complete writing the method getLargestSide that has one parameter s that is of type Shape. This method returns a number of type double that is the longest side in the Shape S.

1b. Add code in the method testPerimeter to call the method getLargestSide and to print out the result.

2a. Complete writing the method getLargestX that has one parameter s that is of type Shape. This method returns a number of type double that is the largest x value over all the points in the Shape s.

2b. Add code in the method testPerimeter to call the method getLargestX and to print out the result. Note if you were to select the file example1.txt, then the largest x value should be 4.0.
### Discussion
#### Complete the getLargestSide method and output the results

For this section, we’ve got to complete the getLargestSide method, which we know has a parameter s, of type shape. We learned in the last assignment and readings about how to show what kinds of parameters a method has, so make sure to reference that if you’re having trouble remembering how to get started. On paper, we’re simply trying to compare the length of all of the sides of shape s, and report the largest side. This tells us that we’ll need to be able to find the length of a side of a shape, but thankfully we already know how to do that from the other methods we’ve written and the Shape Class documentation (Hint: the length of a side of a shape is the distance between two points of the shape).

Additionally, we know that we need to compare all of the sides of the shape, which implies we will need to iterate through each side of the shape to find its length. An important thing to remember when you’re thinking about programming, is what your objective requirements are. In this case, we’re only trying to find what the longest side is, so we only need to know if any given side is the longest side. We know how to calculate the length of a side, we know how to iterate through each point in a shape, we know how to keep a running tally while iterating, and we know how to compare values (if this is giving you trouble, revisit the video on conditionals). From here, it’s simply putting it all together.

As always, when you’re done writing your code in the getLargestSide method, remember to add the code to call the getLargestSide method in the testPerimeter method and add the code to have the system print the output (the same way we did in the last exercise). As always, this is a great time to compile and test your code, and if you run this code using example1.txt as your shape file, then the longest side should be 5.0.
#### Complete the getLargestX method and output the results

Once again, for this section we know how to show what type of parameter a method has, and in this case we know that the getLargestX method will be outputting a double-type variable, so that’s a great place to start. From here, we know we’ll need to find the largest X value of any given point in shape S, so we’ll need to iterate through the points of the shape s and compare their x components (Hint: If you’re having trouble finding the x component of a point, make sure to check the Point class documentation in the course site). From here out, we know how to iterate through all the points in a shape, compare their values, and keep track of the largest value.

As always in these activities, call your getLargestX method in the testPerimeter method, and have the system output the results. If you run this section of code with example1.txt, the Largest X will be 4.0.

This is where we’ll leave off with this exercise, but you’ll want to make sure you save all of your project files, as we’ll be using the exact same project files for the next few activities.

## Perimeter Assignment: Part 2

### Introduction

In this assignment you will find the largest perimeter over several shapes by examining several files representing shapes, calculating the size of the largest perimeter and also the name of the file with the largest perimeter. You will add new methods to the PerimeterAssignmentRunner class. You may find it helpful to review the DirectoryResource and FileResource documentation.

The PerimeterAssignmentRunner class already includes the printFileNames method. You should understand the following: The printFileNames method has no parameters and no return value, hence return type void. This method first creates a DirectoryResource. When this happens you are prompted to select a file or files. You can select a bunch of files together by clicking on the name of one file, and then hold down the shift key and select a second file. All the files between the first and second file will be highlighted. The code then iterates over all the files you have selected using a for loop and the selectedFiles method, printing out the filename for each file.

For this assignment, you will add or modify several methods in the PerimeterAssigmentRunner class. The Goals for this exercise are as follows

1. Complete writing the method getLargestPerimeterMultipleFiles that has no parameters. This method creates a DirectoryResource (so you can select multiple files) and then iterates over these files. For each File f, it converts the file into a FileResource with the line   
   ```java
   FileResource fr = new FileResource(f);
   ```

   Then it should create a Shape from the FileResource and calculate that shape’s perimeter, and return the largest perimeter over all the shapes in the files you have selected.

2. Finish writing the void method testPerimeterMultipleFiles to call getLargestPerimeterMultipleFiles and to print out the largest such perimeter. This method has no parameters and no return value. You will select the files when you run this method (hint: see our documentation for the DirectoryResource class).

3. Finish writing the method getFileWithLargestPerimeter that has no parameters. This method should create its own Directory Resource, except that this new method returns the name of the File that has the largest such perimeter, so it has return type String.

4. Add code to the method testFileWithLargestPerimeter to call getFileWithLargestPerimeter. For the File that is returned, print the name of that file.
### Discussion
#### Complete the method getLargestPerimeterMultipleFiles

Immediately, we know that this method should return a double-type variable, as it should be the largest perimeter from a selection of files. Before we try to create this method from scratch, however, let’s take a look at the printFileNames method. It has no return value, hence the type void, but it gives us the syntax for creating a DirectoryResource object (which allows us to select multiple files), and the syntax to create a “for each” loop that iterates through each selected file. Sometimes it’s useful to read the “for each” loop aloud, and in the printFileNames method it reads as “for each File f in the directory object, execute this code:”, which reminds us that there is a File object named f, that we can reference if needed. That’s why we’ll use the line mentioned in the goals above:
```java
   FileResource fr = new FileResource(f);
```

When placed inside the DirectoryResource “for each” loop we see in the printFileNames method, we can have the program make a new FileResource object for each File object, f. After this, we simply need to use each FileResource object to make a new shape and find its perimeter (Hint: if you’re confused about this step, see the testPerimeter method we’ve used in the last few exercises). After we have the perimeter for any given shape in a file resource, we just need to compare them to find which file has the largest perimeter (similar to the previous exercise where we compared the largest sides / x-values, and only kept track of the largest). When this method has finished running, it should return a double-type variable of the largest perimeter across all selected files.
#### Complete the void method testPerimeterMultipleFiles

This is the method that will receive and print the data returned from the getLargestPerimeterMultipleFiles method, so we know that immediately we’ll need to initialize a variable of the type returned by getLargestPerimeterMultipleFiles. In this case, that’s a double-type variable, which we’ll initialize as the output of the getLargestPerimeterMultipleFiles method. From this point, you’ll just need to write the code to have the system output the results, as you have in the past few exercises we’ve worked on. In this case, your results will vary based on which files you choose to test your program with. However, you should be able to verify the validity of these results by cross referencing the results with the output from your functional testPerimeter method.

One very important thing to remember is that the compiled program always runs starting from the main method (Tip: If you’re not seeing the output of your testPerimeterMultipleFiles method, make sure that you are calling that method in the main method. This will use similar syntax to calling the testPerimeter method that we’ve been using for the last two exercises).
#### Complete the getFileWithLargestPerimeter method

The first thing you’ll notice about this method is that there is already some code started for you. The following line is initializing an object with an empty value, presumably so that we can later update this value with something meaningful.

The end goal of this method is to do the same thing as the getLargestPerimeterMultipleFiles method, except that we want to return the String-type value that represents the filename which contains the shape with the largest perimeter. With this in mind, we should be able to borrow much of the syntax from getLargestPerimeterMultipleFiles, except for this method we need to update a file object every time we find a shape that has a larger perimeter than the current maximum. We’ve updated variables in a loop using conditionals in the last exercise, and updating objects works the same way.

At the end of this method, we also see that it is returning the output of the getName method on the File-type object temp (for more information, check out the documentation for the File Class here). The important thing for you to know about the getName method is that it outputs the name of a File object as a String, which is the type of output we want for the getFileWithLargestPerimeter method.
#### Complete the void method testFileWithLargestPerimeter

This will be the method that we use to call the getFileWithLargestPerimeter method, so we will need to initialize a variable as the output of the getFileWithLargestPerimeter method. After that, all you need to do is write the code to have the system output the results, the same as the past few exercises. Once again, your answers will vary depending on which files you’ve selected to test your program with, but you should be able to verify your results with your functional testPerimeter program.

Again, don’t forget to call testFileWithLargestPerimeter in the main method, or you will not be seeing the output of this method when you run your file. Once you’ve verified that your program functions correctly, you can save your files, and you’re ready to take the quiz! 


