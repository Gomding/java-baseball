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
    Computer computer;
    User user = new User();
    int count;

    /**
     * 게임을 시작을 알리는 메서드
     * isPlayOrStop() 메서드가 true값이라면 게임을 종료합니다.
     *
     * @throws Exception
     */
    public void startGame() throws Exception{
        System.out.println("숫자 야구 게임을 시작하겠습니다.");
        while(true) {
            if (isPlayOrStop()) {
                System.out.println("게임을 종료합니다.");
                break;
            }
            resetGame();
            playGame();
        }
    }

    /**
     * 1 또는 2를 입력하여 게임 시작 또는 게임 종료 명령을 받는 메서드
     * 1을 입력 받으면 야구 게임을 시작함
     * 2를 입력 받으면 게임을 종료
     *
     * @return 입력값이 2라면 true를 반환함
     * @throws Exception
     */
    public boolean isPlayOrStop() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while (true) {
            System.out.print("1. 게임 시작 / 2. 게임 종료 > ");
            command = br.readLine();
            if (command.equals("1") || command.equals("2")) {
                break;
            }
            System.out.println("[입력 오류] 1 또는 2를 입력해주세요.");
        }
        return command.equals("2");
    }

    /**
     * computer 객체에 새로운 3자리 숫자로 초기화하기 위함
     *
     */
    public void resetGame() {
        computer = new Computer();
        count = 0;
    }

    public void playGame() throws Exception{
        while(true) {
            System.out.print("1이상 9이하의 숫자 3자리를 입력해주세요 > ");
            user.requestNumber();
            count++;
            if (isCorrectAnswer()) {
                break;
            }
            checkNum();
        }
    }

    public boolean isCorrectAnswer() {
        if (user.getNumber().equals(computer.getNumber())) {
            System.out.println("정답!! 시도 횟수 : " + count + "회");
            return true;
        }
        return false;
    }

    public void checkNum() {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < user.getNumber().length(); i++) {
            if (isStrike(i)) {
                strike++;
            } else if (isBall(i)) {
                ball++;
            }
        }
        printResult(strike, ball);
    }

    public boolean isStrike(int i) {
        return (user.getNumber().charAt(i) == computer.getNumber().charAt(i));
    }

    public boolean isBall(int i) {
        return (computer.getNumber().contains(String.valueOf(user.getNumber().charAt(i))));
    }

    public void printResult(int strike, int ball) {
        StringBuilder result = new StringBuilder();
        if (strike != 0) {
            result.append(strike);
            result.append(" 스트라이크 ");
        }
        if (ball != 0) {
            result.append(ball);
            result.append(" 볼");
        }
        if (result.length() == 0) {
            result.append("낫싱(포볼)");
        }
        System.out.println(result);
    }
}
