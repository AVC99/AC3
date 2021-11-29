package Presentation;

import Business.Legendary;
import Business.Mythic;
import Business.PokeManager;
import Business.Pokemon;
import Persistance.ReadFiles;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private Menu menu;
    private PokeManager pokeManager;


    public Controller(Menu menu, PokeManager pokeManager) {
        this.menu = menu;
        this.pokeManager = pokeManager;
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
        switch (option) {
            case 1 -> menu.spacing();
            case 2 -> menu.spacing();
            case 3 -> {
                int pokemonNum= menu.askForInteger("Which Pokémon? ");
                pokeManager.capturePokemon(pokemonNum);
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
