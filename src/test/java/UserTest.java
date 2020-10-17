/*
 * UserTest.java   1.0 2020/10/16
 *
 *
 */

import baseballgame.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * User 클래스에 대한 단위 테스트
 *
 * @version 1.0 2020/10/16
 * @author https://github.com/Gomding
 */
public class UserTest {

    @Test
    public void 사용자입력_잘된다() throws Exception{
        User user = new User();
        user.requestNumber();
        assertThat(user.getNumber()).isEqualTo("123");
        assertThat(user.getNumber().length()).isEqualTo(3);
    }

}
