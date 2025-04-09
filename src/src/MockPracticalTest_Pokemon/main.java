package MockPracticalTest_Pokemon;

public class main {
    public static void main(String[] args) throws Outvalid {
        Pokemon playsPokemon = new Pokemon("Mue", PokemonType.PHYSICAL, 100, new Move("Physcial Attack", PokemonType.PHYSICAL, 30), new Move("Fire", PokemonType.FIRE, 20));
        Pokemon opponentPokemon= new Pokemon("Gungue", PokemonType.GHOST, 120, new Move("Dark Ball", PokemonType.GHOST, 40), new Move("Ghosst Fire", PokemonType.GHOST, 30));
        Battle battle = new Battle(playsPokemon, opponentPokemon);
        battle.startBattle();

    }
}
