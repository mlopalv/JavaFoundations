package codeacademy.learnintermediatejava.projectmedievalserialization;

import java.util.Scanner;
import java.util.Objects;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MedievalGame {

    /* Instance Variables */
    private Player player;

    /* Main Method */
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        MedievalGame game = new MedievalGame();

        game.player = game.start(console);

        game.addDelay(500);
        System.out.println("\nLet's take a quick look at you to make sure you're ready to head out the door.");
        System.out.println(game.player);

        game.addDelay(1000);
        System.out.println("\nWell, you're off to a good start, let's get your game saved so we don't lose it.");
        game.save();

        game.addDelay(2000);
        System.out.println("We just saved your game...");
        System.out.println("Now we are going to try to load your character to make sure the save worked...");

        game.addDelay(1000);
        System.out.println("Deleting character...");
        String charName = game.player.getName();
        game.player = null;

        game.addDelay(1500);
        game.player = game.load(charName, console);
        System.out.println("Loading character...");

        game.addDelay(2000);
        System.out.println("Now let's print out your character again to make sure everything loaded:");

        game.addDelay(500);
        System.out.println(game.player);
    } // End of main

    /* Instance Methods */
    private Player start(Scanner console) {
        // Add start functionality here
        Player player;
        //Art.homeScreen();
        System.out.print("Would you like to start a new game or load a saved game ? (Enter 'y' for yes or 'n' for no): ");
        String answer = console.next().toLowerCase();
        Helmet helmet = new Helmet("MyHelmet", 90, 80);
        while (true) {
            addDelay(500);
            if(answer.equals("y")){
                System.out.print("\nAhh... I knew I remembered you, what was your name again? Let me see if I can find your backpack: ");
                player = load(console.next(), console);
                player.setHelmet(helmet);
                break;
            }else if(answer.equals("n")){
                System.out.print("\nWell then, don't be shy, go ahead an tell me your name: ");
                String possibleName = console.next();
                while (true) {
                    System.out.println("Welcome " + possibleName + ", am I pronouncing that correctly? (Enter 'y' to confirm, 'n' to enter a new name");
                        String nameResponse = console.next().toLowerCase();
                    if (Objects.equals(nameResponse, "y")) break;
                        System.out.println("So sorry, can you spell it for me again?");
                        possibleName = console.next();
                }
                player = new Player(possibleName);
                player.setHelmet(helmet);
                break;
            }else{
                System.out.print("Sorry adventurer, I only speak the common tongue, please enter 'y' to load a game or 'n' to start a new game: ");
                answer = console.next().toLowerCase();
            }
        }

        return player;
    } // End of start

    private void save() {
        // Add save functionality here
        String fileName = "c:/tmp/"+this.player.getName()+".svr";
        try{

            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream playerSaver = new ObjectOutputStream(fos);
            playerSaver.writeObject(this.player);

        }catch(IOException e){
            System.out.println("No fue posible grabar su avance en el juego! Sorry!");
        }
    } // End of save

    private Player load(String playerName, Scanner console) {
        // Add load functionality here
        Player loadedPlayer;
        System.out.println("Cargando jugador "+playerName+"...");
        String path = "c:/tmp/"+playerName + ".svr";
        System.out.println("Este es el path del archivo a cargar: "+path);
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream playerLoader = new ObjectInputStream(fis);
            loadedPlayer = (Player)playerLoader.readObject();
        }catch(IOException e){
            addDelay(1500);
            System.out.println("No pude cargar su avance de juego (IOEXception)! Sorry!");
            addDelay(2000);
            loadedPlayer = new Player(playerName);
        }catch(ClassNotFoundException e){
            addDelay(1500);
            System.out.println("No pude cargar su avance de juego (ClassNotFoundException)! Sorry!");
            addDelay(2000);
            loadedPlayer = new Player(playerName);
        }
        
        return loadedPlayer;
    } // End of load

    // Adds a delay to the console so it seems like the computer is "thinking"
    // or "responding" like a human, not instantly like a computer.
    private void addDelay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}