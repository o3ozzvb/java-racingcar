package RacingCar;

import java.util.Scanner;

public class InputView {
    public int getNumberOfCars() {
        final String QUESTION_FOR_GET_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
        System.out.println(QUESTION_FOR_GET_NUMBER_OF_CARS);
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = scanner.nextInt();
        return numberOfCars;
    }

    public int getNumberOfRacing() {
        final String QUESTION_FOR_GET_NUMBER_OF_RACING = "시도할 회수는 몇 회 인가요?";
        System.out.println(QUESTION_FOR_GET_NUMBER_OF_RACING);
        Scanner scanner = new Scanner(System.in);
        int numberOfRacing = scanner.nextInt();
        return numberOfRacing;
    }
}