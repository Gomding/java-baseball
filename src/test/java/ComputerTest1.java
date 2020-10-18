/*
 * ComputerTest.java   1.0 2020/10/16
 *
 *
 */

import baseballgame.Computer;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Computer 클래스에 대한 단위 테스트
 *
 * @version 1.0 2020/10/16
 * @author https://github.com/Gomding
 */
public class ComputerTest1 {

    Computer computer;

    @Before
    public void Computer_객체생성() {
        computer = new Computer();
    }

    @Test
    public void 난수3개가_생성된다() {
        assertThat(computer.getNumber().length()).isEqualTo(3);
    }

    @Test
    public void addNumber_메소드_테스트() {
        int num = computer.makeRandomNumber();
        assertThat(num).isLessThan(10);
    }
}
