/*
 * User.java     1.0  2020/10/16
 *
 *
 */
package baseballgame;

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

    public void requestNumber(String input) {
        while(number == null || number.isEmpty()) {
            if (checkSize(input) && checkNum(input) && checkDuplicate(input)) {
                number = input;
            } else {
                System.out.println("입력값이 잘못됐습니다. 1이상 9이하의 숫자 3개를 적어주세요");
            }
        }
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
        String temp;
        for (int i = 1; i < SIZE; i++) {
            temp = String.valueOf(input.indexOf(i));
            if (input.contains(temp)) {
                status = false;
                break;
            }
        }
        return status;
    }

    public String getNumber() {
        return number;
    }

}
