package baseball.domain;

import java.util.List;

public class Game {

    private Suit computerSuit;
    private int ballCount;
    private int strikeCount;
    private boolean isCleared;

    public Game(Suit computerSuit) {
        this.computerSuit = computerSuit;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isCleared() {
        return isCleared;
    }

    public void checkScore(Suit userSuit) {
        ballCount = 0;
        strikeCount = 0;

        List<Integer> userNumbers = userSuit.getNumbers();
        for (int i = 0; i < userNumbers.size(); i++) {
            boolean isBall = isBall(i, userNumbers);
            incrementBallCountIf(isBall);

            boolean isStrike = isStrike(i, userNumbers);
            incrementStrikeCountIf(isStrike);
        }

        updateCleared();
    }

    private void updateCleared() {
        if (strikeCount == Suit.NUM_COUNT) {
            isCleared = true;
        }
    }

    private boolean isBall(int index, List<Integer> userNumbers) {
        int userNumber = userNumbers.get(index);
        int computerIndex = computerSuit.getNumbers().indexOf(userNumber);

        return computerIndex != -1 && computerIndex != index;
    }

    private boolean isStrike(int index, List<Integer> userNumbers) {
        int userNumber = userNumbers.get(index);
        int computerIndex = computerSuit.getNumbers().indexOf(userNumber);

        return computerIndex == index;
    }

    private void incrementBallCountIf(boolean isBall) {
        if (isBall) {
            ballCount++;
        }
    }

    private void incrementStrikeCountIf(boolean isStrike) {
        if (isStrike) {
            strikeCount++;
        }
    }
}
