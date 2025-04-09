package MockPracticalTest_Pokemon;

public class Move {
    private String name;
    private PokemonType type;
    private int power;

    public Move(String name, PokemonType type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public String getName() {
        return name;
    }
    public PokemonType getType() {
        return type;
    }
    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Move: " + name +" ( " +  type + ", Power : " + power + ")";
    }
}
