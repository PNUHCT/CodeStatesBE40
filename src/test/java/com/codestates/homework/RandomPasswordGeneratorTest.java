package com.codestates.homework;

import com.codestates.CryptoCurrency;
import com.codestates.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codestates.helper.RandomPasswordGenerator.generate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // Given(전제조건)
        String expected = "Qawsedrf1234!!";

        // When(테스트 대상 지정)
        // 파라미터(대문자갯수, 소문자갯수, 숫자갯수, 특수문자갯수)
        String actual = generate(1,7,4, 2);

        // Then(테스트 결과 검증)
        assertEquals(expected,actual);
//        assertNotNull(expected, "should be not null");
//        assertThrows(Exception.class, () -> getCorrecPW(expected));
//        assertDoesNotThrow(() -> getCorrecPW(expected));

    }
    private String getCorrecPW(String pw) {
        return CryptoCurrency.map.get(pw);
    }
}
