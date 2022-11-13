package lotto.IOTest;

import lotto.IO.LottoIOHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoIOHandlerTest extends IOTest {
    private static LottoIOHandler lottoIOHandler;
    @BeforeAll
    static void initAll() {lottoIOHandler = new LottoIOHandler();}

    @DisplayName("당첨 번호를 입력 검증")
    @Test
    void getLottoAnswerTest(){
        systemIn("1,2,3,4,5,6");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lottoIOHandler.getLottoAnswer()).isEqualTo(list);
    }

    @DisplayName("잘못된 당첨 번호 예외처리 검증")
    @Test
    void validateInputTest_notInputComma_IllegalArgumentException(){
        String input = "123456";
        assertThatThrownBy(() -> lottoIOHandler.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ',' 구분자를 통해 1~45사이의 수 6개를 입력해주세요");
    }

}
