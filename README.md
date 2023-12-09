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

### Fundamental Java Syntax and Semantics Module

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

### Solving Programming: A Seven-Step Approach
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
   ![](C:\Users\Zyta\Desktop\projekt\Duke_Java_Programming\Solving_Problems_With_Software\resources\week1\getPerimeterPattern.PNG)
   <br>
4. Check By Hand - Test in writing on a different instance of a problem, for this example we will switch from trapezoid to triangle
5. Translate To Code - Have a look at the PerimeterRunner.java class in week1 package
6. Run Test Cases
7. Debug Failed Test Cases

### Perimeter Assignment: Part 1

#### Introduction

In this assignment, you will complete the PerimeterAssignmentRunner class to calculate lots of interesting facts about shapes. This class has been started for you in the BlueJ project called PerimeterAssignmentRunnerStarterCode (this is the same project file that we were looking at in the previous reading, so feel free to open the one you downloaded for the last reading). This project also contains several data files. In addition, you will need to look at the documentation for the Shape class and the Point class, which we went over in the last reading.

Our goals for this exercise are to:

1a. Complete writing the method getNumPoints that has one parameter s that is of type Shape. This method returns an integer that is the number of points in Shape s.

1b. Add code in the method testPerimeter to call getNumPoints and to print the result.

2a. Complete writing the method getAverageLength that has one parameter s that is of type Shape. This method returns a number of type double that is the calculated average of all the sides’ lengths in the Shape S.

2b. Add code in the method testPerimeter to call the method getAverageLength and to print out the result.
#### Discussion
##### Complete the method getNumPoints

For this section, we need to complete the code for the method getNumPoints. We are instructed that the method has one parameter, s, that is a Shape-type object. This makes sense with the other code we’ve seen in this project, as the only shape-type object we’ve created is, in fact, named s. To understand how to show what parameter a method has, check out the code review we did in the last reading. (Hint: the getPerimeter method also has a parameter named s that is of type shape, but the getPerimeter method returns a double-type variable, whereas we want getNumPoints to return an int-type variable).

After passing the parameter along, we’ll need to write some language that will allow for this method to return an int that is the number of points in Shape s. This immediately tells us that at some point, we will need to declare an int-type variable to return at the end of this method (review the video about variables and types if you’re having trouble with variable declaration). This variable will be a counter for the number of points within a given shape, s, which means that it will need to be increased for each point in the shape, s. This tells us quite a bit about how we might translate that action into java syntax, namely that we’ll be using some sort of loop. For more information about writing code that iterates over an entire object, see the video “Seven Steps in Action: Translating to Code” and look into the code review for this exercise (Hint: the getPerimeter method has both a for each loop, and a variable that updates after each iteration).
Add Code in the Method testPerimeter to output the result

In this case, we’re simply looking to write some code that will output the result of the getNumPoints method. This tells us that within the testPerimeter method we’ll need to add a variable to correspond to the output of the getNumPoints method. The prompt told us that this method is supposed to output an int-type variable, which means that whatever variable we declare here will also need to be int-type. We’ll then need to initialize it to the output of the getNumPoints method for the shape s. After initialization, we’ll just need to add some code that will cause the system to output some text and our variable (Hint: the testPerimeter method already has examples of all of these processes).

At this point, it’s worth compiling your code and running it on some example text files included with the BlueJ project file. For the sake of this example, we’ll only use the example1.txt. When you run your program on example1.txt, it should tell you that the shape has four points. And if we open the text file itself, we can see that the shape does indeed have four points, so that checks out. You should run it on the other text files as well, to verify that it does check for the number of points in the shape, and does not just always output 4 points.
##### Complete the method getAverageLength

Before we can think about what code we would need to write to figure out the average side length for the shape s, we need to understand exactly what we’re trying to calculate, and then translate that to java syntax. In this case, a couple of things that help us, we know that the way to calculate the average side length is the (sum of all sides lengths) / (number of sides). Additionally, we know that the number of sides is equal to the number of points in a two-dimensional shape. We already know how to code a method that can calculate the perimeter of a shape, and we know how to code a method that can count the number of points in a shape, so now it’s just a matter of writing a method that can do both and return a double-type variable that is the quotient of those two quantities.

One thing to keep in mind, however, is types. It’s important to remember that when you’ll be doing operations on more than one variable, you may need to make sure they’re the same type, or that you’re casting your variables correctly for the operation you’re attempting. For more information on types and casting, see the “Types” video. For example, the getPerimeter method uses double-type variables, and the getNumPoints method uses int-type variables.
##### Add Code to testPerim to output the result of getAverageLength

You’ll do this almost exactly the same you did for the getNumPoints method.

At this point, it’s worth testing your program again, and when you compile and run it on example1.txt, it should tell you that “the average length of a side in your shape is 4.0”.

This is where we’ll leave off with this exercise, but you’ll want to make sure you save all of your project files, as we’ll be using the exact same project files for the next few activities.

### Perimeter Assignment: Part 2

#### Introduction
In this assignment, you will complete the PerimeterAssignmentRunner class to calculate lots of interesting facts about shapes. This class has been started for you in the BlueJ project called PerimeterAssignmentRunner (this is the same project file that you were using in the last exercise, so feel free to open it up again and continue working). The goals for this exercise are as follows:

1a. Complete writing the method getLargestSide that has one parameter s that is of type Shape. This method returns a number of type double that is the longest side in the Shape S.

1b. Add code in the method testPerimeter to call the method getLargestSide and to print out the result.

2a. Complete writing the method getLargestX that has one parameter s that is of type Shape. This method returns a number of type double that is the largest x value over all the points in the Shape s.

