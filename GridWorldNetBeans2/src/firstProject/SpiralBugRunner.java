/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstProject;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import java.awt.Color;

/**
 *
 * @author spockm
 */
public class SpiralBugRunner 
{    
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        //These two lines make it start as Unbounded! (optional)
        UnboundedGrid<Actor> uGrid = new UnboundedGrid<>(); 
        world.setGrid(uGrid);
        
        spiralBug2 alice = new spiralBug2(1);
        alice.setColor(Color.BLUE);
        world.add(new Location(10, 10), alice);
        world.show();
    }
}
