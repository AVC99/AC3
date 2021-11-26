import Business.PokeManager;
import Presentation.Controller;
import Presentation.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        PokeManager marketManager = new PokeManager();

        Controller controller = new Controller(menu, marketManager);
        controller.run();
    }
}
