import java.awt.Color;
// This class describes the functionality of the bird which is an extension of the
// super class critter
public class Bird extends Critter{
    Direction lastMove = Direction.CENTER;
    private int steps = 1;

    //This is the bird constructor
    public Bird(){}

    // This determines when the bird eats
    public boolean eat() {
        return false;
    }

    // This describes the color of the bird
    public Color getColor(){
        return Color.BLUE;
    }

    // This determines the next move of the bird
    public Direction getMove() {
        int N1 = 1, N2 = 3, E1 = 4, E2 = 6, S1 = 7, S2 = 9, W1 = 10, W2 = 12;
        if (steps >= N1 && steps <= N2) {
            lastMove = Direction.NORTH;
        } else if (steps >= E1 && steps <= E2) {
            lastMove = Direction.EAST;
        } else if (steps >= S1 && steps <= S2) {
            lastMove = Direction.SOUTH;
        } else if (steps >= W1 && steps <= W2) {
            lastMove = Direction.WEST;
        }
        if (steps >= 12 )
            steps = 1;
        else
            steps ++;

        return lastMove;
    }

    // This returns the method the bird uses to attack
    public Attack fight(String oppo) {
        if(oppo.equals("%")) {
            return Attack.ROAR;
        }
        return Attack.POUNCE;
    }

    // This shows how and when the bird is represented on the screen
    public String toString(){
        if(lastMove == Direction.EAST){
            return ">";
        } else if(lastMove == Direction.SOUTH){
            return "V";
        } else if(lastMove == Direction.WEST){
            return "<";
        } else {
            return "^";
        }
    }
}

