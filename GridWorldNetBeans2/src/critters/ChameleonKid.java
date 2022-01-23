package critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class ChameleonKid extends ChameleonCritter {
    
    private static final double DARKENING_FACTOR = 0.15;
    public  ArrayList<Actor> findActorsAheadAndBehind() {

        ArrayList<Actor> actors = new ArrayList<Actor>();
        Grid gr = getGrid();
        Location ahead =getLocation().getAdjacentLocation(getDirection());
        Location behind = getLocation().getAdjacentLocation(getDirection()+180);
        if(gr.isValid(ahead)){
        if(gr.get(ahead)!= null && gr.isValid(ahead)){
            actors.add((Actor) gr.get(ahead));
        }
    }
        if(gr.isValid(behind)){
        if(gr.get(behind)!= null && gr.isValid(behind)){
            actors.add((Actor) gr.get(behind));
        }
    }
        if(actors.size() == 0){
            Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
        }
        return actors;
    }

    @Override
    public void act() {
        if (getGrid() == null)
            return;
        ArrayList<Actor> actors = findActorsAheadAndBehind();
        processActors(actors);
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        if(!getGrid().isValid(loc))
        loc = new Location(0,0);
        makeMove(loc);
    }
}
