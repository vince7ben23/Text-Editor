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
- TBD

## Prerequisites
- TBD

## Setup
- TBD
