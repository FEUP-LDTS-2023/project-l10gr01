## LDTS_<10><01> - <Universe Bomber>


Our game was inspired by the classic game Bomberman, in which the protagonist uses his bombs to clear the path and destroy monsters. The version proposed by us is themed by the Steven Universe cartoon, that has Steven as a half gem boy who is a faced with a challenge to save his friends who were captured by evil gems. They were taken to a tricky maze filled with monsters and obstacles which Steven has to go through to free them. Along his path, our steven encounters new exciting power-ups to help in his mission. In each difficulty levels, he is faced with more powerfull monsters and paths. 


This project was developed by Leonardo Garcia (up202200041@up.pt), Marcel Medeiros (up202200042@up.pt) and Manoela Blanke (up202201392@up.pt) for LDTS 2023⁄24.

### IMPLEMENTED FEATURES

> This far only the model and the view of the game are implemented. More will come with upcoming commits!

### PLANNED FEATURES

-> **Monsters** : In this game Steven Universe is faced with different enemies. In each difficulty level, a monster will be presented and copies of him will be placed in the maze. A monster's objectivity is to catch Steven and damage him, making him lose his lifes. 

-> **Deploy Bombs** : Steven (our steven) is able to deploy gem bombs. These bombs can destroy certain wall types and kill monsters. This is a default feature, which means that steven will always have this ability, however after deploying a bombing Steven has to recharge in order to deploy another one.

-> **Gain Lifes** : Steven starts the game with a maximum of 3 lifes, along his path he may lost these lifes (either by standing next to a bomb or fighiting a monster). More lifes are hidden in the walls, by exploding a wall, Steven may find those lifes and take a safer adventure. 

-> **10X Bomb Upgrade** : by finding this bomb upgrade Steven will be able to temporarily enlarge the radius of bomb damage by 10x. 

-> **Unlimited Bombs Upgrade** : by finding this bomb upgrade, Steven will be able to temporarily deploy an unlimited amount of bombs, without waiting his power to recharge.

### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:

------

#### THE ARENA BUILDER FACTORY METHOD ####

**Problem in Context**

The building of an arena would take different implementations, this is because at each different level a different arena would be created. A possible implementation would be to create the default arena (level 1) and add to the constructor the level required, checking with conditionals and calling a different class method to construct each level. However, this implementation would violate the **Open-Closed Principle**.  We decided that would be best to use a **Factory Method Pattern** so that an abstract class called ArenaBuilder would be extended as the levels were created.


**The Pattern**

The **Factory Method Pattern** allows an abstract class to create an object, but let the subclasses decide which class to instantiate. In our code, the abstract class would be the ArenaBuilder and the subclass the LoaderArenaBuilder, each subclass will represent a different level and each one will act as a factory for creating elements. 

**Implementation**



#### The Screen State ####

In our game, Lanterna will be responsible to print different screens depending on the user's input. For example, once the game starts the Menu screen will appear, after he press start the Game screen will appear. Looking at this, it's very clear that a **State Pattern** would be necessary, defining in which state the game is running, and each state is responsible for creating its viewer.

**The Pattern**

The **State Pattern** allows an object to alter its behavior. In our code, the State class is an interface that will be implement by each Concrete State. In our main class, only the object of State class will be instaciated, because the states will differ at run-time.

**Implementation**

The following diagram illustrates how the pattern was implemented.

The classes can be found at [States](https://github.com/FEUP-LDTS-2023/project-l10gr01/tree/main/src/main/java/com/ldts/steven/states)

[Diagram](https://github.com/FEUP-LDTS-2023/project-l10gr01/blob/Documentation/Docs/State.drawio.png)

**Consequences**

-> Transitions between states happen at run-time, and they can be explicitly found in code.
-> Ensures the **Single Responsibility Principle**






#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.