2b. Add code in the method testPerimeter to call the method getLargestX and to print out the result. Note if you were to select the file example1.txt, then the largest x value should be 4.0.
#### Discussion
##### Complete the getLargestSide method and output the results

For this section, we’ve got to complete the getLargestSide method, which we know has a parameter s, of type shape. We learned in the last assignment and readings about how to show what kinds of parameters a method has, so make sure to reference that if you’re having trouble remembering how to get started. On paper, we’re simply trying to compare the length of all the sides of shape s, and report the largest side. This tells us that we’ll need to be able to find the length of a side of a shape, but thankfully we already know how to do that from the other methods we’ve written and the Shape Class documentation (Hint: the length of a side of a shape is the distance between two points of the shape).

Additionally, we know that we need to compare all the sides of the shape, which implies we will need to iterate through each side of the shape to find its length. An important thing to remember when you’re thinking about programming, is what your objective requirements are. In this case, we’re only trying to find what the longest side is, so we only need to know if any given side is the longest side. We know how to calculate the length of a side, we know how to iterate through each point in a shape, we know how to keep a running tally while iterating, and we know how to compare values (if this is giving you trouble, revisit the video on conditionals). From here, it’s simply putting it all together.

As always, when you’re done writing your code in the getLargestSide method, remember to add the code to call the getLargestSide method in the testPerimeter method and add the code to have the system print the output (the same way we did in the last exercise). As always, this is a great time to compile and test your code, and if you run this code using example1.txt as your shape file, then the longest side should be 5.0.
##### Complete the getLargestX method and output the results

Once again, for this section we know how to show what type of parameter a method has, and in this case we know that the getLargestX method will be outputting a double-type variable, so that’s a great place to start. From here, we know we’ll need to find the largest X value of any given point in shape S, so we’ll need to iterate through the points of the shape s and compare their x components (Hint: If you’re having trouble finding the x component of a point, make sure to check the Point class documentation in the course site). From here out, we know how to iterate through all the points in a shape, compare their values, and keep track of the largest value.

As always in these activities, call your getLargestX method in the testPerimeter method, and have the system output the results. If you run this section of code with example1.txt, the Largest X will be 4.0.

This is where we’ll leave off with this exercise, but you’ll want to make sure you save all of your project files, as we’ll be using the exact same project files for the next few activities.

### Perimeter Assignment: Part 3

#### Introduction

In this assignment you will find the largest perimeter over several shapes by examining several files representing shapes, calculating the size of the largest perimeter and also the name of the file with the largest perimeter. You will add new methods to the PerimeterAssignmentRunner class. You may find it helpful to review the DirectoryResource and FileResource documentation.

The PerimeterAssignmentRunner class already includes the printFileNames method. You should understand the following: The printFileNames method has no parameters and no return value, hence return type void. This method first creates a DirectoryResource. When this happens you are prompted to select a file or files. You can select a bunch of files together by clicking on the name of one file, and then hold down the shift key and select a second file. All the files between the first and second file will be highlighted. The code then iterates over all the files you have selected using a for loop and the selectedFiles method, printing out the filename for each file.

For this assignment, you will add or modify several methods in the PerimeterAssignmentRunner class. The Goals for this exercise are as follows

1. Complete writing the method getLargestPerimeterMultipleFiles that has no parameters. This method creates a DirectoryResource (so you can select multiple files) and then iterates over these files. For each File f, it converts the file into a FileResource with the line   
   ```java
   FileResource fr = new FileResource(f);
   ```

   Then it should create a Shape from the FileResource and calculate that shape’s perimeter, and return the largest perimeter over all the shapes in the files you have selected.

2. Finish writing the void method testPerimeterMultipleFiles to call getLargestPerimeterMultipleFiles and to print out the largest such perimeter. This method has no parameters and no return value. You will select the files when you run this method (hint: see our documentation for the DirectoryResource class).

3. Finish writing the method getFileWithLargestPerimeter that has no parameters. This method should create its own Directory Resource, except that this new method returns the name of the File that has the largest such perimeter, so it has return type String.

4. Add code to the method testFileWithLargestPerimeter to call getFileWithLargestPerimeter. For the File that is returned, print the name of that file.
#### Discussion
##### Complete the method getLargestPerimeterMultipleFiles

Immediately, we know that this method should return a double-type variable, as it should be the largest perimeter from a selection of files. Before we try to create this method from scratch, however, let’s take a look at the printFileNames method. It has no return value, hence the type void, but it gives us the syntax for creating a DirectoryResource object (which allows us to select multiple files), and the syntax to create a “for each” loop that iterates through each selected file. Sometimes it’s useful to read the “for each” loop aloud, and in the printFileNames method it reads as “for each File f in the directory object, execute this code:”, which reminds us that there is a File object named f, that we can reference if needed. That’s why we’ll use the line mentioned in the goals above:
```java
   FileResource fr = new FileResource(f);
```

When placed inside the DirectoryResource “for each” loop we see in the printFileNames method, we can have the program make a new FileResource object for each File object, f. After this, we simply need to use each FileResource object to make a new shape and find its perimeter (Hint: if you’re confused about this step, see the testPerimeter method we’ve used in the last few exercises). After we have the perimeter for any given shape in a file resource, we just need to compare them to find which file has the largest perimeter (similar to the previous exercise where we compared the largest sides / x-values, and only kept track of the largest). When this method has finished running, it should return a double-type variable of the largest perimeter across all selected files.
##### Complete the void method testPerimeterMultipleFiles

