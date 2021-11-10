package com.kakao.racingcar.domain.car;

import com.kakao.racingcar.history.CarHistory;

public class Car {
    private final String userName;
    private int position = 0;
    private final MovableStrategy movableStrategy;

    public Car(String userName, MovableStrategy movableStrategy) {
        this.userName = userName;
        this.movableStrategy = movableStrategy;
    }

    public CarHistory tryMove(int conditionNumber) {
        if (movableStrategy.move(conditionNumber)) {
            position++;
        }
        return new CarHistory(position, userName);
    }

}