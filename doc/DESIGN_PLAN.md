# Cell Society Design Plan
### Team Number
### Names


## Design Overview

#### Overall design goals


#### Classes, their behavior and relationships (**not** instance variables)

The primary focus of the design is to completely separate the view from model
using MVC implementation, making the view and model entirely separate from one another
and only communicating between them by using the controller

**Model:** The model functionality includes the basic structure of the simulations for the Cellular
Automata (CA) including the Cell and Grid classes along with the functionality to actually perform the 
steps of the CA and run the simulations. It consists of the following classes with the purpose of each and
methods laid out:

Cell: a record class (or just class with a Cell constructor, TBD)

The purpose of this class is to create the most basic unit of the simulation and have a representation of it
with all the related information, like the state, xPos and yPos, and the number of sides (_This is TBD, exact structure
of this class is still being considered with team_). Could possibly make this an abstract class that can be extended 
since some simulations may have different cell properties and states.

|Cell| |
|--|---|
|int X position and int Y position for record| CellMap|
|int state (dead or alive) | CellMap|
| | |
| | |

CellMap: class to represent an instance of the Grid for the simulation

The purpose of this class is to create the cell grid to be used for the model and create all related methods
to modify and update cells and add cells to the map of the Grid in the correct manner, including getters and setters
for cells and cell states. It adds all the active cells to a Map and makes a set of All of the Cells so that they can be referenced
and checked and added properly as new living cells if needed

|CellMap| |
|--|---|
|Map CreateMap| BaseSimProcessor & Cell|
|Set AllCells | BaseSimProcessor|
| | |
| | |

BaseSimProcessor/BaseModel: abstract class for all relevant, shared model capabilities

The purpose of this class is to create all the functionality shared among all the different simulations and 
have an abstract class which allows for easy implementation of new and different simulations with similar 
shared features. Also have a method to be able to set up the simulation grid and reset the grid.

|BaseModel| |
|--|---|
| | |
| | |
| | |
| | |

GameOfLifeModel: class to perform simulation functions for Game of Life simulation

The purpose of this class is to extend the basic model class and include additional, Game of Life specific functions
to change cell states next to cells that are being checked and modify the grid and make neighbor updates and override
necessary methods in the base model to function for the specific simulation or application.

|GameOfLifeModel| |
|--|---|
|checkNeighbors | |
|checkInBoundsNeighbors | |
|checkLivingOrDead | |
|updateCells | |
|setUpGrid | |

_ALL OTHER MODEL CLASSES WILL BE IMPLEMENTED IN THE SAME WAY AS THE GAME OF LIFE MODEL, WITH SLIGHTLY DIFFERENT
METHODS TO EFFECTIVELY IMPLEMENT THE RULES OF THE SPECIFIC SIMULATION AND CA_

**View:** The view includes all frontend components, including the grid itself and all of the other buttons and features that 
it includes 

FileChooser: class to implement File Choosing on the GUI screen

The purpose of this class is to use the file chooser in JavaFX to allow users to click in the GUI
and choose a file on their local computer and then translate this file to the controller which will then pass it
to the CellMap class to make the living Map of cells

|FileChooser| |
|--|---|
|getInstance | Controller.DataFileParser|
|promptFileChooser | Controller.DataFileParser|
| | |
| | |
| | |

GUI: class to setup the scene of the GUI

The purpose of this class is to setup the GUI screen with all the frontend structure and 
the buttons and sizing

|GUI| |
|--|---|
|setupScene | |
| | |
| | |
| | |
| | |


**Controller:** The controller includes parsing including reading in from the CSV files and translating the information from 
file selection on the view to the model. It also is responsible for error handling and all the other related relational components between
the view and model that allow them to be tested and implemented independently (TO BE FINISHED WITH CRC CARDS).

DataFileParser: class to parse the csv file being read in from the GUI and translate it to a format usable by the model

The purpose of this class is to take in the CSV file chosen by the user and then reading it line by line to create the format needed to 
pass to the backend grid creation methods

