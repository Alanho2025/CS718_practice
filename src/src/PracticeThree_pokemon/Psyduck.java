package PracticeThree_pokemon;

public class Psyduck extends Pokemon implements INoise{
    public Psyduck(String name, int level) {
        super(name, level);
        this.type = String.valueOf(Itype.WATER);
    }
    public Psyduck(String name, int level, int lifePoint) {
        super(name, level, lifePoint);
    }

    @Override
    public void attack(Pokemon other) {
        other.loseLifePoints(20 * level);
        lifePoint += 20;
        levelUp();
    }

    @Override
    public void levelUp() {
        if (lifePoint >= 10 * level) {
            level++;
            System.out.println("Psyduck level up!");
        } else {
            System.out.println("Not enough experience for Psyduck!");
        }
    }

    @Override
    public String makeNoise() {
        return "Psy~~~duck ";
    }
}
