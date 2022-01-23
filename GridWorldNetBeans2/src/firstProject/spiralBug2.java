package firstProject;

import info.gridworld.actor.Bug;

public class spiralBug2 extends Bug {
    
     int steps = 0;
     int counter = 0;
     int sideLength;
    

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public spiralBug2(int length)
    {
        
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
            
        }
        else
        {
            counter++;
            turn();
            turn();
            steps = 0;
            if(counter%2 == 0){
                sideLength++;
            }
        }
        
    }
}

