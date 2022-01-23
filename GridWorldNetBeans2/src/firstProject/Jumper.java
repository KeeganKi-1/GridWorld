package firstProject;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Bug {
    
    public void act(){
        Grid<Actor> gr = getGrid();
        Location aheadLoc = getLocation().getAdjacentLocation(getDirection());
        Location moveToLoc = getMoveLoc();
        Actor neighboor = gr.get(moveToLoc);
        Location ourLocation = getLocation();
        Location neighboorLocation = new Location(0,0);
        if(neighboor != null){
         neighboorLocation = neighboor.getLocation();
    };
    if(isJumper()){

        moveTo(new Location(0,0));
        neighboor.moveTo(ourLocation);
        moveTo(neighboorLocation);

        
    }      
    else
    move(); 
    
    }

    public Location getMoveLoc(){
        Grid<Actor> gr = getGrid();
        Location aheadLoc = getLocation().getAdjacentLocation(getDirection());
        Location moveToLoc = aheadLoc.getAdjacentLocation(getDirection());
        Location Location = getLocation();
        int direction = getDirection();
        int top = 0;
        int bottom = gr.getNumRows()-1;
        int left = 0;
        int right = gr.getNumRows()-1;
        int currRow = getLocation().getRow();
        int currCol = getLocation().getCol();
        if(!gr.isValid(moveToLoc)){
        

        if(direction == 0)
                Location = new Location(bottom, currCol);
         if(direction == 45)
                Location = new Location(bottom, left);
        if(direction == 90)
                Location = new Location(currRow, left);
        if(direction == 135)
                Location = new Location(top, left);
        if(direction == 180)
                Location = new Location(top, currCol);
        if(direction == 225)
                Location = new Location(top, right);
       if(direction == 270)
                Location = new Location(currRow, right);
       if(direction == 315)
                Location = new Location(bottom, right);

        }
        else
        Location = moveToLoc; 
        


        return Location;
    }

    public boolean isJumper(){
        Grid<Actor> gr = getGrid();
        Location aheadLoc = getLocation().getAdjacentLocation(getDirection());
        Location moveToLoc = getMoveLoc();
        Actor neighboor = gr.get(moveToLoc);
        if(neighboor instanceof Jumper){
        return true;
        
        }
        else{
        return false;
        
        }



    }

public void move(){
    Grid<Actor> gr = getGrid();
    Location aheadLoc = getLocation().getAdjacentLocation(getDirection());
    Location moveToLoc = getMoveLoc();
if(gr.isValid(moveToLoc) && canMove()){
    moveTo(moveToLoc);
}
else
turn();


}

public boolean canMove(){
Grid<Actor> gr = getGrid();
Location aheadLoc = getLocation().getAdjacentLocation(getDirection());
Location moveToLoc = getMoveLoc();
Actor neighboor = gr.get(moveToLoc);
if(neighboor instanceof Rock){
return false;

}
else{
return true;

}


}



}

