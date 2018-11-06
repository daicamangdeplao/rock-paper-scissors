# Introduction
A hand game, rock–paper–scissors, is implemented in term of a Java-based program. This app mimics the way that two players try to beat each other by posing the hand-shapes represented rock, paper, and scissors. The rules is described in this [link](https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors).

# Prerequisite
This application is a Java-based application, and `jdk-8u191` is needed to be installed before executing the source code.

To execute the app, just so following steps
- Download zip file from this [link](https://github.com/trdngy/toy-project-3.git)
- Import Maven project in Eclipse
- Run as Java application

# Concept
There are two classes: `Player` and `Action`. The class of `Player` has a relationship of dependency on the class of `Action`. The following UML depicts the attributes, methods, and relationships between `Player` and `Action`.

![alt text](https://github.com/trdngy/img-pool/blob/master/toy-project-3.png)

The choice of hand-shapes for each player is completely random. The randomness is implemented based on `ThreadLocalRandom.current().nextInt(1, 4)`. The idea of this line of code is that it returns a random integer number in the range [1, 3], 1 – Paper, 2 – Rock, 3 – Scissors. The winner is identified based on the difference between two integer numbers that indicate Paper, Rock, or Scissors.

Furthermore, the contract of `hashCode()` and `equals()` is also overrided for a purpose of comparing objects.

# Result
![alt text](https://github.com/trdngy/img-pool/blob/master/toy-project-3-result.png)
