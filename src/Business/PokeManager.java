package Business;

import Persistance.PokeDAO;

import java.util.*;

public class PokeManager {

    private ArrayList<Pokemon> pokemonList;

    public PokeManager(PokeDAO pokeDAO){
        this.pokemonList=new ArrayList<>();
        this.pokemonList= pokeDAO.loadPokemon();
        Collections.sort(pokemonList);
    }

    public boolean capturePokemon(Pokemon pokemonToCapture, int random){
        return pokemonToCapture.capture(random);
    }

    public Pokemon findPokemonById(int id){
        for(Pokemon p: pokemonList){
            if(p.getId()==id) return p;
        }
        return null;
    }
}
