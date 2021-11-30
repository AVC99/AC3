package Business;

import Persistance.ReadFiles;
import Presentation.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PokeManager {

    private ArrayList<Pokemon> pokemonList;
    private final int maxNum =101;
   private Random random=new Random();
   private String option;
   private final String[] failPhrases= {"Gah! It was so close, too! Want to try again?","Aargh! Almost had it! Want to try again?","Aww! It appeared to be caught! Want to try again?" };


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
        do{
            if (random.nextInt(maxNum)+1 <= pokemonToCapture.getCaptureRate()/1.5){
                return true;
            }

        }while(!continueCapture());
        return false;
    }
    public boolean captureMythic(Pokemon pokemonToCapture){

        do{
            if (random.nextInt(maxNum)+1 <= Math.sqrt(pokemonToCapture.getCaptureRate()/1.5)*(pokemonToCapture.getRarity()/pokemonToCapture.getCaptureRate()) ){
                return true;
            }
           continueCapture();

        }while(!continueCapture());
        return false;
    }
    public boolean captureLegendary(Pokemon pokemonToCapture){

        if (random.nextInt(maxNum)+1 <= (pokemonToCapture.getCaptureRate()/1.5)*(1 - (pokemonToCapture.getPower() / 1440))) {
            return true;
        }
        return false;
    }
    public boolean continueCapture(){
        Scanner scanner=new Scanner(System.in);
        String answer;
        System.out.print( failPhrases[random.nextInt(3)]);
        do {
            answer = answerTryAgain();
        }while(!answer.equals("n"));//----------------------------------
        return false;
    }
    public String answerTryAgain(){
        String answer;
        Menu menu= new Menu();
       answer= menu.askForString("Want to try again?[y/n]");
        if (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")){

        }
        return answer.toLowerCase();
    }
}
