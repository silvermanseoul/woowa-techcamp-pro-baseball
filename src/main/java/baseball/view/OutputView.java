package baseball.view;

public class OutputView {

    private static final String NOTHING = "낫싱";
    private static final String BALL_FORMAT = "%d볼\n";
    private static final String STRIKE_FORMAT = "%d스트라이크\n";
    private static final String BALL_STRIKE_FORMAT = "%d볼 %d스트라이크\n";
    private static final String CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String QUIT = "게임 종료";

    private OutputView() {
    }

    public static void printScore(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING);
            return;
        }

        if (strikeCount == 0) {
            System.out.printf(BALL_FORMAT, ballCount);
            return;
        }

        if (ballCount == 0) {
            System.out.printf(STRIKE_FORMAT, strikeCount);
            return;
        }

        if (strikeCount == 3) {
            System.out.printf(STRIKE_FORMAT, strikeCount);
            System.out.println(CLEAR);
            return;
        }

        System.out.printf(BALL_STRIKE_FORMAT, ballCount, strikeCount);
    }

    public static void printQuit() {
        System.out.println(QUIT);
    }
}
