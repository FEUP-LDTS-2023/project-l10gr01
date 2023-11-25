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

The following [Diagram](Docs/State.drawio.png) illustrates how the pattern was implemented.

The classes can be found at [States](src/main/java/com/ldts/steven/states)


**Consequences**

-> Transitions between states happen at run-time, and they can be explicitly found in code.

-> Ensures the **Single Responsibility Principle**




