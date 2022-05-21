package edu.umb.cs681.hw16;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String make, model;
    private int mileage, year;
    private int price;
    private int dominationCount;

    public Car(String make, String model, int year, int mileage, int price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public int getDominationCount() {
        return dominationCount;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
    public int getPrice() {
        return price;
    }
    public int getMileage() {
        return mileage;
    }

    public void setDominationCount(ArrayList<Car> cars) {
        for (Car car : cars) {
            if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
                    && (car.getYear() <= this.getYear())) {
                this.dominationCount++;
            }
        }
        this.dominationCount--;
    }

    public boolean equals(Object obj) {
        Car car = (Car) obj;
        if(make.equals(car.getMake()) && model.equals(car.getModel()) && year==car.getYear() && mileage==car.getMileage() && price==car.getPrice() && dominationCount==car.getDominationCount())
            return true;
        return false;
    }

    public String toString() {
        return this.make+" "+this.model+" "+this.year+"; Mileage:"+this.mileage+" - $"+this.price;
    }

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("BMW","X5", 2020, 10, 39500));
        carList.add(new Car("Honda", "Acccord", 2021, 20, 8500));
        carList.add(new Car("Toyota","Camry", 2018, 18, 40000));
        carList.add(new Car("Tesla", "Model Y",2022, 22, 22040));

        int carMakerNum = carList.stream()
                .parallel()
                .map( (Car car)-> car.getMake() )
                .reduce(0,
                        (result,carMaker)-> ++result,
                        (finalResult,intermediateResult)-> finalResult + intermediateResult);
        System.out.println("\nTotal number of car makers: "+carMakerNum+'\n');

        int carModelNum = carList.stream()
                .parallel()
                .map( (Car car)-> car.getModel() )
                .reduce(0,
                        (result,carModel)-> ++result,
                        (finalResult,intermediateResult)-> finalResult + intermediateResult);
        System.out.println("Total number of car models: "+carModelNum);

    }
}