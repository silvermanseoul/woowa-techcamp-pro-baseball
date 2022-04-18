package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Suit {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    public static final int NUM_COUNT = 3;

    private final List<Integer> numbers;

    private Suit(List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(new ArrayList<>(numbers));
    }

    public static Suit create() {
        return new Suit(generateUniqueRandomNumbers());
    }

    public static Suit from(String input) {
        validateInput(input);
        return new Suit(parse(input));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static List<Integer> generateUniqueRandomNumbers() {
        List<Integer> nums = new ArrayList<>(NUM_COUNT);
        while (nums.size() < NUM_COUNT) {
            int num = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            addIfNotExists(num, nums);
        }

        return nums;
    }

    private static void addIfNotExists(int element, List<Integer> targetList) {
        if (targetList.contains(element)) {
            return;
        }

        targetList.add(element);
    }

    private static void validateInput(String input) {
        validateLength(input);
        validateDuplicate(input);
        for (char c : input.toCharArray()) {
            validateIfDigit(c);
            validateRange(c);
        }
    }

    private static void validateLength(String input) {
        if (input.length() != NUM_COUNT) {
            throw new IllegalArgumentException("잘못된 길이입니다.");
        }
    }

    private static void validateDuplicate(String input) {
        List<String> list = Arrays.asList(input.split(""));
        Set<String> set = new HashSet<>(list);
        if (list.size() > set.size()) {
            throw new IllegalArgumentException("중복이 존재합니다.");
        }
    }

    private static void validateIfDigit(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private static void validateRange(char c) {
        int c1 = Character.getNumericValue(c);
        if (c1 < MIN_NUM || c1 > MAX_NUM) {
            throw new IllegalArgumentException("숫자가 정해진 범위를 벗어납니다.");
        }
    }

    private static List<Integer> parse(String input) {
        List<Integer> inputNums = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            inputNums.add(Character.getNumericValue(ch));
        }

        return inputNums;
    }
}
