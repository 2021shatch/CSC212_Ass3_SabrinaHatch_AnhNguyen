Sources Used:

https://www.geeksforgeeks.org/hashset-in-java/
https://stackoverflow.com/questions/29178258/using-hashset-to-store-a-text-file-and-read-from-it

Reflection:

Okay, for this project, I definitely had a harder time than the last project. For the last project, I felt like since we had a preset table data that was being synthesized, I felt comfortable working out all the test cases (otherwise the program we made just wouldn't print what we wanted it to). However, for this one, Anh and I found that we kept running into problems we didn't even think of having (for example, the lowercase file reader dilemma, issues with corrections at the end or beginning of a word, and reading from a txt file vs command line). That for me, was much more stressfull and felt a bit like untangling a knot in a piece of yarn, only to find out that it just keeps going deeper and deeper into the skein. 

For us, we figured out the foundations of all of our submethods after a couple nights at TA hours which was nice. It wasn't too hard, except we ran into a lot of problems with Java's stubborness with string mutability! Luckiliy we figured out a tricky way to use the substring method to make things work in our favor without changing the user's original string on each iteration. 

The next time we met, we mostly worked on figuring out how to connect our logic to the user using the SpellChecker method, which we struggled with A LOT. We still aren't completely sure how scanners and file readers work and would love to have some more class time to talk about it. After some careful consideration and some great help from the TAs, we were able to figure out that piece, but we were still left with 2 main problems: 

1. Whenever the user starts to enter something in via command line, if they accidentally hit enter, the program would glitch and not redirect them to restart the program. If given extra time, I think we would have loved to learn how to implement a throw error message. I am still having a hard time with the use of the try catch, throw, error stuff, etc, but I hope in future assignments I can move forward in doing my best and trying them to get more comfortable. To fix the solution, we just added in an easy console print out of directions for the user on how to use the program and what to do if there was an error.

2. LOWERCASE!! ARRRGHH Anh and I were very confused on how to solve the issue of capitilization, especially when it came to the use of proper nouns. Thankfully, you helped us realize a quick and easy fix of just adding the upper alpha!

Overall, this assignment was a ton of work! However, it was still very gratifying and challenging and exciting to see the results! This class certainly makes it more and more clear to me that computer science is the right path for me!


