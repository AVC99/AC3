package Business;

import Persistance.ReadFiles;

import java.util.ArrayList;

public class PokeManager {

    private ArrayList<Pokemon> pokemonList;

    public PokeManager(ReadFiles readFiles){
         this.pokemonList.addAll(readFiles.loadCommon())  ;
        this.pokemonList.addAll(readFiles.loadMythic());
        this.pokemonList.addAll(readFiles.loadLegendaries());


    }
}
