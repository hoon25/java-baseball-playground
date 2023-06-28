package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] twoNumber = "1,2".split(",");
        assertThat(twoNumber).contains("1", "2");

        String[] oneNumber = "1".split(",");
        assertThat(oneNumber).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 통해 특정 위치의 문자를 가져온다.")
    void charAt() {
        char actual = "abc".charAt(0);
        assertThat(actual).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt에 문자열의 index를 넘는 문자를 가져오면 StringIndexOutOfBoundsException이 발생한다.")
    void charAtThrowException() {
        assertThatThrownBy(() -> {
            char actual = "abc".charAt(10);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 10");
    }
}
