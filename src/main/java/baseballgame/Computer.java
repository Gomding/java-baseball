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
    private String number = "";

    /**
     *Computer 생성자
     * 1~9 의 난수를 3개 생성하고 number 문자열에 저장함
     */
    public Computer() {
        int temp;
        while (number.length() < SIZE) {
            temp = makeRandomNumber();
            addNumber(temp);
        }
    }

    /**
     * 1 ~ 9 사이의 난수를 생성해주는 메서드
     * random.nextInt(MAX_NUM) 으로 0~8 사이의 난수를 선택 후
     * ONE 변수를 이용해 1을 더해줘서 1~9 사이의 난수를 생성
     *
     * @return int 생성한 난수 값을 리턴
     */
    public int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUM) + ONE;
    }

    /**
     * 생성한 숫자를 매개변수로 받아서
     * number 변수에 중복된 값이 있는지 검사 후
     * 중복이 아니라면 더해줌
     *
     * @param temp 생성한 난수
     */
    public void addNumber(int temp) {
        if(!checkDuplicate(temp)) {
            number += String.valueOf(temp);
        }
    }

    /**
     * 생성한 한개의 숫자가 number 변수안에
     * 존재하는지 확인하는 메서드
     *
     * @param temp 생성한 난수
     * @return number 변수 안에 temp(생선한 난수)가 존재한다면 true,
     *                              존재하지 않으면 false 를 반환
     */
    public boolean checkDuplicate(int temp) {
        return number.contains(String.valueOf(temp));
    }

    /**
     * number 변수에 접근하기 위한 메서드
     *
     * @return number 변수를 반환해줌
     */
    public String getNumber() {
        return number;
    }
}
