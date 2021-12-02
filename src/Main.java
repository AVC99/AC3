import Business.PokeManager;
import Persistance.PokeDAO;
import Presentation.Controller;
import Presentation.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        PokeManager pokeManager = new PokeManager(new PokeDAO());

        Controller controller = new Controller(menu, pokeManager);

        controller.run();
    }
}
