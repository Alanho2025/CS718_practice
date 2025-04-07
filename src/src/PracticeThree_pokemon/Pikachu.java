package PracticeThree_pokemon;

public class Pikachu extends Pokemon implements INoise{
    public Pikachu(String name, int level) {
        super(name, level);
        this.type = String.valueOf(Itype.ELECTRIC);
    }
    public Pikachu(String name, int level, int lifePoint) {
        super(name, level, lifePoint);
    }

    @Override
    public void attack(Pokemon other) {
        other.loseLifePoints(3 * level);
        lifePoint += 3;
        levelUp();
    }

    @Override
    public void levelUp() {
        if (lifePoint >= 2 * level) {
            level++;
            System.out.println("Pikachu level up!");
        } else {
            System.out.println("Not enough experience for Pikachu!");
        }
    }

    @Override
    public String makeNoise() {
        return "Pika pika";
    }

}
