# Cell Society Design Discussion
### Team Number: 4

### Names

### Ian Flynn, Arman Shekarriz, Diego Miranda, David Lu

## Cellular Automata

#### Commonalities

Each Automata requires maintaining a  rectangular grid with square cells, with the behavior of each cell being determined by its surrounding neighbors.
The behavior of the CA is only affected by the previous state rather than the entire history.
Each cell has a few finite, discrete states.

#### Variations

The variations of a cell society are typically within the rules themselves, which dictate the behavior of each cell and 
how it is influenced by its neighbor. The game of life, for example, either spawns, maintains, or kills a cell depending on the 
number of neighbors, whereas the forest fire variation causes a cell to “burn” based on its surrounding neighbors and probabilistic values 
(read from the `.sim` file).


## Discussion Questions

 * How does a Cell know what rules to apply for its simulation?

The simulation rules are determined by the `Type` field in the `.sim` file provided. This field will map directly to a controller class that manages the update rules for each cell.

 * How does a Cell know about its neighbors?

Each Cell will have a model/controller which will have a data structure that contains information about its neighbors and their status/properties. This model/controller will be independent of the view.
Or have a model for the entire grid where the world is held in a 2-D int array. Where there is a method that scan around the cell

 * How can a Cell update itself without affecting its neighbors update?

Have two copies of the world/board, all updates are done on the new one without affecting the old one.

 * What behaviors does the Grid itself have?

 * How can a Grid update all the Cells it contains?

 * How is configuration information used to set up a simulation?

The configuration information sets up the simulation by operating in two steps. The first step calls all of the cells and their status to calculate what changes are needed. 
Then the second step iterates through all of the cells marked to be changed and implements their respective changes. The model updates on each step 1.

 * How is the GUI updated after all the cells have been updated?


## Alternate Designs

#### Design Idea #1

 * Data Structure #1

 * Data Structure #2


#### Design Idea #2

 * File Format #1

 * File Format #2



## Design Principles

#### Open-Closed Design Principle


#### Dependency Inversion Principle


#### Interface Separation Principle




### CRC Card Classes

This class's purpose or value is to represent a customer's order:
![Order Class CRC Card](order_crc_card.png "Order Class")


This class's purpose or value is to represent a customer's order:

|Order| |
|---|---|
|boolean isInStock(OrderLine)         |OrderLine|
|double getTotalPrice(OrderLine)      |Customer|
|boolean isValidPayment (Customer)    | |
|void deliverTo (OrderLine, Customer) | |


This class's purpose or value is to represent a customer's order:
```java
public class Order {
     // returns whether or not the given items are available to order
     public boolean isInStock (OrderLine items)
     // sums the price of all the given items
     public double getTotalPrice (OrderLine items)
     // returns whether or not the customer's payment is valid
     public boolean isValidPayment (Customer customer)
     // dispatches the items to be ordered to the customer's selected address
     public void deliverTo (OrderLine items, Customer customer)
 }
 ```
 

### Use Cases

 * Apply the rules to a cell: set the next state of a cell to dead by counting its number of neighbors using the Game of Life rules for a cell in the middle (i.e., with all of its neighbors)
```java
 OrderLine items = new OrderLine();
 if (order.isInStock(items)) {
     total = order.getTotalPrice(items);
 }
```

 * Move to the next generation: update all cells in a simulation from their current state to their next state
```java
 OrderLine items = new OrderLine();
 if (order.isInStock(items)) {
     total = order.getTotalPrice(items);
 }
```

 * Switch simulations: load a new simulation from a data file, replacing the current running simulation with the newly loaded one
```java
 OrderLine items = new OrderLine();
 if (order.isInStock(items)) {
     total = order.getTotalPrice(items);
 }
```
