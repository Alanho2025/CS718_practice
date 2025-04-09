package MockPracticalTest_Pokemon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Pokemon{
    //Declare the elements
    private String pokemonName;
    private PokemonType type;
    private int health;
    ArrayList<Move> moves = new ArrayList<>();

    //pokemon general constructor
    public Pokemon(String fileName, PokemonType type, int health, Move move1, Move move2) {
        this.pokemonName = fileName;
        this.type = type;
        this.health = health;
        moves.add(move1);
        moves.add(move2);
    }

    public String getPokemonName(){
        return this.pokemonName;
    }
    public int getmoves1_damage() {
        return this.moves.get(0).getPower();
    }
    public int getmoves2_damage() {
        return this.moves.get(1).getPower();
    }
    //this method creates for counting the pokemon health receive damage
    public int ReceiveDamage(int damage) {
        return this.health = this.health - damage;
    }

    //this method creates to check if Pokemon fainted
    public boolean isfainted(){
        if(health <= 0){
            return true;
        }else{
            return false;
        }
    }

    //this method is to write the Pokemon state
    @Override
    public String toString() {
        return this.pokemonName + " ( " + this.type + " ) " + "- health: "+ this.health + " )";
    }

    //this method is to get the information about move
    public String getmove(int index) {
        return this.moves.get(index).toString();
    }

    public int getHealth() {
        return this.health;
    }




}