This is the method that will receive and print the data returned from the getLargestPerimeterMultipleFiles method, so we know that immediately we’ll need to initialize a variable of the type returned by getLargestPerimeterMultipleFiles. In this case, that’s a double-type variable, which we’ll initialize as the output of the getLargestPerimeterMultipleFiles method. From this point, you’ll just need to write the code to have the system output the results, as you have in the past few exercises we’ve worked on. In this case, your results will vary based on which files you choose to test your program with. However, you should be able to verify the validity of these results by cross-referencing the results with the output from your functional testPerimeter method.

One very important thing to remember is that the compiled program always runs starting from the main method (Tip: If you’re not seeing the output of your testPerimeterMultipleFiles method, make sure that you are calling that method in the main method. This will use similar syntax to calling the testPerimeter method that we’ve been using for the last two exercises).
##### Complete the getFileWithLargestPerimeter method

The first thing you’ll notice about this method is that there is already some code started for you. The following line is initializing an object with an empty value, presumably so that we can later update this value with something meaningful.

The end goal of this method is to do the same thing as the getLargestPerimeterMultipleFiles method, except that we want to return the String-type value that represents the filename which contains the shape with the largest perimeter. With this in mind, we should be able to borrow much of the syntax from getLargestPerimeterMultipleFiles, except for this method we need to update a file object every time we find a shape that has a larger perimeter than the current maximum. We’ve updated variables in a loop using conditionals in the last exercise, and updating objects works the same way.

At the end of this method, we also see that it is returning the output of the getName method on the File-type object temp (for more information, check out the documentation for the File Class here). The important thing for you to know about the getName method is that it outputs the name of a File object as a String, which is the type of output we want for the getFileWithLargestPerimeter method.
##### Complete the void method testFileWithLargestPerimeter

This will be the method that we use to call the getFileWithLargestPerimeter method, so we will need to initialize a variable as the output of the getFileWithLargestPerimeter method. After that, all you need to do is write the code to have the system output the results, the same as the past few exercises. Once again, your answers will vary depending on which files you’ve selected to test your program with, but you should be able to verify your results with your functional testPerimeter program.

Again, don’t forget to call testFileWithLargestPerimeter in the main method, or you will not be seeing the output of this method when you run your file. Once you’ve verified that your program functions correctly, you can save your files, and you’re ready to take the quiz! 

### Week 1 Completed
TODO: pass the quiz in the end of the week 1 once enrolled in the course

## Week 2
This module begins with a short presentation from Raluca Gordân, an assistant professor in Duke University’s Center for Genomic and Computational Biology, about an important problem genomics scientists encounter regularly: how to identify genes in a strand of DNA. To tackle this problem, you will need to understand strings: series of characters such as letters, digits, punctuation, etc. After learning about Java methods that work with strings, you will be able to find genes within a DNA string as well as tackle other string related problems, such as finding all the links in a web page. By the end of this module, you will be able to: (1) Use important methods for the Java String class; (2) Use conditionals, for loops, and while loops appropriately in a Java program; (3) Find patterns in the data represented by strings to help develop the algorithm for your program; (4) Understand the importance of designing programs that keep different data processing steps separate; (5) Use the StorageResource iterable for this course to store some data for further processing; and (6) Rely on Java documentation to better understand how to use different Java packages and classes.

### Part 1: Finding a Gene - Using the Simplified Algorithm

This assignment is to write the code from the lesson from scratch by following the steps below. This will help you see if you really understood how to put the code together, and might identify a part that you did not fully understand. If you get stuck, then you can go back and watch the coding videos that go with this lesson again. We recommend you try this with many of the future Java coding examples before starting programming exercises.

Specifically, you should do the following:

1. Create a new Java project named StringsFirstAssignments. You can put all the classes for this programming exercise in this project.

2. Create a new Java Class named Part1. The following methods go in this class.

3. Write the method findSimpleGene that has one String parameter dna, representing a string of DNA. This method does the following:
- Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string.
- Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found. If there is no such “TAA”, return the empty string.
- If the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.

4. Write the void method testSimpleGene that has no parameters. You should create five DNA strings. The strings should have specific test cases, such as: DNA with no “ATG”, DNA with no “TAA”, DNA with no “ATG” or “TAA”, DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene), and DNA with ATG, TAA and the substring between them is not a multiple of 3. For each DNA string you should:
- Print the DNA string.
- See if there is a gene by calling findSimpleGene with this string as the parameter. If a gene exists following our algorithm above, then print the gene, otherwise print the empty string.

### Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized

This assignment will determine if a DNA strand has a gene in it by using the simplified algorithm from the lesson, but organizing the code in a slightly different way. You will modify the method findSimpleGene to have three parameters, one for the DNA string, one for the start codon and one for the stop codon.

Specifically, you should do the following:

1. Create a new Java Class named Part2 in the StringsFirstAssignments project.

2. Copy and paste the two methods findSimpleGene and testSimpleGene  from the Part1 class into the Part2 class.

3. The method findSimpleGene has one parameter for the DNA string named dna. Modify findSimpleGene to add two additional parameters, one named startCodon for the start codon and one named stopCodon for the stop codon. What additional changes do you need to make for the program to compile? After making all changes, run your program to check that you get the same output as before.

4. Modify the findSimpleGene method to work with DNA strings that are either all uppercase letters such as “ATGGGTTAAGTC” or all lowercase letters such as “gatgctataat”. Calling findSimpleGene with “ATGGGTTAAGTC” should return the answer with uppercase letters, the gene “ATGGGTTAA”, and calling findSimpleGene with  “gatgctataat” should return the answer with lowercase letters, the gene “atgctataa”. HINT: there are two string methods toUpperCase() and toLowerCase(). If dna is the string “ATGTAA” then dna.toLowerCase() results in the string “atgtaa”.

