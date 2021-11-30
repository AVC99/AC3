package Business;

import Persistance.ReadFiles;
import Presentation.Menu;

import java.util.*;

public class PokeManager {

    private ArrayList<Pokemon> pokemonList;
    private final int maxNum =101;
    private Random random=new Random();

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
        System.out.println("The pokemon is not in the pokedex, please try another one.");
        return null;
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
