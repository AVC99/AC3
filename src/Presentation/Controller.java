package Presentation;

import Business.Legendary;
import Business.Mythic;
import Business.PokeManager;
import Business.Pokemon;
import Persistance.ReadFiles;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    private Menu menu;
    private PokeManager pokeManager;
    private Random random = new Random();
    private final int maxNum =101;


    public Controller(Menu menu, PokeManager pokeManager) {
        this.menu = menu;
        this.pokeManager = pokeManager;
    }
    private int generateRandomnum(){
        return random.nextInt(maxNum)+1;
    }

    public void run() {
        int option;
        do {
            menu.showMenu();
            option = menu.askForInteger("Enter an option: ");

            runOption(option);
        } while (option != 4);
    }

    private void runOption(int option) {
        boolean captured=false;
        switch (option) {
            case 1 -> menu.spacing();
            case 2 -> menu.spacing();
            case 3 -> {
                int pokemonid= menu.askForInteger("Which Pokémon? ");
                do{
                    caputred= pokeManager.capturePokemon(pokeManager.findPokemonById(pokemonid),generateRandomnum());
                }while(!captured);

            }
            case 4 -> exitMenu();
            default -> menu.showMessage("Wrong option. Enter a number from 1 to 6, both included");
        }
    }

    private void exitMenu() {
        menu.spacing();
        menu.showMessage("See you later, Feraligatr!");
    }
}
