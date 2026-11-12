
# ThreadCheckArray – Multithreaded Subset Sum

## Project Overview

This project is part of Lab Exercise 2 in the Software Engineering Methods course at Braude College of Engineering.

The project implements the Subset Sum problem in Java using multithreading. The goal is to determine whether a subset of integers adds up to a given target value.

The exercise focuses on configuration management with Git and GitHub, AI-assisted refactoring, Javadoc documentation, merge conflict resolution, and software verification.

## Subset Sum Algorithm

The program receives:
- A collection of integers.
- A target sum.

It uses a recursive algorithm to explore possible subsets and determine whether a combination of elements equals the target value.

Two Java threads execute the search using shared data.

Synchronization is used to coordinate access to shared state and communicate when a solution has been found.

## Project Structure

### SharedData.java
Stores the shared input collection, target value, solution flags, and results used by the threads.

### ThreadCheckArray.java
Implements the Runnable interface and performs the recursive Subset Sum search.

### TestThreadCheckArray.java
Contains the main method, reads user input, starts the worker threads, waits for their completion, and prints the results.

## AI-Assisted Refactoring

The original implementation used a primitive integer array:

`int[] array`

The code was refactored to use:

`ArrayList<Integer> array`

The refactoring included:
- Replacing primitive array access with ArrayList operations.
- Replacing length checks with size().
- Replacing indexed array assignments with add().
- Preserving primitive boolean[] arrays.
- Maintaining the original multithreading behavior.
- Adding Javadoc documentation.

The Continue AI assistant, using a local Qwen2.5-Coder-7B-Instruct model, was used as part of the refactoring workflow.

The generated code was reviewed and verified through compilation and execution.

## Git and GitHub Collaboration

The exercise was completed using separate Git branches.

Student A worked on the main development branch and was responsible for:
- Repository initialization and GitHub setup.
- Refactoring SharedData.java.
- Refactoring ThreadCheckArray.java.
- Project documentation.

Student B worked on a feature branch and was responsible for:
- Refactoring TestThreadCheckArray.java.
- Refactoring ThreadCheckArray.java.
- Creating an independent AI prompt.
- Integrating changes and resolving the merge conflict.

Both branches modified ThreadCheckArray.java, creating a merge conflict.

The conflict was resolved by combining the required changes into the final version.

## Verification and Smoke Test

The program was tested using the following input:

Array size: 4

Array elements: 1 2 3 7

Target sum: 5

Expected output:

```text
Solution for b : 5,n = 4
I:    0    1    2    3
A:    1    2    3    7
C:    0    1    1    0
```

The solution vector shows that the elements 2 and 3 were selected.

Their sum is:

2 + 3 = 5

The test completed successfully.

## Javadoc Documentation

Javadoc documentation was added to describe the classes and their functionality.

HTML documentation was generated using IntelliJ IDEA and is available in the local docs directory.

The generated documentation includes:
- SharedData
- ThreadCheckArray
- TestThreadCheckArray

## Development Environment

- Java 25
- IntelliJ IDEA
- Git and GitHub
- Continue AI Assistant
- Qwen2.5-Coder-7B-Instruct
- macOS

## Team Members

Student A: mohamed nawatha

Student B: mohamed diab

Course: Software Engineering Methods

Institution: Braude College of Engineering

## License

Braude College Academic License.

This project is intended for educational use within the course. Distribution and reuse are subject to the institution's academic licensing requirements.
