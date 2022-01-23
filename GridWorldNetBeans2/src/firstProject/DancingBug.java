package firstProject;

import info.gridworld.actor.Bug;

public class DancingBug extends Bug {
    int[] turns;
    int place=0;
public DancingBug(int[] turns){
this.turns = turns;


}
public void act(){
if(canMove()){
    move();
    for(int i = 0; i<turns[place]; i++){
        turn();

    }
    if(place == turns.length-1)
        place =0;
    else place++;

}
else{
    turn();
    
}


}

}
