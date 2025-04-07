package PracticeThree_pokemon;

public class Squirtle extends Pokemon implements INoise{
    public Squirtle(String name, int level) {
        super(name, level);
        this.type = String.valueOf(Itype.WATER);
    }
    public Squirtle(String name, int level, int lifePoint) {
        super(name, level, lifePoint);
    }

    @Override
    public void attack(Pokemon other) {
        other.loseLifePoints(2 * level);
        lifePoint += 2;
        levelUp();
    }

    @Override
    public void levelUp() {
        if (lifePoint >= 6 * level) {
            level++;
            System.out.println("Squirtle level up!");
        } else {
            System.out.println("Not enough experience for Squirtle!");
        }
    }

    @Override
    public String makeNoise() {
        return "Squirtle Squirtle";
    }
}
