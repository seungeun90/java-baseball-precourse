package baseball.controller;

import baseball.model.MatchResult;
import baseball.model.Balls;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final InputHandler inputHandler;

    public GameController(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    public void start(){
        Balls computerBalls = new Balls().getRandomBalls();

        View.showMessage(View.GAME_START.getMessage());

        MatchResult result = new MatchResult();

        while (!result.isGameOver()) {
            result = play(computerBalls);
        }

        View.showMessage(View.ALL_STRIKE.getMessage());
        quitOrstart();
    }
    public MatchResult play(Balls computerBalls){
        MatchResult result = new MatchResult();
        Balls userBalls = inputHandler.getBalls(Console.readLine());
        result = computerBalls.play(userBalls);
        View.showMessage(result.getResult());

        return result;
    }
    public void quitOrstart(){
        View.showMessage(View.GAME_RESTART.getMessage());
        if(inputHandler.isRestart(Console.readLine())){
            start();
        };
    }

}
