package Presentation;

import Business.PokeManager;
import Business.Pokemon;
import Renderer.HTMLPokemonRender;
import edu.salleurl.profile.Profileable;

import java.util.Random;

public class Controller {
    private Menu menu;
    private PokeManager pokeManager;
    private Random random = new Random();
    private final int maxNum =101;
    private HTMLPokemonRender htmlPokemonRender= new HTMLPokemonRender();

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
        Pokemon pokemon;
        switch (option) {
            case 1 ->{
                pokemon=askForPokemon();
                htmlPokemonRender.render(pokemon.getSprite());
            }
            case 2 -> menu.spacing();
            case 3 -> {
                pokemon=this.askForPokemon();
                if (pokemon != null){
                    menu.showMessage("Attempting to catch " + pokemon.getName() + " (" + pokemon.getId() + ")...");
                    menu.spacing();
                    do {
                        captured = pokeManager.capturePokemon(pokemon, generateRandomnum());
                        continueCapture = menu.askForAnswer(random.nextInt(3));

                    } while (!captured && continueCapture);
                    menu.spacing();
                    if (!captured) {
                        menu.showMessage("Coulnd't catch " + pokemon.getName() + " (" + pokemon.getId() + ")...");
                    } else
                        menu.showMessage("Gotcha " +pokemon.getName() + " (" + pokemon.getId() + ") was caught!");
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
    private Pokemon askForPokemon(){
        return pokeManager.findPokemonById(menu.askForInteger("Which Pokémon? "));
    }
}
