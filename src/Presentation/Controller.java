package Presentation;

import Business.Legendary;
import Business.Mythic;
import Business.PokeManager;
import Business.Pokemon;
import Persistance.ReadFiles;

import java.util.ArrayList;

public class Controller {
    private Menu menu;
    private ArrayList<Pokemon> commonList;
    private ArrayList<Mythic> mythicList;
    private ArrayList<Legendary> legendaryList;
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
        commonList = new ReadFiles().loadCommon();
        mythicList=new ReadFiles().loadMythic();
        legendaryList=new ReadFiles().loadLegendaries();

        switch (option) {
            case 1 -> menu.spacing();

            case 2 -> menu.spacing();
            case 3 -> menu.spacing();
            case 4 -> exitMenu();
            default -> menu.showMessage("Wrong option. Enter a number from 1 to 6, both included");
        }
    }

    private void exitMenu() {
        menu.spacing();
        menu.showMessage("See you later, Feraligatr!");
    }
}
