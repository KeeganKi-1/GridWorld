package firstProject;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class RainDance {
    public static void main(String[] args){
        ActorWorld world = new ActorWorld();
        UnboundedGrid<Actor> uGrid = new UnboundedGrid<>();
        world.setGrid(uGrid);
        int[] outline = {0,6,0,0,};
        world.add(new Location(0, 0),new DancingBug(outline));
        world.show();
    }
}
