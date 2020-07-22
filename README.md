# Green vs Red
This is game played on a 2D grid.
Each cell on this grid can be either green(represented by 1) or green(represented by 0). The game always receives an initial state of the grid which we will call "Generation Zero".
After that a set of 2 rules are applied across the grid and those rules form the next generation.

**Rules that create next generation:**
* Each red cell that is surrounded by exactly 3 or 6 green cells will also become green in next generation.
* A green cell will stay green in the next generation if it has eihter 2, 3 or 6 green neighbours.    

**Fact**
* The 2 rules apply at the same time for the whole grid for the next generation to be formed.  


## Input
* The first line **holds a two numbers - x (width) and y (height).** That is the size of the grid.
* Next y(height of the grid) lines **holds strings (long x characters)** - "Generation Zero" of the grid.
* The last line **holds coordinates x1 and y1 and count of turns.**

(x1 and y1) will be coordinates for special cell in the grid. We would like to calculate how many generation from Generation Zero until last generation this cell was green.

The result is printed on the console.

**Example** 

**Input** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Output**  
3, 3 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Result: 5  
000  
111  
000  
1, 0, 10




