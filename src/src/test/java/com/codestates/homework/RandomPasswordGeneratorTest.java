package com.codestates.homework;

import com.codestates.CryptoCurrency;
import com.codestates.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codestates.helper.RandomPasswordGenerator.generate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        int upper = 0;
        int lower = 0;
        int num = 0;
        int special = 0;
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // Given(전제조건)
        String expected = "Qawsedrf1234!!";
        for(int i=0 ; i<expected.length() ; i++) {
            char ch = expected.charAt(i);
            if(ch >= 'A' && ch <= 'Z') upper++;
            else if(ch >= 'a' && ch <= 'z') lower++;
            else if(ch >= '0' && ch <= '9') num++;
            else special++;
        }

        int [] actArr = {2, 6, 4, 2};
        String expStr = String.format("%d, %d, %d, %d", upper, lower, num, special);
        String actStr = String.format("%d, %d, %d, %d", actArr[0], actArr[1], actArr[2], actArr[3]);


        // When(테스트 대상 지정)
        // 파라미터(대문자갯수, 소문자갯수, 숫자갯수, 특수문자갯수)
        String actual = generate(actArr[0],actArr[1],actArr[2],actArr[3]);

        // Then(테스트 결과 검증)
        assertEquals(expStr,actStr);
//        assertNotNull(expected, "should be not null");
//        assertThrows(Exception.class, () -> getCorrecPW(expected));
//        assertDoesNotThrow(() -> getCorrecPW(expected));

    }
    private String getCorrecPW(String pw) {
        return CryptoCurrency.map.get(pw);
    }
}
