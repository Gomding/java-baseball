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
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String command;

    public void startGame() throws Exception{
        while(true) {
            System.out.print("1. 게임 시작 / 2. 게임 종료 입력 > ");
            command = br.readLine();
            if (command.equals("1")) {
                Computer computer = new Computer();
                String comNum = computer.getNumber();
                playGame(comNum);
            }else if (command.equals("2")) {
                System.out.println("게임을 종료합니다.");
                break;
            }
            System.out.println("1 또는 2를 입력해주세요.");
        }
    }

    public void playGame(String comNum) throws Exception{
        int count = 0;
        while(true) {
            System.out.print("1이상 9이하의 숫자 3자리를 입력해주세요 > ");
            String userNum = new User().requestNumber();
            if (comNum.equals(userNum)) {
                System.out.println("스트라이크!! 게임 종료.");
                System.out.println("시도 횟수 : " + count + "회");
                break;
            }
            checkNum(userNum, comNum);
            count++;
        }
    }

    public void checkNum(String userNum, String comNum) {
        for (int i = 0; i < 3; i++) {
            if (comNum.contains(String.valueOf(userNum.charAt(i)))) {
                System.out.println("볼");
                return;
            }
        }
        System.out.println("포볼!");
    }
}
