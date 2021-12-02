package Business;

import Persistance.ReadFiles;
import Presentation.Menu;

import java.util.*;

public class PokeManager {

    private ArrayList<Pokemon> pokemonList;


    private final String[] failPhrases= {"Gah! It was so close, too! Want to try again?","Aargh! Almost had it! Want to try again?","Aww! It appeared to be caught! Want to try again?" };


    public PokeManager(ReadFiles readFiles){
        pokemonList=new ArrayList<>();
        pokemonList= readFiles.loadPokemon();
        Collections.sort(pokemonList);
    }
    public boolean capturePokemon(Pokemon pokemonToCapture, int random){
        boolean captured;

        captured=pokemonToCapture.capture(random);

        return captured;
    }
    public Pokemon findPokemonById(int id){
        for(Pokemon p: pokemonList){
            if(p.getId()==id)return p;
        }
        return null;
    }
}
