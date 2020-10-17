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

    public String requestNumber() throws Exception{
        while(number == null || number.isEmpty()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            if (checkSize(input) && checkNum(input) && checkDuplicate(input)) {
                number = input;
            } else {
                System.out.print("입력값이 잘못됐습니다. 서로 다른 1이상 9이하의 숫자 3개를 적어주세요 > ");
            }
        }
        return number;
    }

    private boolean checkSize(String input) {
        return (input.length() == 3);
    }

    private boolean checkNum(String input) {
        boolean status = true;
        for (int i = 0; i < SIZE; i++) {
            if (input.charAt(i) < START_VAL || input.charAt(i) > END_VAL) {
                status = false;
                break;
            }
        }
        return status;
    }

    private boolean checkDuplicate(String input) {
        boolean status = true;
        char temp;
        for (int i = 1; i < SIZE; i++) {
            temp = input.charAt(i);
            for (int j = i + 1; j < 3; j++) {
                if (temp == input.charAt(j)) {
                    status = false;
                }
            }
        }
        return status;
    }

    public String getNumber() {
        return number;
    }

}
