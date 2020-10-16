/*
 * Main.java     1.0  2020/10/16
 *
 *
 */

import baseballgame.Computer;

public class Main {

    public static void main(String[] args) {
        String numbers;
        Computer
                computer = new Computer();
        numbers = computer.getNumber();
        System.out.println(numbers);
    }
}
