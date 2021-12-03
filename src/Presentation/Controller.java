package Presentation;

import Business.PokeManager;
import Business.Pokemon;
import edu.salleurl.profile.renderer.ProfileRenderException;
import edu.salleurl.profile.renderer.ProfileRendererFactory;

import java.util.Random;

public class Controller {
    private final Menu menu;
    private final PokeManager pokeManager;
    private final Random random = new Random();
    private final int maxNum =101;


    public Controller(Menu menu, PokeManager pokeManager) {
        this.menu = menu;
        this.pokeManager = pokeManager;
    }
    private int generateRandomnum(){
        return random.nextInt(maxNum)+1;
    }

    public void run() throws ProfileRenderException {
        int option;
        do {
            menu.showMenu();
            option = menu.askForInteger("Enter an option: ");

            runOption(option);
        } while (option != 4);
    }

    private void runOption(int option) throws ProfileRenderException {
        boolean captured, continueCapture;
        Pokemon pokemon;

        switch (option) {
            case 1 ->{
                pokemon=askForPokemon();
                ProfileRendererFactory.createSwingProfileRenderer(1920,1080).render(pokemon);
            }
            case 2 ->{
                pokemon=askForPokemon();
                ProfileRendererFactory.createHTMLProfileRenderer("Images").render(pokemon);
            }
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
