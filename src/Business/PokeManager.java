package Business;

import Persistance.ReadFiles;
import Presentation.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PokeManager {

    private ArrayList<Pokemon> pokemonList;
    private final int maxNum =101;
   private Random random=new Random();


    public PokeManager(ReadFiles readFiles){
        pokemonList=new ArrayList<>();
        this.pokemonList.addAll(readFiles.loadCommon())  ;
        this.pokemonList.addAll(readFiles.loadMythic());
        this.pokemonList.addAll(readFiles.loadLegendaries());
        Collections.sort(pokemonList);
    }
    public void capturePokemon(int pokemonNum){

        //random.nextInt(maxNum)+1
        System.out.println(pokemonList.get(pokemonNum).getPokemonClass());

        switch (pokemonList.get(pokemonNum).getPokemonClass()){
            case "Common"->captureCommon(pokemonList.get(pokemonNum));
            case "Mythic" ->captureMythic(pokemonList.get(pokemonNum));
            case "Legendary"->captureLegendary(pokemonList.get(pokemonNum));
        }
    }
    public boolean captureCommon(Pokemon pokemonToCapture){
        if (random.nextInt(maxNum)+1 <= pokemonToCapture.getCaptureRate()/1.5){
            return true;
        }
        return false;
    }
    public boolean captureMythic(Pokemon pokemonToCapture){
        do{
            if (random.nextInt(maxNum)+1 <= Math.sqrt(pokemonToCapture.getCaptureRate()/1.5)*(pokemonToCapture.getRarity()/pokemonToCapture.getCaptureRate()) ){
                return true;
            }
        }while(new Menu().askForString("a")!="Y");
        return false;
    }
    public boolean captureLegendary(Pokemon pokemonToCapture){

        if (random.nextInt(maxNum)+1 <= (pokemonToCapture.getCaptureRate()/1.5)*(1 - (pokemonToCapture.getPower() / 1440))) {
            return true;
        }
        return false;
    }
}
