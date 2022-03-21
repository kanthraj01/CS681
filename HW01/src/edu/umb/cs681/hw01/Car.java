package edu.umb.cs681.hw01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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


        List<Car> sortByPrice = cars.stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());

        System.out.println("\n        Sorted by Price \n");
        sortByPrice.forEach((Car car) -> System.out.println( car.getMake() + ", "+car.getModel() + ": " + car.getPrice()));
        System.out.println("-----------------------------");
        
        List<Car> sortByYear = cars.stream().sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());
        System.out.println("\n           Sorted by Year \n");
        sortByYear.forEach((Car car) -> System.out.printf("%4s, %s :%6d \n", car.getMake(),car.getModel(), car.getYear()));
        System.out.println("-----------------------------");
        
        List<Car> sortByDomination = cars.stream().sorted(Comparator.comparing(Car::getDominationCount)).collect(Collectors.toList());
        System.out.println("\n           Sorted by Domination \n");
        sortByDomination.forEach((Car car) -> System.out.println(car.getMake() + ", "+car.getModel() + ": "+ car.getDominationCount()));
        System.out.println("-----------------------------");
        
        List<Car> sortByMileage = cars.stream().sorted(Comparator.comparing(Car::getMileage)).collect(Collectors.toList());
        System.out.println("\n           Sorted by Mileage \n");
        sortByMileage.forEach((Car car) -> System.out.println(car.getMake() + ", "+car.getModel() + ": " + car.getMileage()));

    }
}
