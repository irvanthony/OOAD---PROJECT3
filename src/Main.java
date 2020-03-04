import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

import static java.util.Collections.emptyList;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {

        PrintStream o = new PrintStream(new File("out.txt"));
        PrintStream console = System.out;
        System.setOut(o);

        ArrayList<Car> carInventory = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        Car econ1 = CarFactory.createCar("ECO111", "Economy");
        Car econ2 = CarFactory.createCar("ECO222", "Economy");
        Car econ3 = CarFactory.createCar("ECO333", "Economy");
        Car econ4 = CarFactory.createCar("ECO444", "Economy");
        carInventory.add(econ1);
        carInventory.add(econ2);
        carInventory.add(econ3);
        carInventory.add(econ4);

        Car stan1 = CarFactory.createCar("STD111", "Standard");
        Car stan2 = CarFactory.createCar("STD222", "Standard");
        Car stan3 = CarFactory.createCar("STD333", "Standard");
        Car stan4 = CarFactory.createCar("STD444", "Standard");
        Car stan5 = CarFactory.createCar("STD555", "Standard");
        carInventory.add(stan1);
        carInventory.add(stan2);
        carInventory.add(stan3);
        carInventory.add(stan4);
        carInventory.add(stan5);

        Car lux1 = CarFactory.createCar("LUX111", "Luxury");
        Car lux2 = CarFactory.createCar("LUX222", "Luxury");
        Car lux3 = CarFactory.createCar("LUX333", "Luxury");
        Car lux4 = CarFactory.createCar("LUX444", "Luxury");
        Car lux5 = CarFactory.createCar("LUX555", "Luxury");
        carInventory.add(lux1);
        carInventory.add(lux2);
        carInventory.add(lux3);
        carInventory.add(lux4);
        carInventory.add(lux5);

        Car suv1 = CarFactory.createCar("SUV111", "SUV");
        Car suv2 = CarFactory.createCar("SUV222", "SUV");
        Car suv3 = CarFactory.createCar("SUV333", "SUV");
        Car suv4 = CarFactory.createCar("SUV444", "SUV");
        Car suv5 = CarFactory.createCar("SUV555", "SUV");
        carInventory.add(suv1);
        carInventory.add(suv2);
        carInventory.add(suv3);
        carInventory.add(suv4);
        carInventory.add(suv5);

        Car mini1 = CarFactory.createCar("VAN111", "Minivan");
        Car mini2 = CarFactory.createCar("VAN222", "Minivan");
        Car mini3 = CarFactory.createCar("VAN333", "Minivan");
        Car mini4 = CarFactory.createCar("VAN444", "Minivan");
        Car mini5 = CarFactory.createCar("VAN555", "Minivan");
        carInventory.add(mini1);
        carInventory.add(mini2);
        carInventory.add(mini3);
        carInventory.add(mini4);
        carInventory.add(mini5);

        Customer adam = CustomerFactory.createCustomer("Adam", "Casual");
        Customer jess = CustomerFactory.createCustomer("Jess", "Casual");
        Customer alex = CustomerFactory.createCustomer("Alex", "Casual");
        Customer john = CustomerFactory.createCustomer("John", "Casual");
        customers.add(adam);
        customers.add(jess);
        customers.add(alex);
        customers.add(john);

        Customer laura = CustomerFactory.createCustomer("Laura", "Regular");
        Customer megan = CustomerFactory.createCustomer("Megan", "Regular");
        Customer ben = CustomerFactory.createCustomer("Ben", "Regular");
        Customer rob = CustomerFactory.createCustomer("Rob", "Regular");
        customers.add(laura);
        customers.add(megan);
        customers.add(ben);
        customers.add(rob);

        Customer steve = CustomerFactory.createCustomer("Steve", "Business");
        Customer lexi = CustomerFactory.createCustomer("Lexi", "Business");
        Customer rose = CustomerFactory.createCustomer("Rose", "Business");
        Customer camille = CustomerFactory.createCustomer("Camille", "Business");
        customers.add(steve);
        customers.add(lexi);
        customers.add(rose);
        customers.add(camille);

        Collections.shuffle(carInventory);
        Random rand = new Random();

        ArrayList<CarRental> activeRentals = new ArrayList<>();
        ArrayList<CarRental> completedRentals = new ArrayList<>();

        RentalData rentalData = new RentalData();
        rentalData.setRentalData(activeRentals, completedRentals, carInventory, 0, 0);
        recordDisplay recDisp = new recordDisplay(rentalData);
        Integer totalRentals = 0;
        Integer totalCasualRentals = 0;
        Integer totalBusinessRentals = 0;
        Integer totalRegularRentals = 0;
        Integer totalMoneyMade = 0;

        for (int day = 1; day < 36; day++) {
            Integer carsAvailable = carInventory.size();
            Integer numCustomers = rand.nextInt(13);
            ArrayList<Integer> customerSelection = new ArrayList<>();
            Integer moneyMadeToday = 0;
            while (customerSelection.size() < numCustomers) {
                int random = rand.nextInt(numCustomers);
                if (!customerSelection.contains(random)) {
                    customerSelection.add(random);
                }
            }
            for (int i : customerSelection) {
                if (carsAvailable >= 3) {
                    Iterator<CarRental> itr = activeRentals.iterator();
                    while (itr.hasNext()){
                        CarRental complete = itr.next();
                        if (complete.getReturnDate() == day){
                            completedRentals.add(complete);
                            for (Car expire : complete.getCarsRented()){
                                expire.setIsRented(false); // set returned cars' isRented to false
                                carInventory.add(expire);
                            }
                            itr.remove();
                        }
                    }
                    Customer customerHolder = customers.get(i);
                    Integer childSeats = rand.nextInt(5);
                    Integer gps = rand.nextInt(2);
                    Integer satRadio = rand.nextInt(2);
                    Integer numCars;
                    if (customerHolder.getType().equalsIgnoreCase("Casual")) {
                        numCars = 1;
                        totalCasualRentals = totalCasualRentals + 1;
                    } else if (customerHolder.getType().equalsIgnoreCase("Business")) {
                        numCars = 3;
                        totalBusinessRentals = totalBusinessRentals + 1;
                    } else {
                        numCars = rand.nextInt((customerHolder.getMaxCars() - customerHolder.getMinCars()) + 1) + customerHolder.getMinCars();
                        totalRegularRentals = totalRegularRentals + 1;
                    }
                    ArrayList<Car> carsHolder = new ArrayList<>();
                    //int k = 0;
                    //Random carSelect = new Random();
                    while (carsHolder.size() < numCars && !carInventory.isEmpty()) {
                        carInventory.get(0).setIsRented(true);
                        carsHolder.add(carInventory.remove(0));
                    }
                    Integer days = rand.nextInt(customerHolder.getMaxDays() - customerHolder.getMinDays() + 1) + customerHolder.getMinDays();
                    CarRental temp = new CarRental(customerHolder, carsHolder, days, childSeats, gps, satRadio, day + days);
                    activeRentals.add(temp);
                    moneyMadeToday = moneyMadeToday + temp.getCost();

                } else if (carsAvailable > 0 && carsAvailable < 3) {

                    Iterator<CarRental> itr = activeRentals.iterator();

                    while (itr.hasNext()) {
                        CarRental complete = itr.next();
                        if (complete.getReturnDate() == day) {
                            completedRentals.add(complete);
                            for (Car expire : complete.getCarsRented()) {
                                expire.setIsRented(false); // set returned cars' isRented to false
                                carInventory.add(expire);
                            }
                            itr.remove();
                        }
                    }

                    Customer customerHolder = customers.get(i);
                    Integer childSeats = rand.nextInt(5);
                    Integer gps = rand.nextInt(2);
                    Integer satRadio = rand.nextInt(2);
                    Integer numCars;

                    if (customerHolder.getType().equalsIgnoreCase("Casual")) {
                        numCars = 1;
                        totalCasualRentals = totalCasualRentals + 1;
                    } else if (customerHolder.getType().equalsIgnoreCase("Business")) {
                        continue;
                    } else {
                        numCars = rand.nextInt((carsAvailable - customerHolder.getMinCars()) + 1) + customerHolder.getMinCars();
                        totalRegularRentals = totalRegularRentals + 1;
                    }

                    ArrayList<Car> carsHolder = new ArrayList<>();

                    while (carsHolder.size() < numCars && !carInventory.isEmpty()) {
                        carInventory.get(0).setIsRented(true);
                        carsHolder.add(carInventory.remove(0));
                    }

                    Integer days = rand.nextInt(customerHolder.getMaxDays() - customerHolder.getMinDays() + 1) + customerHolder.getMinDays();
                    CarRental temp = new CarRental(customerHolder, carsHolder, days, childSeats, gps, satRadio, day + days);
                    activeRentals.add(temp);
                    moneyMadeToday = moneyMadeToday + temp.getCost();

                } else {
                    break;
                }
            }

            rentalData.setRentalData(completedRentals, activeRentals, carInventory, moneyMadeToday, day);
            completedRentals.clear();
            totalMoneyMade = totalMoneyMade + moneyMadeToday;
        }

        System.out.println("Total Casual Rentals: " + totalCasualRentals);
        System.out.println("Total Regular Rentals: " + totalRegularRentals);
        System.out.println("Total Business Rentals: " + totalBusinessRentals);
        System.out.println("Total Money Made: " + totalMoneyMade);

    }
}
