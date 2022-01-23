package critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class QuickCrab extends CrabCritter {
    
    @Override
    public ArrayList<Location> getLocationsInDirections(int[] directions) {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            Location goToLoc = neighborLoc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(goToLoc)){
            if(gr.get(neighborLoc) == null && gr.get(goToLoc) == null){
                locs.add(goToLoc);
            }
            else if (gr.get(neighborLoc)==null)
            locs.add(neighborLoc);
        }
        else if(gr.isValid(neighborLoc)){
            if (gr.get(neighborLoc)==null)
            locs.add(neighborLoc);
        }
    }
        return locs;
    }

    @Override
    public ArrayList<Actor> getActors() {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs =
            { Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT };
        for (Location loc : super.getLocationsInDirections(dirs))
        {
            Actor a = getGrid().get(loc);
            if (a != null)
                actors.add(a);
        }

        return actors;
    }
}
