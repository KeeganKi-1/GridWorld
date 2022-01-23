package firstProject;

import info.gridworld.actor.Bug;

public class CircleBug extends Bug {
    int steps;
    int sideLength;
    public CircleBug(int length)
    {
        steps = 0;
        sideLength = length;
    }
@Override
public void act(){

    if (steps+1 < sideLength && canMove())
    {
        move();
        steps++;
    }
    else
    {
        turn();
        steps = 0;
    }


}



}
