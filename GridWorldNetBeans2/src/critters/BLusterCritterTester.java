package critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;

public class BLusterCritterTester {
    public static void main(String[] args) {
        ActorWorld world2 = new ActorWorld();
        
        
        BoundedGrid<Actor> Grid = new BoundedGrid<Actor>(30, 30); 
    
        world2.setGrid(Grid);;
        world2.add(new BlusterCritter(2));
        world2.show();
    }
       
}
