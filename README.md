# World of INDA17 - Project Description

**Students:** @oskstr @kittyt

**Programming language:** Java

## Project Introduction
World of INDA17 is a reality based game project where the user is a Computer Science student who must pass the course INDA17.
The user is supposed to interact with a grapfical interface to complete the weekly tasks (game levels). The game project will
be implemented by using **JavaFX**.

#### Classes
We would first of all need a `Game` class to generate a `Scene`, a window to display objects in, and run until the player decides to exit. We would also need either an interface or abstract class `Drawable` to be able to iterate over all objects in the scene. We would like to, at each time interval, update the state of `Drawable` objects as well as draw/redraw them.

There would be a few different classes that implements `Drawable`. The different `Drawable` object would probably all store a position and an image, held in a file somewhere. The only NPC in the game currenly planned is Plutten, coming in a couple of different incarnations `BouncingPlutten` that would work a lot like `BoxBall` from assignment 7. `WalkingPlutten` would be patroling a path, going back and forth, making it difficult for the `Player` to avoid *komplettering*.

**Class diagram**

![Class Diagram](/docs/class-diagram.png)

## Game Description

### General game structure
#### Start menu:
The start menu will have two main bottoms, `Start` and `Quit`. The background picture will be a fractal (palinda, assignment 3).

#### (User name:)
This display will have a bar where the user can choose an user name. By the user input, the game will generate a Star Wars name
(alginda, weekly assignment 7).

#### (Introduction:)
*Pythia, the oracle of Delphi* (pallinda, assignment 2) will introduce the background story. The player are supposed to click
through the introduction.

#### *Bouncing balls and box ball* (prginda, weekly assignment 7):
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
