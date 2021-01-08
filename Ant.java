import java.awt.Color;
// This class describes the functionality of the ant
public class Ant extends Critter {
    private boolean movingSouth;
    private int stepsThisLeg = 0;
    private Direction dir = Direction.CENTER;
// This is the constructor that sets boolean to walkSouth
    public Ant(boolean walkSouth){
        movingSouth = walkSouth;
    }
// This determines where the critter moves next with a boolean
    public Direction getMove() {
        if(movingSouth == true) {
            if (stepsThisLeg % 2 == 0) {
                dir = Direction.SOUTH;
            } else {
                dir = Direction.EAST;
            }
        } else {
            if (stepsThisLeg % 2 == 0) {
                dir =  Direction.NORTH;
            } else {
                dir = Direction.EAST;
            }
        }
        stepsThisLeg ++;
        return dir;
    }
    // This returns true for the eat method
    public boolean eat() {
        return true;
    }

    // This returns the string value for the critter
    public String toString() {
        return "%";
    }
    //  This returns the color of the ant
    public Color getColor(){
        return Color.RED;
    }
   // This returns the method the ant uses to attack
    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }

}
