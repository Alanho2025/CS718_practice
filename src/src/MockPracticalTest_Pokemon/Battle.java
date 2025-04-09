package MockPracticalTest_Pokemon;

import PracticeFour_exception.Keyboard;

import java.io.*;
import java.lang.invoke.SwitchPoint;
import java.util.*;

public class Battle {
    //create fields for player and opponent
    Pokemon PlayerPokemon;
    Pokemon opponentPokemon;

    //create constructor for Player and opponent
    public Battle(Pokemon PlayerPokemon, Pokemon opponentPokemon) {
        this.PlayerPokemon = PlayerPokemon;
        this.opponentPokemon = opponentPokemon;
    }

    //Create method for Startballe round
    public void startBattle() throws Outvalid {
            String player = PlayerPokemon.toString();
            String opponent = opponentPokemon.toString();
            System.out.println(PlayerPokemon);
            System.out.println(opponentPokemon);

            try (PrintWriter logWriter = new PrintWriter("BattleLog.txt")) {
                String fullLog = "\n------------------\n" + player + "\n" + opponent + "\n" + "\n------------------\n" ;
                while (true) {
                    String playerLog = playersTurn();
                    fullLog += playerLog + "\n";
                    if (opponentPokemon.isfainted()) {
                        break;
                    }
                    fullLog += "\n------------------\n";
                    String opponentLog = opponentTurn();
                    fullLog += opponentLog + "\n";
                    if ( PlayerPokemon.isfainted()) {
                        break;
                    }
                    fullLog += "\n------------------\n";

                }

                logWriter.println(fullLog);
            } catch (IOException e) {
                e.printStackTrace();
            }



        System.out.println("Battle ended");
    }

    //Create for Player's turn
    public String playersTurn() throws Outvalid {
        String playerLog = "";
        System.out.println("Decide your move");
        ArrayList<Integer> MoveInstrction = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            MoveInstrction.add(i);
        }
        System.out.println("You can choose from the following:");
        for (int i = 0; i < MoveInstrction.size(); i++) {
            switch (MoveInstrction.get(i)) {
                case 0:
                    System.out.println("1. " + PlayerPokemon.getmove(0));
                    break;
                case 1:
                    System.out.println("2. " + PlayerPokemon.getmove(1));
                    break;
            }

        }
        boolean flag = false;
        int input = 0;
        while (!flag) {
            input = Integer.parseInt(Keyboard.readInput());
            if (input > MoveInstrction.size()) {
                throw new Outvalid("You don't have this move, Type again!!");
            } else {
                flag = true;
            }
        }

        switch (input) {
            case 1:
                playerLog = PlayerPokemon.getPokemonName() + " excute " + PlayerPokemon.getmove(0) + "cause damage" + PlayerPokemon.getmoves1_damage();
                opponentPokemon.ReceiveDamage(PlayerPokemon.getmoves1_damage());
                playerLog = checkpokemonHealth(playerLog);
                System.out.println(checkpokemonHealth(playerLog));
                if (opponentPokemon.getHealth() <= 0) {
                    System.out.println("You win");
                    playerLog = playerLog + "\n"+ "You win";
                }
                break;
            case 2:
                playerLog = PlayerPokemon.getPokemonName() + " excute " + PlayerPokemon.getmove(1) + "cause damage" + PlayerPokemon.getmoves2_damage();
                opponentPokemon.ReceiveDamage(PlayerPokemon.getmoves2_damage());
                System.out.println(checkpokemonHealth(playerLog));
                if (opponentPokemon.getHealth() <= 0) {
                    System.out.println("You win");
                    playerLog = playerLog + "\n" + "You win";
                }
                break;

        }
        return playerLog;

    }

    //Create for opponent's turn
    public String opponentTurn() throws Outvalid {
        String opponentLog = "";
        int randomInt = (int) (Math.random() * 2);
        switch (randomInt) {
            case 0:
                opponentLog = opponentPokemon.getPokemonName() + " Excute " + opponentPokemon.getmove(0) + " cause damage" + opponentPokemon.getmoves1_damage();
                PlayerPokemon.ReceiveDamage(opponentPokemon.getmoves1_damage());
                opponentLog =  checkpokemonHealth(opponentLog);
                System.out.println(opponentLog);
                if (PlayerPokemon.getHealth() <= 0) {
                    System.out.println("AI win");
                    opponentLog = opponentLog +"\n" + "AI win";
                }
                break;
            case 1:
                opponentLog =opponentPokemon.getPokemonName() + " Excute " + opponentPokemon.getmove(1) + " cause damage" + opponentPokemon.getmoves2_damage();
                PlayerPokemon.ReceiveDamage(opponentPokemon.getmoves2_damage());
                opponentLog = checkpokemonHealth(opponentLog);
                System.out.println(opponentLog);
                if (PlayerPokemon.getHealth() <= 0) {
                    System.out.println("AI win");
                    opponentLog = opponentLog +"\n" + "AI win";
                }
                break;

        }
        return opponentLog;
    }

    public String checkpokemonHealth(String log) throws Outvalid {
        log = log + "\n" + PlayerPokemon.getPokemonName() + " current health: "+PlayerPokemon.getHealth() +"\n" + opponentPokemon.getPokemonName() +" current health: "+opponentPokemon.getHealth() +"\n";
        return log;
    }
}
