import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringTest {

    @Test
    public void q1(){
        String[] q1 = "1,2".split(",");
        assertThat(q1).contains("1").contains("2");
        assertThat(q1).containsExactly("1","2");
    }

    @Test
    public void q2(){
        String q2 = "(1,2)";
        System.err.println(q2.substring(1,5));
        assertThat(q2.substring(1,5)).contains("1,2");
    }

    @Test
    @DisplayName("get char position")
    public void q3(){
        String q3 = "abc";
        assertThatThrownBy(() -> {
                    q3.charAt(q3.length());
                }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("string 탐색 범위 초과 ")
                .hasMessageContaining(String.valueOf(q3.length()));

    }

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
    public void q4(int check){
        //assertThat(numbers.contains(1)).isTrue();
        //assertThat(numbers.contains(2)).isTrue();
        //assertThat(numbers.contains(3)).isTrue();
        assertTrue(numbers.contains(check));

    }
    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    public void q5(int check, boolean bikyo){
        boolean result = numbers.contains(check);
        assertEquals(bikyo,result);
    }

    @Test
    public void q6(){
        accumulator acc = new accumulator();
        assertTrue(acc.q6("30&60?-90^100"));
    }

}