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
    private Pokemon pokemon;

    public Controller(Menu menu, PokeManager pokeManager) {
        this.menu = menu;
        this.pokeManager = pokeManager;
    }

    private int generateRandomNum(){
        int maxNum = 101;
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
        switch (option) {
            case 1 -> showJava();
            case 2 -> showHTML();
            case 3 -> capturePokemon();
            case 4 -> exitMenu();
            default -> menu.showMessage("Wrong option. Enter a number from 1 to 4, both included");
        }
    }

    private void capturePokemon(){
        boolean captured, continueCapture;
        do {
            pokemon=askForPokemon();
            if (pokemon==null)pokemonNotFound();
        }while (pokemon==null);
        menu.showMessage("Attempting to catch " + pokemon.getName() + " (" + pokemon.getId() + ")...");
        menu.spacing();
        do {
            captured = pokeManager.capturePokemon(pokemon, generateRandomNum());
            continueCapture = menu.askForAnswer(random.nextInt(3));

        } while (!captured && continueCapture);
        menu.spacing();
        if (!captured) {
            menu.showMessage("Coulnd't catch " + pokemon.getName() + " (" + pokemon.getId() + ")...");
        } else menu.showMessage("Gotcha " +pokemon.getName() + " (" + pokemon.getId() + ") was caught!");

        menu.spacing();
    }

    private void exitMenu() {
        menu.spacing();
        menu.showMessage("See you later, Feraligatr!");
    }

    private void showHTML() throws ProfileRenderException {
        menu.spacing();
        do {
            pokemon=askForPokemon();
            if (pokemon!=null){
                menu.showMessage("Opening the HTML file showing the Profile for"+pokemon.getName()+" ("+pokemon.getId()+")...");
                ProfileRendererFactory.createHTMLProfileRenderer("PokemonImages").render(pokemon);
            }else pokemonNotFound();
        }while(pokemon==null);
        menu.spacing();
    }

    private void showJava() throws ProfileRenderException {
        menu.spacing();
        do {
            pokemon=askForPokemon();
            if(pokemon!=null){
                menu.showMessage("Opening the window showing the Profile for "+pokemon.getName()+" ("+pokemon.getId()+")...");
                ProfileRendererFactory.createSwingProfileRenderer(1920,1080).render(pokemon);
            }else pokemonNotFound();
        }while(pokemon==null);
        menu.spacing();
    }

    private void pokemonNotFound(){
        menu.spacing();
        menu.showMessage("The Pokemon is not in the Pokedex, please try another one.");
        menu.spacing();
    }

    private Pokemon askForPokemon(){
        return pokeManager.findPokemonById(menu.askForInteger("Which Pokémon? "));
    }
}
