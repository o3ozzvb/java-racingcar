package step3;

import java.util.Scanner;

public class ResultView {

    private static final String S_GAME_RESULT = "실행 결과";

    public void print_GameResult() {
        System.out.println(S_GAME_RESULT);
    }
    
    public void print_PlayResult(Cars cars) {
        for (Car car : cars.cars) {
            print_carPosition(car);
        }
    }

    public void print_carPosition(Car car) {
        for (int i=0; i<car.pos; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}