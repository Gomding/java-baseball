import baseballgame.Computer;

public class Main {

    public static void main(String[] args) {
        String numbers;
        Computer computer = new Computer();
        numbers = computer.getNumber();
        System.out.println(numbers);
    }
}
