# World of INDA17 - Project Description

**Students:** @oskstr @kittyt

**Programming language:** Java

## Project Introduction
World of INDA17 is a reality based game project where the user is a Computer Science student who must pass the course INDA17. 
The user is supposed to interact with a grapfical interface to complete the weekly tasks (game levels). The game project will
be implemented by using **JavaFX**. 


**Class diagram**

![Class Diagram](/docs/class-diagram.png)

## Game Description

### General game structure
#### Start menu:
The start menu will have two main bottoms, `Start` and `Quit`. The background picture will be a fractal (pallinda, assigment 3).

#### User name:
This display will have a bar where the user can choose an user name. By the user input, the game will generate a Star Wars name
(alginda, weekly assignment 7).

#### Introduction:
*Pythia, the oracle of Delphi* (pallinda, assignment 2) will introduce the background story. The player are supposed to click 
through the introduction.

#### Level 1, *Single Linked List* (alginda, weekly assignment 14):
The player is suppose to travel from position A to B by connecting nodes. The difficulty in this level is to connect the nodes 
in the dark, and not connecting infinite loops. Also be careful of the `plutten` who gives you `komplettering` and do not forget
the time limit.

#### Level 2, *Bouncing balls and box ball* (prginda, weekly assignment 7):
The player is placed in a box containing bouncing `plutten`. The task is to not collide with the `plutten`s, otherwise he will
give the player `komplettering`. If the player do not collide with any `plutten` during the time limit, the task i complete! The 
number of `plutten` in the box will increase with time. 

### Scoring system
At each level, the player is suppose to complete a task under a time limit. If the task i complete before the time limit, 
the player will receive bonus point based on the residual time. A grading scale from A-F is representing the lifecycle of
the player. When the player has been given a `komplettering`, the grade will decrease. The user lose when he/she 
gets a F.

## How-to-run
To be announced.

## Test strategy
Unit tests will be used to test backend methods etc. Run the project multiple times and try to break it to detect bugs.
