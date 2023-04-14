Text Editor
============
This is a text editor implemented by Java that provides the main functionalities you would expect, such as incorrect spelling highlight , auto completion, and spelling suggestion, etc.

![Text Editor](https://user-images.githubusercontent.com/16397191/230919573-778ad164-d963-40e6-9190-b56f446bb741.png)

## Purpose
This project is to implement a text editor through several classic data structures in Java. With this approach, I can enhance my understanding of what these data structures are, how to implement them, and the proper structure to choose for different scenarios.

## Features
### Spelling Check 
- When an incorrect string is typed into the editor, it highlights the string as red. This feature is implemented by a dictionary set that stores the most common English words. When we type a string, the backend searches the string in the dictionary. If not found, we know the string is an invalid word or misspelled.
- A dictionary can be implemented in many ways. I implemented it with LinkedList, BST, and HashSet. BST and Hash Set are more practical due to their better performance. HashSet is often selected if we don't need the data to be ordered.

### Auto Completion
- When we type a string in the editor, it will predict what words we intend to type and then give us several options. This is a convenient feature in a modern text editor.
- This feature is implemented by a Trie. A Trie is used to store common words as a dictionary(Yes, Trie is also an option to implement a word dictionary). When a string is typed into the editor, Trie takes the string as a prefix and searches the words with the common prefix, then do a Breadth-Fisrt-Search to list the words from short length to long length.

### Spelling Suggestion
- This is an advanced feature built on top of Spelling Check. It does not just indicate the wrong spelling. It gives you the correct words as suggestions that are close to your typing.
- "edit distance" is defined as how close one string is to another. For example, "me" to "my" is one unit of edit distance since one character is substituted. There are three ways to manipulate characters on a string, substitution, insertion, and removal. With edit distance and character manipulation, we can design an algorithm to find the correct words and give suggestions based on a given string, and it can be described below,

```
  Input:  this given string for which to provide number of spelling suggestions
  Input:  number of maximum suggestions to provide
  Output: list of spelling suggestions

  Create a queue to hold strings to explore
  Create a visited set to avoid looking at the same string repeatedly
  Create list of valid words to return when finished
  Create a string, curr, to use in while loop

  Add the initial string to the queue and visited set

  while the queue has elements and we need more suggestions
    remove the string from the start of the queue and assign to curr
    get a list of neighbors (strings one mutation away from curr)
    for each n in the list of neighbors
       if n is not visited set
         add n to the visited set
         add n to the back of the queue
         if n is a valid word in the dictionary
            add n to the list of words to return

  return the list of valid words
```

## Prerequisites
- Java 1.8 JDK
- Install and setup your IDE, Eclipse version 2022-12 is used and tested.
- Install e(fx)clipse, a GUI package used as frontend for this application, Link: www.eclipse.org/efxclipse/install.html.


## Setup
- `git clone` this project to your local computer, and import it into Eclipse workspace.
- Setting up the correct JDK for your project. Go to "Window"->"Preferences", select "Java"->"Installed JREs" to select JDK 1.8.0.
- Add JUnit to your project. Select "Java Build Path". Select the "Libraries" tab and "Add Library". Select JUnit, then JUnit 4.

## Acknowledgements
- A big thank you to Tomas Mikula for creating RichTextFX which was used as the text area in the GUI application. Link: https://github.com/TomasMikula/RichTextFX