### Part 3: Problem-Solving with Strings

This assignment will give you additional practice using String methods. You will write two methods to solve some problems using strings and a third method to test these two methods.

Specifically, you should do the following:

1. Create a new Java Class named Part3 in the StringsFirstAssignments project. Put the following methods in this class.

2. Write the method named twoOccurrences that has two String parameters named stringA and stringB. This method returns true if stringA appears at least twice in stringB, otherwise it returns false. For example, the call twoOccurrences(“by”, “A story by Abby Long”) returns true as there are two occurrences of “by”, the call twoOccurrences(“a”, “banana”) returns true as there are three occurrences of “a” so “a” occurs at least twice, and the call twoOccurrences(“atg”, “ctgtatgta”) returns false as there is only one occurrence of “atg”.

3. Write the void method named testing that has no parameters. This method should call twoOccurrences on several pairs of strings and print the strings and the result of calling twoOccurrences (true or false) for each pair. Be sure to test examples that should result in true and examples that should result in false.

4. Write the method named lastPart that has two String parameters named stringA and stringB. This method finds the first occurrence of stringA in stringB, and returns the part of stringB that follows stringA.  If stringA does not occur in stringB, then return stringB. For example, the call lastPart(“an”, “banana”) returns the string “ana”, the part of the string after the first “an”. The call lastPart(“zoo”, “forest”) returns the string “forest” since “zoo” does not appear in that word.

5. Add code to the method testing to call the method lastPart with several pairs of strings. For each call print the strings passed in and the result. For example, the output for the two calls above might be:
- The part of the string after an in banana is ana.
- The part of the string after zoo in forest is forest.

### Part 4: Finding Web Links

