package PracticeThree_pokemon;

public abstract class Pokemon  {
    protected String name;
    protected int level;
    protected int lifePoint;
    protected String type;

    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }


    public Pokemon(String name, int level, int lifePoint) {
        this.name = name;
        this.level = level;
        this.lifePoint = lifePoint;
    }
    public abstract void attack(Pokemon other);
    public abstract void levelUp();

    public void loseLifePoints(int points) {
        lifePoint -= points;
        // Pokemon starts from the beginning if it loses more than what it has
        if (lifePoint <= 0) {
            level = 1;
            lifePoint = 10;
        }
    }
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("%s with level %d and life point %d.", name, level, lifePoint);
    }

}
