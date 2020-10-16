/*
 * Computer.java     1.0  2020/10/16
 *
 *
 */

package baseballgame;

import java.util.Random;

/*
 * 컴퓨터가 1에서 9 까지 서로 다른 3개의 난수를 생성하는 클래스
 *
 * @version 1.0 2020/10/16
 * @author https://github.com/Gomding
 */
public class Computer {

    /* 컴퓨터가 생성하는 난수의 최대값 지정 */
    private static final int MAX_NUM = 9;

    /* 3개의 난수를 생성하기 위한 갯수값 */
    private static final int SIZE = 3;

    /* MAX_NUM을 이용해 생성된 정수에 1을 더하기 위한 상수 */
    private static final int ONE = 1;

    /* 생선된 숫자를 담을 문자열 */
    String number = "";

    /**
     *Computer 생성자
     * 1~9 의 난수를 3개 생성하고 number 문자열에 저장함
     */
    public Computer() {
        Random random;
        int temp;
        while (number.length() < SIZE) {
            random = new Random();
            temp = random.nextInt(MAX_NUM) + ONE;

            if(!number.contains(String.valueOf(temp))) {
                number += String.valueOf(temp);
            }
        }
    }

    public String getNumber() {
        return number;
    }
}
