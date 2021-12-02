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
    private final String[] failPhrases= {"Gah! It was so close, too! Want to try again?","Aargh! Almost had it! Want to try again?","Aww! It appeared to be caught! Want to try again?" };


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
        boolean captured, continueCapture;
        Pokemon pokemonToCapture;
        switch (option) {
            case 1 -> menu.spacing();
            case 2 -> menu.spacing();
            case 3 -> {
                int pokemonid = menu.askForInteger("Which Pokémon? ");
                pokemonToCapture = pokeManager.findPokemonById(pokemonid);
                if (pokemonToCapture != null){
                    menu.showMessage("Attempting to catch " + pokemonToCapture.getName() + " (" + pokemonToCapture.getId() + ")...");
                    menu.spacing();
                    do {
                        captured = pokeManager.capturePokemon(pokemonToCapture, generateRandomnum());
                        continueCapture = menu.askForAnswer(random.nextInt(3));

                    } while (!captured && continueCapture);
                    menu.spacing();
                    if (!captured) {
                        menu.showMessage("Coulnd't catch " + pokemonToCapture.getName() + " (" + pokemonToCapture.getId() + ")...");
                    } else
                        menu.showMessage("Gotcha " +pokemonToCapture.getName() + " (" + pokemonToCapture.getId() + ") was caught!");
                }else {
                    menu.spacing();
                    menu.showMessage("The Pokemon is not in the Pokedex, please try another one.");
                }
                menu.spacing();
            }
            case 4 -> exitMenu();
            default -> menu.showMessage("Wrong option. Enter a number from 1 to 4, both included");
        }
    }

    private void exitMenu() {
        menu.spacing();
        menu.showMessage("See you later, Feraligatr!");
    }
}
