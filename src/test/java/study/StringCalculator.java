package study;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculator {
    Integer calculator() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            calculate(result, values[i], Integer.parseInt(values[i + 1]));
        }
        return result;
    }

    int calculate(int prev, String operator, int next) {
        if (operator.equals("+")) {
            return prev + next;
        } else if (operator.equals("-")) {
            return prev - next;
        } else if (operator.equals("/")) {
            return prev / next;
        } else {
            return prev * next;
        }
    }


    @ParameterizedTest
    @CsvSource(value = {"2,+,3,5", "3,-,2,1", "2,*,4,8", "4,/,2,2"})
    void calculateTest(Integer prev, String operator, Integer next, Integer expected) {
        assertEquals(calculate(prev, operator, next), expected);
    }

    boolean isOperator(String value) {
        ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        if (operators.contains(value)) {
            return true;
        }
        return false;
    }

    @ParameterizedTest
    @CsvSource(value = {"+,true", "-,true", "*,true", "/,true"})
    void isOperator(String value, boolean expected) {
        assertEquals(this.isOperator(value), expected);
    }
}
