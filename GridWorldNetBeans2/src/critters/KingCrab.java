package critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class KingCrab extends CrabCritter {
    @Override
    public void processActors(ArrayList<Actor> actors) {
        Grid gr = getGrid();
        
        for (Actor a : actors)
        {
            Location locAhead = a.getLocation().getAdjacentLocation(getDirection());
            Location locLeft = a.getLocation().getAdjacentLocation(getDirection()+270);
            Location locRight = a.getLocation().getAdjacentLocation(getDirection()+90);
            Location dirAhead = getLocation().getAdjacentLocation(getDirection());
            if( gr.isValid( locAhead))
            {
                if(gr.get(locAhead) ==null || gr.get(locAhead) instanceof Flower)
                a.moveTo(locAhead);
                else if(locLeft != dirAhead && gr.isValid(locLeft)){
                    if(gr.get(locLeft) ==null || gr.get(locLeft) instanceof Flower)
                    a.moveTo(locLeft);
                    else if(locRight != dirAhead && gr.isValid(locRight)){
                        if(gr.get(locRight) ==null || gr.get(locRight) instanceof Flower)
                        a.moveTo(locLeft);
                    }
                }
            }
            else if(locLeft != dirAhead && gr.isValid(locLeft)){
                if(gr.get(locLeft) ==null || gr.get(locLeft) instanceof Flower)
                a.moveTo(locLeft);
                else if(locRight != dirAhead && gr.isValid(locRight)){
                    if(gr.get(locRight) ==null || gr.get(locRight) instanceof Flower)
                    a.moveTo(locLeft);
                }
            }
            else if(locRight != dirAhead && gr.isValid(locRight)){
                if(gr.get(locRight) ==null || gr.get(locRight) instanceof Flower)
                a.moveTo(locLeft);
        }
    }
    }





}   
