import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class accumulator {

    public boolean q6(String input) {
        // 특수 문자 패턴 정의
        String 구분자 = "[^a-zA-Z0-9\\s-]"; //알파벳, 숫자, 공백 문자가 아닌 모든 특수 문자
        String nums = input;
        boolean result = false;

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            구분자 = parts[0].substring(2);
            nums = parts[1];
        }

        String[] arrayNum = nums.split("[" + 구분자 + "\n]");
        int acc = 0;

        for (String num : arrayNum) {
            if (!num.isEmpty()) {
                int currentNumber = Integer.parseInt(num);
                if (currentNumber < 0) {
                    result = false;
                    throw new RuntimeException("음수가 포함되어 있습니다: " + currentNumber);
                }
                acc += currentNumber;
            }
            result = true;
        }
        System.out.println(" 총 계산값 " + acc);
        return result;
    }
}