Write a program that reads the lines from the file at this [URL location](http://www.dukelearntoprogram.com/course2/data/manylinks.html), and prints each URL on the page that is a link to youtube.com. Assume that a link to youtube.com has no spaces in it and would be in the format (where [stuff] represents characters that are not verbatim): “http:[stuff]youtube.com[stuff]”

Here are suggestions to get started.

1. Create a new Java Class named Part4 in the StringsFirstAssignments project and put your code in that class.

2. Use URLResource to read the file at [URL location](http://www.dukelearntoprogram.com/course2/data/manylinks.html) word by word.

3. For each word, check to see if “youtube.com” is in it. If it is, find the double quote to the left and right of the occurrence of “youtube.com” to identify the beginning and end of the URL.  Note, the double quotation mark is a special character in Java. To look for a double quote, look for (\”), since the backslash (\) character indicates we want the literal quotation marks (“) and not the Java character. The string you search for would be written “\”” for one double quotation mark.

4. In addition to the String method indexOf(x, num), you might want to consider using the String method lastIndexOf(s, num) that can be used with two parameters s and num. The parameter s is the string or character  to look for,  and num is the last position in the string to look for it. This method returns the last match from the start of the string up to the num position, so it is a good option for finding the opening quotation mark of a string searching backward from “youtube.com.” More information on String methods can be found in the [Java documentation for Strings](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/String.html).

Caution: The word Youtube could appear in different cases such as YouTube, youtube, or YOUTUBE. You can find the URLs more easily by converting the string to lowercase. However, you will need the original string (with uppercase and lowercase letters) to view the YouTube URL to answer a quiz question because YouTube links are case sensitive. The link https://www.youtube.com/watch?v=ji5_MqicxSo is different than the link https://www.youtube.com/watch?v=ji5_mqicxso, where all the letters are lowercase.

### Part 1: Finding Many Genes

For files related to this assignment, visit the DukeLearnToProgram Project Resources page for [this course](http://www.dukelearntoprogram.com/course2/files.php).

This assignment is to write the code from the lesson to make the following improvements to your algorithm:

A. Find a gene in a strand of DNA where the stop codon could be any of the three stop codons “TAA”, “TAG”, or “TGA”.

B. Find all the genes (where the stop codon could be any of the three stop codons) in a strand of DNA.

This will help you see if you really understood how to put the code together, and might identify a part that you did not fully understand. If you get stuck, then you can go back and watch the coding videos that go with this lesson again.

Specifically, you should do the following:

1. Create a new Java project named StringsSecondAssignments. You can put all the classes for this programming exercise in this project.

2. Create a new Java Class named Part1. The following methods go in this class.

3. Write the method findStopCodon that has three parameters, a String parameter named dna, an integer parameter named startIndex that represents where the first occurrence of ATG occurs in dna, and a String parameter named stopCodon. This method returns the index of the first occurrence of stopCodon that appears past startIndex and is a multiple of 3 away from startIndex. If there is no such stopCodon, this method returns the length of the dna strand.

4. Write the void method testFindStopCodon that calls the method findStopCodon with several examples and prints out the results to check if findStopCodon is working correctly. Think about what types of examples you should check. For example, you may want to check some strings of DNA that have genes and some that do not. What other examples should you check?

5. Write the method findGene that has one String parameter dna, representing a string of DNA. In this method you should do the following:

   Find the index of the first occurrence of the start codon “ATG”. If there is no “ATG”, return the empty string.

   Find the index of the first occurrence of the stop codon “TAA” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”. Hint: call findStopCodon.

   Find the index of the first occurrence of the stop codon “TAG” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”. Find the index of the first occurrence of the stop codon “TGA” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”.

   Return the gene formed from the “ATG” and the closest stop codon that is a multiple of three away. If there is no valid stop codon and therefore no gene, return the empty string.

6. Write the void method testFindGene that has no parameters. You should create five DNA strings. The strings should have specific test cases such as DNA with no “ATG”, DNA with “ATG” and one valid stop codon, DNA with “ATG” and multiple valid stop codons, DNA with “ATG” and no valid stop codons. Think carefully about what would be good examples to test. For each DNA string you should:

   Print the DNA string.

   Calculate the gene by sending this DNA string as an argument to findGene. If a gene exists following our algorithm above, then print the gene, otherwise print the empty string.

7. Write the void method printAllGenes that has one String parameter dna, representing a string of DNA. In this method you should repeatedly find genes and print each one until there are no more genes. Hint: remember you learned a while(true) loop and break.

### Part 2: HowMany - Finding Multiple Occurrences

This assignment will write a method to determine how many occurrences of a string appear in another string.

Specifically, you should do the following:

1. Create a new Java Class named Part2 in the StringsSecondAssignments project.

2. Write the method named howMany that has two String parameters named stringA and stringB. This method returns an integer indicating how many times stringA appears in stringB, where each occurrence of stringA must not overlap with another occurrence of it. For example, the call howMany(“GAA”, “ATGAACGAATTGAATC”) returns 3 as GAA occurs 3 times. The call howMany(“AA”, “ATAAAA”) returns 2. Note that the AA’s found cannot overlap.

3. Write the void method testHowMany has no parameters. Add code in here to call howMany with several examples and print the results. Think carefully about what types of examples would be good to test to make sure your method works correctly.

### Part 3: How Many Genes?

Write a program to count how many genes are in a strand of DNA.

Specifically, you should do the following:

1. Create a new Java Class named Part3 in the StringsSecondAssignments project. Put the following methods in this class.

2. Copy your methods from Part1 to find one gene and print all genes.

3. Write the method named countGenes that has a String parameter named dna representing a string of DNA. This method returns the number of genes found in dna. For example the call countGenes(“ATGTAAGATGCCCTAGT”) returns 2, finding the gene ATGTAA first and then the gene ATGCCCTAG. Hint: This is very similar to finding all genes and printing them, except that instead of printing all the genes you will count them.

4. Write the void method named testCountGenes that has no parameters.  This method calls countGenes with many example strings and prints the result for each. You should create several examples with different numbers of genes to test your code.

### Part 1: Storing All Genes

This assignment is to write the code from the lesson to use a StorageResource to store the genes you find instead of printing them out. This will help you see if you really understood how to put the code together, and might identify a part that you did not fully understand. If you get stuck, then you can go back and watch the coding videos that go with this lesson again.

Specifically, you should do the following:

1. Create a new Java project named StringsThirdAssignments. You can put all the classes for this programming exercise in this project.

2. Create a new Java Class named Part1. Copy and paste the code from your Part1 class in your StringsSecondAssignments project into this class.

3. Make a copy of the printAllGenes method called getAllGenes. Instead of printing the genes found, this method should create and return a StorageResource containing the genes found. Remember to import the edu.duke libraries otherwise you will get an error message cannot find the class StorageResource.

4. Make sure you test your getAllGenes method.

### Part 2: Storing All Genes

Write the method cgRatio that has one String parameter dna, and returns the ratio of C’s and G’s in dna as a fraction of the entire strand of DNA. For example if the String were “ATGCCATAG,” then cgRatio would return 4/9 or .4444444.

Hint: 9/2 uses integer division because you are dividing an integer by an integer and thus Java thinks you want the result to be an integer. If you want the result to be a decimal number, then make sure you convert one of the integers to a decimal number by changing it to a float. For example, (float) 9/2 is interpreted by Java as 9.0/2 and if one of the numbers is a decimal, then Java assumes you want the result to be a decimal number. Thus (float) 9/2 is 4.5.

Write a method countCTG that has one String parameter dna, and returns the number of times the codon CTG appears in dna.

### Part 3: Storing All Genes

Write the void method processGenes that has one parameter sr, which is a StorageResource of strings. This method processes all the strings in sr to find out information about them. Specifically, it should:
- print all the Strings in sr that are longer than 9 characters
- print the number of Strings in sr that are longer than 9 characters
- print the Strings in sr whose C-G-ratio is higher than 0.35
- print the number of strings in sr whose C-G-ratio is higher than 0.35
- print the length of the longest gene in sr

Write a method testProcessGenes. This method will call your processGenes method on different test cases. Think of five DNA strings to use as test cases. These should include: one DNA string that has some genes longer than 9 characters, one DNA string that has no genes longer than 9 characters, one DNA string that has some genes whose C-G-ratio is higher than 0.35, and one DNA string that has some genes whose C-G-ratio is lower than 0.35. Write code in testProcessGenes to call processGenes five times with StorageResources made from each of your five DNA string test cases.

We have some real DNA for you to test your code on. Download the file brca1line.fa from the DukeLearnToProgram Project Resources page. Make sure you save it in your BlueJ project so that your code can access it. You can use a FileResource to open the file and the FileResource method asString to convert the contents of the file to a single string so that you can use it like the other DNA strings you have been using. Here is an example:
```java
FileResource fr = new FileResource("brca1line.fa");
String dna = fr.asString();
```
Modify your processGenes method so that it prints all the Strings that are longer than 60 characters and prints the number of Strings that are longer than 60 characters (you do not need to make changes to the rest of the method).

Modify the method testProcessGenes to call processGenes with a StorageResource of the genes found in the file brca1line.fa.

## Week 3
CSV Files and Basic Statistics in Java Module

A common format for storing tabular data (any data organized into columns and rows) is in comma separated values (CSV) files. In this module, you will learn how to analyze and manipulate data from multiple CSV data files using a powerful open-source software package: Apache Commons CSV. Using this library will empower you to solve problems that could prove too complex to solve with a spreadsheet.

[Apache Commons CSV Library Documentation](https://commons.apache.org/proper/commons-csv/)
[Remainder on mapping external library in IntelliJ as module rather than downloading through POM.](https://stackoverflow.com/questions/34445631/project-hierarchy-idea-rather-then-bluej)

### Programming exercise: Parsing Export Data

The CSV file exportdata.csv has information on the export products of countries. In particular it has three column headers labeled Country, Exports, and Value (dollars):
- The Country column represents a country from the world,
- the Exports column is a list of export items for a country,
- and the Value (dollars) column is the dollar amount in millions of their exports in the format of a dollar sign, followed by an integer number with a comma separator every three digits from the right. An example of such a value might be “$400,000,000”.

The CSV file exports_small.csv is a smaller version of the file above with the same columns that you may find helpful in testing your program. We show a picture of it here.

Exercise requirements:
- [x] Write a method named `tester` that will create your CSVParser and call each of the methods below in parts 2, 3, 4, and 5. You would start your code with:
   ```java
      FileResource fr = new FileResource();
      CSVParser parser = fr.getCSVParser();
   ```
   Each time you want to use the parser with another method, you will need to reset the parser by calling ```fr.getCSVParser()``` again to get a new parser.
- [x] Write a method named `countryInfo` that has two parameters, `parser` is a `CSVParser` and `country` is a `String`. This method returns a string of information about the country or returns `“NOT FOUND”` if there is no information about the country. The format of the string returned is the country, followed by “: “, followed by a list of the countries’ exports, followed by “: “, followed by the countries export value. For example, using the file `exports_small.csv` and the country Germany, the program returns the string:
   ```java
   Germany: motor vehicles, machinery, chemicals: $1,547,000,000,000
   ```
- [x] Write a void method named `listExportersTwoProducts` that has three parameters, `parser` is a `CSVParser`, `exportItem1` is a `String` and `exportItem2` is a `String`. This method prints the names of all the countries that have both `exportItem1` and `exportItem2` as export items. For example, using the file `exports_small.csv`, this method called with the items “gold” and “diamonds” would print the countries:
   ```java
   Namibia
   South Africa
   ```
- [x] Write a method named `numberOfExporters`, which has two parameters, `parser` is a `CSVParser`, and `exportItem` is a `String`. This method returns the number of countries that export `exportItem`. For example, using the file `exports_small.csv`, this method called with the item “gold” would return 3.
- [x] Write a void method named `bigExporters` that has two parameters, `parser` is a `CSVParser`, and `amount` is a `String` in the format of a dollar sign, followed by an integer number with a comma separator every three digits from the right. An example of such a string might be “$400,000,000”. This method prints the names of countries and their Value amount for all countries whose Value (dollars) string is longer than the amount string. You do not need to parse either string value as an integer, just compare the lengths of the strings. For example, if `bigExporters` is called with the file `exports_small.csv` and amount with the string `$999,999,999`, then this method would print eight countries and their export values shown here:
   ```java
   Germany $1,547,000,000,000
   Macedonia $3,421,000,000
   Malawi $1,332,000,000
   Malaysia $231,300,000,000
   Namibia $4,597,000,000
   Peru $36,430,000,000
   South Africa $97,900,000,000
   United States $1,610,000,000,000
   ```

### Programming Exercise: Parsing Weather Data

You will write a program to find the coldest day of the year and other interesting facts about the temperature and humidity in a day. To test your program, you will use the `nc_weather` data folder that has a folder for each year; you can download a `.zip` folder with these files by clicking [here](https://www.dukelearntoprogram.com//course2/files.php). In the `year` folder there is a CSV file for every day of the year.

Exercise requirements:
- [x] Write a method named `coldestHourInFile` that has one parameter, a `CSVParser` named `parser`. This method returns the `CSVRecord` with the coldest temperature in the file and thus all the information about the coldest temperature, such as the hour of the coldest temperature. You should also write a `void` method named `testColdestHourInFile()` to test this method and print out information about that coldest temperature, such as the time of its occurrence.
      **NOTE:** Sometimes there was not a valid reading at a specific hour, so the temperature field says `-9999`. You should ignore these bogus temperature values when calculating the lowest temperature.
- [x] Write the method `fileWithColdestTemperature` that has no parameters. This method should return a `string` that is the name of the file from selected files that has the coldest temperature. You should also write a `void` method named `testFileWithColdestTemperature()` to test this method. Note that after determining the filename, you could call the method `coldestHourInFile` to determine the coldest temperature on that day. When `fileWithColdestTemperature` runs and selects the files for January 1–3 in 2014, the method should print out:
     ```txt
     Coldest day was in file weather-2014-01-03.csv
     Coldest temperature on that day was 21.9
     All the Temperatures on the coldest day were:
     2014-01-03 05:51:00: 41.0
     2014-01-03 06:51:00: 39.0
     2014-01-03 07:51:00: 35.1
     2014-01-03 08:51:00: 30.9
     2014-01-03 09:51:00: 28.0
     2014-01-03 10:51:00: 25.0
     2014-01-03 11:51:00: 24.1
     2014-01-03 12:51:00: 23.0
     2014-01-03 13:51:00: 25.0
     2014-01-03 14:51:00: 26.1
     2014-01-03 15:51:00: 28.0
     2014-01-03 16:51:00: 30.0
     2014-01-03 17:51:00: 30.9
     2014-01-03 18:51:00: 33.1
     2014-01-03 19:51:00: 33.1
     2014-01-03 20:51:00: 33.1
     2014-01-03 21:51:00: 30.9
     2014-01-03 22:51:00: 28.9
     2014-01-03 23:51:00: 28.9
     2014-01-04 00:51:00: 26.1
     2014-01-04 01:51:00: 24.1
     2014-01-04 02:51:00: 24.1
     2014-01-04 03:51:00: 23.0
     2014-01-04 04:51:00: 21.9
     ```
- [x] Write a method named `lowestHumidityInFile` that has one parameter, a `CSVParser` named `parser`. This method returns the `CSVRecord` that has the lowest humidity. If there is a tie, then return the first such record that was found. Note that sometimes there is not a number in the Humidity column but instead there is the string `“N/A”`. This only happens very rarely. You should check to make sure the value you get is not `“N/A”` before converting it to a number. Also note that the header for the time is either `TimeEST` or `TimeEDT`, depending on the time of year. You will instead use the `DateUTC` field at the right end of the data file to get both the date and time of a temperature reading.
     You should also write a void method named `testLowestHumidityInFile()` to test this method that starts with these lines:
     ```txt
     FileResource fr = new FileResource();
     CSVParser parser = fr.getCSVParser();
     CSVRecord csv = lowestHumidityInFile(parser);
     ```
     and then prints the lowest humidity AND the time the lowest humidity occurred. For example, for the file `weather-2014-01-20.csv`, the output should be:
     ```txt
     Lowest Humidity was 24 at 2014-01-20 19:51:00
     ```
     **NOTE** If you look at the data for January 20, 2014, you will note that the Humidity was also 24 at 3:51pm, but you are supposed to return the first such record that was found.
- [x] Write the method `lowestHumidityInManyFiles` that has no parameters. This method returns a `CSVRecord` that has the lowest humidity over all the files. If there is a tie, then return the first such record that was found. You should also write a void method named `testLowestHumidityInManyFiles()` to test this method and to print the lowest humidity AND the time the lowest humidity occurred. Be sure to test this method on two files so you can check if it is working correctly. If you run this program and select the files for January 19, 2014 and January 20, 2014, you should get:
     ```txt
     Lowest Humidity was 24 at 2014-01-20 19:51:00
     ```
- [x] Write the method `averageTemperatureInFile` that has one parameter, a `CSVParser` named `parser`. This method returns a `double` that represents the average temperature in the file. You should also write a void method named `testAverageTemperatureInFile()` to test this method. When this method runs and selects the file for January 20, 2014, the method should print out:
     ```txt
     Average temperature in file is 44.93333333333334
     ```
- [x] Write the method `averageTemperatureWithHighHumidityInFile` that has two parameters, a `CSVParser` named `parser` and an `integer` named `value`. This method returns a `double` that represents the average temperature of only those temperatures when the humidity was greater than or equal to value. You should also write a void method named `testAverageTemperatureWithHighHumidityInFile()` to test this method. When this method runs checking for humidity greater than or equal to 80 and selects the file for January 20, 2014, the method should print out:
     ```txt
     No temperatures with that humidity
     ```
     If you run the method checking for humidity greater than or equal to 80 and select the file March 20, 2014, a wetter day, the method should print out:
     ```txt
     Average Temp when high Humidity is 41.78666666666667
     ```

## Summary of the first three weeks
Given that I took a break of two months past the second week, I failed the evaluation of the second week. I need to revise Strings.

### Summary of Strings Revision

Useful Built-In Methods in JAVA String class:
```java
String s = "dukeProgramming";
/** the below method will give you a s substring of "pro" (7 - 4 = 3) */
String sub = s.substring(4,7);
int lenght = s.lenght(); // quite obvious
int programIndex = s.indexOf("Program"); // will return the startIndex of "Program", that is **4**
int gIndex = s.indexOf("g"); // gIndex will be assigned **7**
int fIndex = s.indexOf("f"); // fIndex will be assigned **-1** as there is no "f" in our string
int secondGIndex = s.indexOf("g", 8); // secondGIndex will be assigned **14**
boolean startsWith = s.startsWith("duke"); // startsWith will be assigned **true**
boolean endsWith = s.endsWith("king"); // endsWith will be assigned **false**
```

Consult [documentation!](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/String.html)

Newly written code in [src/main/java/org/coursera/duke/java/week2/revision](src/main/java/org/coursera/duke/java/week2/revision)

`StorageResource` from duke package is for now replacing `ArrayList` from Java Library.

## Week 4 - Baby Names MiniProject

For this assignment, we are providing data on baby names from the United States and you will answer questions about this data. The data files give information on the first names of people born in a particular year. We have data from 1880 through 2014 on both boys and girls names.

Let's have a look at the beggining of `yob2014.csv` file:
```txt
Emma,F,20799
Olivia,F,19674
Sophia,F,18490
Isabella,F,16950
Ava,F,15586
Mia,F,13442
Emily,F,12562
Abigail,F,11985
Madison,F,10247
Charlotte,F,10048
Harper,F,9564
Sofia,F,9542
```
the extract shows that `Emma` is the most popular name, the `F` is for female and the `20799` indicates the number of Emma’s born in 2014. The file lists all the girls first, and they are listed in order based on the number of births, from largest numbers to smallest numbers.

Another snapshot of the file shows the end of the girl's names list and the start of the boy's names list
```txt
Zykeriah,F,5
Zylynn,F,5
Zyrihanna,F,5
Zyriyah,F,5
Noah,M,19144
Liam,M,18342
Mason,M,17092
Jacob,M,16712
William,M,16687
Ethan,M,15619
Michael,M,15323
```
You can see that `Noah` was the most popular boys name in 2014, the `M` indicates a male, and `19144` is the number of boys named Noah that year. Also notice there are no headers in this file. The video showed you how to access the fields in a .csv file when there are no headers. The code is already in the project under `feat: Understanding Week 4 Project Data` commit.

Since these data files are quite large, we will also provide three small files with fake data for testing. You can find `yob2012short.csv`, `yob2013short.csv` and `yob2014short.csv` in [/resources/week4/us_babynames_test](resources/week4/us_babynames_test). The three files have only ten lines each, 5 girls and 5 boys names, and smaller numbers to work with.

You will write a program with several methods and tester methods to test each method you write. You should start with understanding the methods shown in the video. Specifically you should write the following methods:
- [x] Modify the method `totalBirths` (shown in the video for this project) to also print the number of girls names , the number of boys names and the total names in the file.
- [x] Write the method named `getRank` that has three parameters: an `integer` named `year`, a `string` named `name`, and a `string` named `gender` (`F` for female and `M` for male). This method returns the rank of the name in the file for the given gender, where rank 1 is the name with the largest number of births. If the name is not in the file, then `-1` is returned. For example, in the file `yob2012short.csv`, given the name `Mason`, the year `2012` and the gender `M`, the number returned is `2`, as `Mason` is the boys name with the second highest number of births. Given the name `Mason`, the year `2012` and the gender `F`, the number returned is `-1` as `Mason` does not appear with an `F` in that file.
- [x] Write the method named `getName` that has three parameters: an `integer` named `year`, an `integer` named `rank`, and a `string` named `gender` (`F` for female and `M` for male). This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then `NO NAME`  is returned.
- [x] What would your name be if you were born in a different year? Write the void method named `whatIsNameInYear` that has four parameters: a `String name`, an `integer` named `year` representing the year that name was born, an `integer` named `newYear` and a `string` named `gender` (`F` for female and `M` for male). This method determines what name would have been named if they were born in a different year, based on the same popularity. That is, you should determine the rank of name in the year they were born, and then print the name born in `newYear` that is at the same rank and same gender. For example, using the files `yob2012short.csv` and `yob2014short.csv`, notice that **in 2012 `Isabella` is the third most popular girl's name**. If `Isabella` was born in 2014 instead, she would have been named `Sophia`, **the third most popular girl's name that year**. The output might look like this:
```txt
Isabella born in 2012 would be Sophia if she was born in 2014.
```
- [x] Write the method `yearOfHighestRank` that has two parameters: a `String name`, and a `string` named `gender` (`F` for female and `M` for male). This method selects a range of files to process and returns an `integer`, the year with the highest rank for the name and gender. If the name and gender are not in any of the selected files, it should return `-1`. For example, calling `yearOfHighestRank` with name `Mason` and gender `M` and selecting the three test files above results in returning the year `2012`. That is because `Mason` was ranked the 2nd most popular name in 2012, ranked 4th in 2013 and ranked 3rd in 2014. His highest ranking was in 2012.
- [x] Write the method `getAverageRank` that has two parameters: a `String name`, and a `string` named `gender` (`F` for female and `M` for male). This method selects a range of files to process and returns a `double` representing the average rank of the name and gender over the selected files. It should return `-1.0` if the name is not ranked in any of the selected files. For example calling `getAverageRank` with name `Mason` and gender `M` and selecting the three test files above results in returning `3.0`, as he is rank 2 in the year 2012, rank 4 in 2013 and rank 3 in 2014.  As another example, calling `getAverageRank` with name `Jacob` and gender `M` and selecting the three test files above results in returning `2.66`.
- [x] Write the method `getTotalBirthsRankedHigher` that has three parameters: an `integer` named `year`, a `string` named `name`, and a `string` named `gender` (`F` for female and `M` for male). This method returns an `integer`, the total number of births of those names with the same gender and same year who are ranked higher than name. For example, if `getTotalBirthsRankedHigher` accesses the `yob2012short.csv` file with name set to `Ethan`, gender set to `M`, and year set to `2012`, then this method should return `15`, since `Jacob` has 8 births and `Mason` has 7 births, and those are the only two ranked higher than Ethan.

Here are some optional ideas to extend your program even further:

**Test edge cases.** 'Edge cases' refer to special situations where a program might break down. For example, consider searching for names that don't exist at all on the list of baby names provided, or only appear in some years but not in others. What happens when you try to find the most popular decade for such a name?

**Use a different set of data.** Does your home country record a similar set of data? Try finding a similar but different set of data and modifying your program to work with it. What changes do you have to make with the new data set? What are the similarities? How might those similarities and differences affect how you would write a program that used data from every country in the world?

**Explore different statistics.** If you wanted to know the median rank for a name over a period of multiple years, rather than the most popular year in that span, how would you write your program? What about finding a list of all the names that were used for fewer than 10 children in a particular year? What about finding the most popular name and year in the entire data set from a short list of your friends and family names? What are your own ideas for discovering interesting facts from this data set?

**Adapt your program to a new problem.** This project focused on reading data from CSV files, which is a common data storage format. Try adapting your baby name program to do something new. For example, you might be a teacher with a gradebook of student test results; you could use your program to find the average scores for each test. Or you might run a business and have accounting records; you could find your most profitable month over the last two years of operation.

## Batch Grayscale Images

### Grayscale Algorithm: Seven-Step Approach

> **Domain Knowledge**
> What is Grey? -> RGB R = RGB G = RGB B
> How to convert RGB to grey?
> - average
> - weighted average
> - more complex formula
> 

Step 1: Work with Small Instance By Hand -> work with 2x2 pixel image <br>
Step 2: Write down the steps <br>
Step 3: Find patterns and generalize <br>
Step 4: Test algorithm on another small example -> work with 3 pixel image <br>
Step 5: Translate to Code <br>
Step 6: Run test cases <br>
Step 7: Debug failed test cases <br>


