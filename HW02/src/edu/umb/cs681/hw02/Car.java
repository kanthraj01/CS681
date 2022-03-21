package edu.umb.cs681.hw02;

import java.util.ArrayList;

public class Car {

	private String make, model;
    private int mileage, year,dominationCount;
    private float price;
  

    public Car(String make, String model, int year, int mileage, float price, int dominationCount) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.dominationCount = dominationCount;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }



    public int getDominationCount() {
        return dominationCount;
    }
    
    
    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();

        Car car1 = new Car("BMW","X5", 2020, 10, 39500,3);
        Car car2 = new Car("BMW", "320d", 2019, 11, 69500,5);
        Car car3 = new Car("Honda", "Acccord", 2021, 20, 85000,1);
        Car car4 = new Car("Toyota","Camry", 2018, 18, 40000,2);
        Car car5 = new Car("Tesla", "Model Y",2022, 22, 22040,4);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        double minimum = cars.stream().mapToDouble(Car::getPrice).min().getAsDouble();
        System.out.println("Minimum price of the car is: " + minimum);

        double maximum= cars.stream().mapToDouble(Car::getPrice).max().getAsDouble();
        System.out.println("Maximum price of the car is : " + maximum);


        Integer averagePrice = cars.stream().map(car-> car.getPrice()).reduce(new int[2], (result, price) ->{
            double average = Math.round((result[0] * result[1] + price)/(result[0]+1));
            result[0]++;
            result[1] = (int) average;
            return result;},(Result, initial) -> Result)[1];

        System.out.println("Average price of cars: " + averagePrice);
        
    }
}
