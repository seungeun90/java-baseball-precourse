package baseball;

import baseball.controller.GameController;
import baseball.controller.InputHandler;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController(new InputHandler());
        controller.start();
    }
}
