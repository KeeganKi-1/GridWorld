package critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter
{
int c;

public BlusterCritter(int confidence){
    c = confidence;
}

@Override
public void act() {
    if (getGrid() == null)
            return;
        darken(getHowManyActors());
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
}

public void darken(int howMuch){
    double DARKENING_FACTOR = 0.05;
    double LIGHTNING_FACTOR = -0.05;
    if(howMuch>c){
        Color c = getColor();
        
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
    }
    else{
        Color c = getColor();
        
        int red = (int) (c.getRed() * (1 - LIGHTNING_FACTOR));
        int green = (int) (c.getGreen() * (1 - LIGHTNING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - LIGHTNING_FACTOR));

        setColor(new Color(red, green, blue));
    }

}


public int getHowManyActors() {
    ArrayList<Location> neighbors = new ArrayList<Location>();
    Location checkFrom = getLocation();
    Location toCheck = getLocation();
    int howMuch = -1;
    Grid gr = getGrid();
    for(int g =0; g<25; g++){
    for(int i=0; i<6; i++){
        toCheck = new Location(checkFrom.getRow()+2-6,checkFrom.getCol()-2+i);
        if(gr.get(toCheck)!= null){
                howMuch++;
        }
    }
}


    return howMuch;
}

}
