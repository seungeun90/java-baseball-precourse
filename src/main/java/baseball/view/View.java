package baseball.view;

public enum View {
    GAME_START("숫자를 입력해주세요 : "),
    ALL_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private String message;

    public static void showMessage(String message){
        System.out.println(message);
    }
    public String getMessage(){
        return this.message;
    }
    View(String message){
        this.message = message;
    }
}
