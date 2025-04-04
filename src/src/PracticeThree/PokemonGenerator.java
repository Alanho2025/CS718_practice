//this program is to recap lab 05 ex03 and lab 08 ex 05


package PracticeThree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        /*System.out.println("Recruiting elite Pokemons");
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
        System.out.println("The most elite Pokemon is " + winner);*/
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
    /*private Pokemon validateandcreatePokemon(Pokemon[] pokemoninfo){

    }
    private Pokemon createPokemon(String name, int level, int lifepoint){

    }
    private Pokemon recruitElitePokemons (String filename){

    }
    private Pokemon getHighestLevelPokemon(Pokemon[] pokemons){

    }*/

}
