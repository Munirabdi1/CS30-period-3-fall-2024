/*

Program: Vehicle Information         Last Date of this Revision: December 18, 2024

Purpose: This program demonstrates the use of inheritance with an abstract class `Vehicle` and its subclasses 
`Car`, `Truck`, and `Minivan`. It provides a way to represent different types of vehicles and display their information.

Author: 

School: CHHS

Course: Computer Programming 30

*/
 
// Abstract Vehicle class
abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public abstract String getInfo();
}

// Car class inheriting from Vehicle
class Car extends Vehicle {
    private int numDoors;

    public Car(String make, String model, int year, int numDoors) {
        super(make, model, year);
        this.numDoors = numDoors;
    }

    @Override
    public String getInfo() {
        return "Car: " + year + " " + make + " " + model + ", Doors: " + numDoors;
    }
}

// Truck class inheriting from Vehicle
class Truck extends Vehicle {
    private int payloadCapacity;

    public Truck(String make, String model, int year, int payloadCapacity) {
        super(make, model, year);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public String getInfo() {
        return "Truck: " + year + " " + make + " " + model + ", Payload: " + payloadCapacity + "kg";
    }
}

// Minivan class inheriting from Vehicle
class Minivan extends Vehicle {
    private int seatingCapacity;

    public Minivan(String make, String model, int year, int seatingCapacity) {
        super(make, model, year);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String getInfo() {
        return "Minivan: " + year + " " + make + " " + model + ", Seating: " + seatingCapacity + " people";
    }
}

// Main class
public class VehicleCarTruckMinivan {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2020, 4);
        Truck truck = new Truck("Ford", "F-150", 2021, 1000);
        Minivan minivan = new Minivan("Honda", "Odyssey", 2022, 7);

        System.out.println(car.getInfo());
        System.out.println(truck.getInfo());
        System.out.println(minivan.getInfo());
    }
}

