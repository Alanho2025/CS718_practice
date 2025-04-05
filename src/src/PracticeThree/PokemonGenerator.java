//this program is to recap lab 05 ex03 and lab 08 ex 05


package PracticeThree;

import java.io.*;
import java.util.*;


public class PokemonGenerator {
    // This is the main method
    public static void main(String[] args) {
        PokemonGenerator pokemonGenerator = new PokemonGenerator();
        pokemonGenerator.start();
    }

    // This is the start of the PokemonGenerator
    private void start() {
        Pokemon[] pokemons = createPokemons();

        System.out.println("Greetings from Pokemons");
        System.out.println("====================");

        // Printing each Pokemon with its own greeting from the given array
        printPokemonsGreetings(pokemons);

        System.out.println("====================");
        System.out.println();

        // Printing each electic type Pokemon from the given array
        System.out.println("Electric Pokemons show-off time");
        System.out.println("-------------------------------");

        printElectricPokemons(pokemons);

        System.out.println("-------------------------------");
        System.out.println();

        System.out.println("Random attack time!");
        System.out.println("-------------------");
        // Any three random Pokemons from the given array
        // will attack three other random Pokemons
        // Note that the Pokemon will not attack itself
        randomAttacks(pokemons);

        System.out.println("-------------------");
        System.out.println();

        System.out.println("Pokemons' status after the attacks");
        System.out.println("==================================");
        printPokemonsGreetings(pokemons);
        System.out.println("==================================");
        System.out.println();

        System.out.println("Recruiting elite Pokemons");
        System.out.println("----------------------------------");

        // Getting an array of elite Pokemons from a CSV file
        Pokemon[] elitePokemons = recruitElitePokemons("pokemons.csv");

        System.out.println("----------------------------------");

        // Printing information about each elite Pokemon
        for (Pokemon p : elitePokemons) {
            System.out.println(p);
        }

        // Finding the elite Pokemon with the highest level
        // from the array of elite Pokemons
        Pokemon winner = getHighestLevelPokemon(elitePokemons);
        System.out.println("The most elite Pokemon is " + winner);
    }

    private Pokemon[] createPokemons(){
        Pokemon[] pokemons = new Pokemon[5];
        pokemons[0] = new Pikachu("Pikachu", generateRandomLevel());
        pokemons[1] = new Psyduck("Psyduck", generateRandomLevel());
        pokemons[2] = new Charmander("Charmander", generateRandomLevel());
        pokemons[3] = new Squirtle("Squirtle", generateRandomLevel());
        pokemons[4] = new Electrode("Electrode", generateRandomLevel());
        return pokemons;
    }
    private int generateRandomLevel(){
        return (int)(Math.random()*5);
    }
    private void printPokemonsGreetings(Pokemon[] pokemon){
        for (Pokemon p : pokemon) {
            System.out.printf("I am %s, my current level is %d \n", p.name, p.level);
        }
    }
    private void printElectricPokemons(Pokemon[] pokemon){
        for (Pokemon p : pokemon) {
            if(p.type.equals(String.valueOf(Itype.ELECTRIC))){
                System.out.printf("I say %s when I attack \n", ((INoise) p).makeNoise());
            }
        }
    }
    private void randomAttacks(Pokemon[] pokemons){
        for (int i = 0; i < 3; i++) {
            Pokemon attacker = pokemons[(int) (Math.random() * pokemons.length)];
            Pokemon defender = pokemons[(int) (Math.random() * pokemons.length)];
            while (attacker == defender) {
                defender = pokemons[(int) (Math.random() * pokemons.length)];
            }
            attacker.attack(defender);
        }
    }
    private Pokemon validateandcreatePokemon(String[] pokemoninfo) throws PokemonInfoException{
        // TODO: Complete the method according to the test instructions. // You may modify the code inside this method.
        if(pokemoninfo.length!=3 || pokemoninfo[1].isEmpty() || pokemoninfo[2].isEmpty())
        { throw new PokemonInfoException("Incorrect level or life point");}
        String name = pokemoninfo[0];
        int level = Integer.parseInt(pokemoninfo[1]);
        int lifePoint = Integer.parseInt(pokemoninfo[2]);

        return createPokemon(name, level, lifePoint);
    }
    private Pokemon createPokemon(String name, int level, int lifepoint)throws NoPokemonFoundException{
        // TODO: Modify the method according to the test instructions.
        //  Don't forget to uncomment the following code to create the
        //  appropriate Pokemon.
        switch(name){
            case "Pikachu":
                return new Pikachu(name, level, lifepoint);
            case "Psyduck":
                return new Psyduck(name, level, lifepoint);
            case "Charmander":
                return new Charmander(name, level, lifepoint);
            case "Squirtle":
                return new Squirtle(name, level, lifepoint);
            case "Electrode":
                return new Electrode(name, level, lifepoint);
        }
        throw new NoPokemonFoundException("No Pokemon found!");
    }
    private Pokemon[] recruitElitePokemons (String filename){
        List<Pokemon> elitePokemons = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // 跳過 CSV 標頭行
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    try {
                        Pokemon pokemon = validateandcreatePokemon(parts);
                        elitePokemons.add(pokemon);  // 把成功創建的 Pokemon 存入 List
                    } catch (NoPokemonFoundException | PokemonInfoException e) {
                        System.out.println("Error processing line: " + line + " -> " + e.getMessage());
                    }
                }
            }

            System.out.println("Pokemons loaded successfully from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        return elitePokemons.toArray(new Pokemon[0]); // 轉換 ArrayList 為陣列
    }
    private Pokemon getHighestLevelPokemon(Pokemon[] pokemons){
        // TODO: Complete the method according to the test instructions.
        //  You may modify the following code inside this method.
        int highestLevel = Integer.MIN_VALUE;
        Pokemon highestPokemon = null;

        // 遍歷所有 Pokemon
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getLevel() > highestLevel) {
                highestLevel = pokemon.getLevel();
                highestPokemon = pokemon;
            }
        }

        return highestPokemon; // 返回擁有最高等級的 Pokemon
    }

}
