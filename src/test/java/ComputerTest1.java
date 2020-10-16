/*
 * ComputerTest.java   1.0 2020/10/16
 *
 *
 */

import baseballgame.Computer;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Computer 클래스에 대한 단위 테스트
 *
 * @version 1.0 2020/10/16
 * @author https://github.com/Gomding
 */
public class ComputerTest1 {
    @Test
    public void 난수3개가_생성된다() {
        Computer computer = new Computer();
        assertThat(computer.getNumber().length()).isEqualTo(3);
    }

}
