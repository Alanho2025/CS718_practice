package PracticeThree_pokemon;

public class Charmander extends Pokemon implements INoise{
    public Charmander(String name, int level) {
        super(name, level);
        this.type = String.valueOf(Itype.FIRE);
    }

    public Charmander(String name, int level, int lifePoint) {
        super(name, level, lifePoint);
    }

    @Override
    public void attack(Pokemon other) {
        other.loseLifePoints(2 * this.level);
        this.lifePoint += 1;
        this.levelUp();
    }

    @Override
    public void levelUp() {
        System.out.println("Charmander never level up");
    }

    @Override
    public String makeNoise() {
        return "Charmander char";
    }
}
