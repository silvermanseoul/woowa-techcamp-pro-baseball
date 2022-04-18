package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER_NUMBER = "숫자를 입력해주세요: ";
    private static final String RESTART_OR_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {
    }

    public static String readNumber() {
        System.out.print(ENTER_NUMBER);
        return Console.readLine();
    }

    public static String readAfterGameClear() {
        System.out.println(RESTART_OR_QUIT);
        return Console.readLine();
    }
}
