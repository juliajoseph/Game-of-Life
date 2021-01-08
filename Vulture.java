import java.awt.*;
// This class describes the functionality of the vulture
public class Vulture extends Bird{
    private int numFight = 0;
    private int hunger = 1;
    private int steps = 1;

    //This is the vulture constructor
    public Vulture(){
    }

    // This describes the color of the vulture
    public Color getColor(){
        return Color.BLACK;
    }
    // This returns the method the vulture uses to attack
    public Attack fight(String oppo) {
        hunger ++;
        return super.fight(oppo);
    }

    // This determines when the vulture eats
    public boolean eat() {
        boolean hungry;
        if (hunger > 0) {
            hunger--;
            hungry = true;
        } else {
            hungry = false;
        }
        return hungry;
    }
}