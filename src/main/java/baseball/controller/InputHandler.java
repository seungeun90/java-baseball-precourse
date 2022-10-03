package baseball.controller;

import baseball.model.Ball;
import baseball.model.Balls;

public class InputHandler {

    public Balls getBalls(String numbers){
        Balls balls = new Balls();
        int i=1;
        validateSize(numbers);
        for(String s : numbers.split("")){
            validateNumber(s);
            validateString(s);

            balls.addBaseball(new Ball(Integer.parseInt(s),i++));
        }
        return balls;
    }

    public void validateString(String input){
        try{
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public void validateNumber(String input){
        if("".equals(input)){
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }
    private void validateSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 숫자는 3개여야만 합니다.");
        }
    }

    public boolean isRestart(String input) {
        validateNumber(input);
        validateString(input);
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1, 2만 입력해주세요.");
    }
}