|DataFileParser| |
|--|---|
| | |
| | |
| | |
| | |
| | |

 * As CRC

This class's purpose or value is to represent a customer's order:

|Cell| |
|--|---|
|boolean isInStock(OrderLine)      |OrderLine|
|double getTotalPrice(OrderLine)   |Customer|
|boolean isValidPayment (Customer) | |
|void deliverTo (OrderLine, Customer) | |


 *  OR UML in Markdown:

@startuml
Super <|-- Sub

class Super {
  void overrideMe()
  String toString()
}

class Sub {
  void overrideMe()
}
@enduml


 * OR UML Image

Here is a graphical look at our design:

![This is cool, too bad you can't see it](online-shopping-uml-example.png "An initial UI")

or made from [a tool that generates UML from existing code](http://staruml.io/).



## Design Details

#### Use Cases

 * A new game is started with five players, their scores are reset to 0.
 ```java
 Something thing = new Something();
 Value v = thing.getValue();
 v.update(13);
 ```

#### Extension Cases

 * What commonalities will be factored out into superclasses?

A superclass will be made for the *Backend Model* functionality, which includes consistent functional elements
of all CA including setting the state of a grid and checking the neighbors and number of neighbors for a cell
to be able to apply some kind of change to it. In addition, setting up and resetting the grid are common piecees of 
required function for each of the CA and simulations.

Another superclass that might be useful is a superclass for *Cells* since the behavior and properties of a Cell might not be
consistent among all CA (TBD whether this is actually how we decide to do this)
 
 * How will differences be handled when superclasses are extended?

Methods that include setting the game up for instance or check neighbors in a way incompatible or not precisely how
a simulation requires it can be overridden and reconstructed in individual model classes for each respective CA.
Superclasses will be constructed as abstract classes to be able to do this and provide abstraction for the entire model functionality.
 

## Design Considerations

Justification for classes and methods given in the design.

#### Design Issue #1

 * Design #1 Tradeoffs
   * Description
   
   * Pros
 
   * Cons

 * Design #2 Tradeoffs
   * Description
   
   * Pros
 
   * Cons
 
 * Justification for choice


#### Design Issue #2

 * Design #1 Tradeoffs
   * Description
   
   * Pros
 
   * Cons

 * Design #2 Tradeoffs
   * Description
   
   * Pros
 
   * Cons
 
 * Justification for choice


#### Data Structure Implementation Change

 * Implementation #1
   * Description
   
   * Classes possibly affected
 
   * Methods possibly affected

 * Implementation #2
   * Description
   
   * Classes possibly affected
 
   * Methods possibly affected
 
 * Justification for how implementation choices is hidden
 

#### File Format Implementation Change

 * Implementation #1
   * Description
   
   * Classes possibly affected
 
   * Methods possibly affected

 * Implementation #2
   * Description
   
   * Classes possibly affected
 
   * Methods possibly affected
 
 * Justification for how implementation choices is hidden


#### JavaFX "Grid" Component Implementation Change

 * Implementation #1
   * Description
   
   * Classes possibly affected
 
   * Methods possibly affected

 * Implementation #2
   * Description
   
   * Classes possibly affected
 
   * Methods possibly affected
 
 * Justification for how implementation choices is hidden




## User Interface

Here is our amazing UI:

![This is cool, too bad you can't see it](images/29-sketched-ui-wireframe.jpg "An alternate design")

taken from [Brilliant Examples of Sketched UI Wireframes and Mock-Ups](https://onextrapixel.com/40-brilliant-examples-of-sketched-ui-wireframes-and-mock-ups/).




## Team Responsibilities

#### Primary Responsibilities
 * Team Member #1

 * Team Member #2

 * Team Member #3

 * Team Member #4


#### Secondary Responsibilities
 * Team Member #1

 * Team Member #2

 * Team Member #3

 * Team Member #4


#### Schedule Plan

