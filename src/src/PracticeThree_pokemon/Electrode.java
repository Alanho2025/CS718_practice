package PracticeThree_pokemon;

public class Electrode extends Pokemon implements INoise {
    public Electrode(String name, int level) {
        super(name, level);
        this.type = String.valueOf(Itype.ELECTRIC);
    }

    public Electrode(String name, int level, int lifePoint) {
        super(name, level, lifePoint);
    }

    @Override
    public void attack(Pokemon other) {
        other.loseLifePoints(5 * this.level);
        this.lifePoint += 2;
        this.levelUp();
    }

    @Override
    public void levelUp() {
        if (this.lifePoint > 5 * this.level) {
            this.level++;
            System.out.println("Electrode level up!");
        } else {
            System.out.println("Not enough experience for Electrode!");
        }
    }



    public String makeNoise(){
        return "\"ts...ts...ts...Electrode\"";
    }
}
