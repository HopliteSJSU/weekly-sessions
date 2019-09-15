# Hoplite Weekly Session Solutions

This repo is dedicated to the solutions of coding problems discussed in our weekly sessions.


## Contributing guidelines

The following is a set of guidelines for contributing to our weekly session repo. 

Why do we need guidelines?
- The goal is to give a consistent experience to our readers.
- Make it very easy for our readers to understand the solution.
- Set a high coding standard for our readers, so that they are inspired to write clean code in interviews.

### Solution

- The solution added should be 100% working and tested in leetcode submission.
- Make sure to add metadata about the question along with the time and complexity. This should be added in the top of the file as a comment in the below format.

```java
/**
 * Question: <leetcode-question-number>. <leetcode-question-title> 
 * Link: <leetcode-question-url>
 * Hoplite Session: <session-date-mm/dd/yyyy>
 * 
 * Time Complexity: <accurate-time-complextiy>
 * Space Complexity: <accurate-space-complextiy>
 */
```

For example

```java
/**
 * Question: 56. Merge Intervals 
 * Link: https://leetcode.com/problems/merge-intervals/
 * Hoplite Session: 09/12/2019
 * 
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
```
- Avoid redundant code in the solution.
- Follow the programming languages best practices.
- Use standard formtting and lint.

### Comment

Comments are the most important part of our solution. Comments support our goal to make it super easy for our readers to understand the code. Below are a few things to keep in mind while writing comments.

- Since the code is just meant to be read, be very generous with comments. Add relevant comments wherever possible.
- Think of what questions our reader might have with a line/part of code. Try to answer that question in comments.
- When using not-so-obvious syntax, try to provide reference links. For example 
```java
/**
 * Convert stack into array Read more: 
 * https://docs.oracle.com/javase/7/docs/api/java/util/Vector.html#toArray(T[])
 */
```

### Naming

##### Variable/Methods/Class Name 
- Use meaningful names for variables. Variable name must define the exact explanation of its content.
- Use meaningful names for methods. The name must specify the exact action of the method and for most cases must start with a verb. (e.g. createPasswordHash)
- Use meaningful names for method parameters, so it can document itself.
- Obey the programming languages best practices for naming variables, methods, class.

##### File Name
-	 Every solution should have a file name in the below format

	`session-<date-in-mm-dd-yyyy>-problem-<leetcode-problem-number>-<problem-name>`
    
	for example `session-09-12-2019-problem-56-merge-intervals.java`
    
- If there is an alternate approach other than the one discussed in the session, use the below format
   
   `session-<date-in-mm-dd-yyyy>-problem-<leetcode-problem-number>-<problem-name>-alternate-<alternate-solution-number>`
   
   for example `session-09-12-2019-problem-56-merge-intervals-alternate-2.java`
   
### Git Commit Messages
- Use the present tense ("Add ..." not "Added ...")
- Use the format `Add <mm-dd> session` for the orignal solution. For example `Add 09-12 session`
- Use the format `Add <mm-dd> session alternate-<alternate-solution-number>` for the alternate solution. For example `Add 09-12 session alternate-2`
