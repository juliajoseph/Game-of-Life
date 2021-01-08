import java.awt.*;
import java.util.Random;
// This class describes the functionality of the hippo
public class Hippo extends Critter {
    private int foodLeft;
    private boolean hungry;
    private int moveCounter = 6;
    private int direction = 0;
    private static final int MAX_STEPS = 5;
    private int SOUTH = 3;
    private int WEST = 4;
    Direction dir = Direction.CENTER;


    //This is the hippo constructor with a hunger parameter
    public Hippo(int hunger) {
        if(hunger > 0) {
            hungry = true;
        } else {
            hungry = false; }
        foodLeft = hunger;
    }

    // This returns the method the hippo uses to attack
    public Attack fight(String opponent) {
        if(foodLeft > 0) {
            return Attack.SCRATCH; }
        return Attack.POUNCE;
    }

    //  This returns the color of the hippo
    public Color getColor() {
        Color color = Color.WHITE;
        if(foodLeft > 0) {
            color = Color.GRAY; }
        return color;
    }

    // This returns the string value for the hippo
    public String toString()
    {
        return "" + foodLeft;
    }

    // This determines when the hippo eats
    public boolean eat() {
        if(foodLeft > 0) {
            hungry = true;
            foodLeft--;
        } else {
            hungry = false; }
        return hungry;
    }

    // This determines the direction of the hippo's next move
    public Direction getMove() {

        if(moveCounter > MAX_STEPS){
            Random r = new Random();
            direction = r.nextInt(WEST) + 1;
            moveCounter = 1;
        }

        if(direction == 1) {
            dir = Direction.NORTH;
        } else if(direction == 2) {
            dir = Direction.EAST;
        } else if(direction == SOUTH) {
            dir = Direction.SOUTH;
        } else if(direction == WEST) {
            dir = Direction.WEST; }

        String animal = getNeighbor(dir);

        moveCounter ++;
        return dir;
    }
}
