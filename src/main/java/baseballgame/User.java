/*
 * User.java     1.0  2020/10/16
 *
 *
 */
package baseballgame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 사용자가 3자리 숫자를 입력하는 기능을 위한 클래스입니다.
 *
 * @version 1.0 2020/10/16
 * @author https://github.com/Gomding
 */
public class User {

    /* 숫자의 최대 길이 */
    private static final int SIZE = 3;

    /* 각 숫자가 1 이상인것을 확인하기 위한 값 (char 값으로 비교하기 위함) */
    private static final char START_VAL = '1';

    /* 각 숫자가 9 이하인것을 확인하기 위한 값 (char 값으로 비교하기 위함) */
    private static final char END_VAL = '9';

    /* 유저가 입력한 숫자를 담을 문자열 */
    private String number;
    private String input;

    /**
     * 입력한 숫자가 3자리인지, 숫자인지, 중복된 수자가 있는지 검사하는 메서드
     *
     * @throws Exception
     */
    public void requestNumber() throws Exception{
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
            if (checkSize() && checkNum() && checkDuplicate()) {
                number = input;
                break;
            }
            System.out.print("입력값이 잘못됐습니다. 서로 다른 1이상 9이하의 숫자 3개를 적어주세요 > ");
        }
    }

    /**
     * 입력한 숫자가 3자리가 맞는지 검사하는 메서드
     *
     * @return 숫자가 3자리 라면 true를 리턴
     */
    private boolean checkSize() {
        return (input.length() == 3);
    }

    /**
     * 각 자리의 숫자가 1이상 9이하의 숫자가 맞는지 검사하는 메서드
     *
     * @return 1이상 9이하의 숫자가 아니거나 a와 같은 문자가 있다면 false를 반환
     */
    private boolean checkNum() {
        boolean status = true;
        for (int i = 0; i < SIZE; i++) {
            if (input.charAt(i) < START_VAL || input.charAt(i) > END_VAL) {
                status = false;
                break;
            }
        }
        return status;
    }

    /**
     * 입력한 숫자에 중복이 있는지 검사하는 메서드
     *
     * @return 입력한 숫자에 중복된 숫자가 있으면 false를 리턴
     */
    private boolean checkDuplicate() {
        for (int i = 0; i < SIZE - 1; i++) {
            if(!numberEqualCheck(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * i 번째 문자와 중복되는 값이 입력한 숫자에 있는지 확인하는 메서드
     *
     * @param i 비교하려는 값이 몇번째 인지를 나타내는 int 타입 매개변수
     * @return
     */
    private boolean numberEqualCheck(int i) {
        char number = input.charAt(i);
        for (int j = i + 1; j < SIZE; j++) {
            if (number == input.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 입력한 3자리 숫자를 반환해주는 메서드
     *
     * @return 3자리 숫자(문자열)을 반환합니다.
     */
    public String getNumber() {
        return number;
    }

}
