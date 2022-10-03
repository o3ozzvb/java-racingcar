package racingCar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String carNames) {
        this.cars = new ArrayList<>();
        String[] sCars = carNames.split(",");
        for (String sCar : sCars) {
            cars.add(new Car(sCar));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void playGame() {
        for (Car car : this.cars) {
            car.play(new Random());
        }
    }

    public List<String> getWinners() {
        final Car maxPositionCar = findMaxPositionCar();

        return findSamePositionCars(maxPositionCar);
    }

    private List<String> findSamePositionCars(Car maxPositionCar) {
        return cars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량이 없습니다."));
    }

    private int getMaxPos() {

        return cars
                .stream()
                .mapToInt(car -> car.getPos())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

}
