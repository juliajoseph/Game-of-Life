import java.awt.*;
import java.util.*;
import java.util.Scanner;
// This class determines the functionality of the class Longhorn which is an extension
// of the super class Longhorn
public class Longhorn extends Critter{
    private boolean hungry;
    private int moveCounter = 9;
    private int direction = 0;
    private int TOTALDIRECTIONS = 4;
    private int hunger = 1;
    private Scanner scan;
    private int steps = 1;
    private int hippo;
    private static final int MAX_STEPS = 8;
    Direction dir = Direction.CENTER;

    //This is the Longhorn constructor
    public Longhorn(){
        if(hunger > 0) {
            hungry = true;
        }
        else {
            hungry = false;
        }
    }
    // This describes the color of the Longhorn
    public Color getColor(){
        return Color.ORANGE;
    }
    // This shows how the Longhorn is represented on the screen
    public String toString(){
        return "L";
    }
    // This determines when the Longhorn eats
    public boolean eat() {
        boolean hungry;
        if (hunger > 0) {
            hunger--;
            hungry = true;
        } else {
            hungry = false;
            hunger += MAX_STEPS;
        }
        return hungry;
    }
    // This determines the next move of the Longhorn and goes in a different direction
    // when faced with an unknown opponent
    public Direction getMove() {
        int S = 3, W = 4;
        if(moveCounter > MAX_STEPS){
            Random r = new Random();
            direction = r.nextInt(TOTALDIRECTIONS) + 1;
            moveCounter = 1;
        }
        if(direction == 1){
            dir = Direction.NORTH;
        } else if(direction == 2){
            dir = Direction.EAST;
        } else if(direction == S) {
            dir = Direction.SOUTH;
        } else if(direction == W) {
            dir = Direction.WEST;
        }

        String animal = getNeighbor(dir);
        if (!(animal.equals(" ") || animal.equals("%") || animal.equals("^") || animal.equals(">") ||
                animal.equals("v") || animal.equals("<") || isNumeric(animal) )) {
            Random r = new Random();
            direction = r.nextInt(TOTALDIRECTIONS) + 1;
            moveCounter = 1;
        }
        moveCounter ++;
        return dir;
    }
    // This ensures the Longhorn doesn't sleep to reduce vulnerability to attacks
    public void sleep(){
        wakeup();
    }
    // This returns the method the Longhorn uses to attack
    public Attack fight(String opponent) {
        scan = new Scanner(opponent);
        if (scan.hasNextInt())
            hippo = scan.nextInt();
        if (opponent.equals("%")||hippo > 0)
            return Attack.ROAR;
        else if (opponent.equals("^")||opponent.equals(">")||
                opponent.equalsIgnoreCase("V")||opponent.equals("<"))
            return Attack.SCRATCH;
        else
            return Attack.POUNCE;
    }

    // This determines whether the strings are integers
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}