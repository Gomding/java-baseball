/*
 * BaseballGame.java  2020/10/16
 *
 */

package baseballgame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 전체적인 게임 시작 기능
 * 1번을 입력하면 게임 시작 , 2번을 입력하면 게임 종료
 * 그 외의 번호, 숫자가 아닌 문자를 입력하게 되면 다시 입력 요청
 * 이 게임은 2번을 누르기 전까지 계속 반복됩니다.
 *
 * @version 1.0 2020/10/16
 * @author https://github.com/Gomding
 */
public class BaseballGame {

    public boolean startGame() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while(true) {
            System.out.println("1. 게임 시작 / 2. 게임 종료 입력 > ");
            command = br.readLine();
            if (command.equals("1")) {
                return true;
            }else if (command.equals("2")) {
                return false;
            }
            System.out.println("1 또는 2를 입력해주세요.");
        }
    }
}
