import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recordDisplay implements Observer, DisplayElement {
    private List<CarRental> completedRentals;
    private List<CarRental> activeRentals;
    private List<Car> carInventory;
    private Integer moneyMade;
    private Integer day;
    private Subject rentalData;

    public recordDisplay(Subject rentalData){
        this.rentalData = rentalData;
        rentalData.registerObserver(this);
    }

    public void update(ArrayList<CarRental> completedRentals, ArrayList<CarRental> activeRentals, ArrayList<Car> carInventory, Integer moneyMade, Integer day) throws FileNotFoundException {
        this.completedRentals = completedRentals;
        this.activeRentals = activeRentals;
        this.carInventory = carInventory;
        this.moneyMade = moneyMade;
        this.day = day;

        display();
    }

    public void display() {
        PrintStream o = new PrintStream(new File("out.txt"));
        PrintStream console = System.out;
        System.setOut(o);
        System.out.println("Current day: " + day + "\r\n");

        System.out.println("# of completed rentals: " + completedRentals.size() + "\r\n");
        for (CarRental completed : completedRentals){
            System.out.println(completed.getCustomer() + " returned ");
            for (Car car : completed.getCarsRented()){
                System.out.println(car.getLicensePlate() + ", ");
            }
            System.out.println("with gps: " + completed.getGps() + " child seats: " + completed.getChildCarSeats() + " satellite radio: " + completed.getSatRadio() + " for " + completed.getLength() + " days. \r\n");
            System.out.println("Total rental fee: " + completed.getCost());
        }

        System.out.println("# of active rentals: " + activeRentals.size() + "\r\n");
        for (CarRental active : activeRentals){
            System.out.println(active.getCustomer() + " rented ");
            for (Car car : active.getCarsRented()){
                System.out.println(car.getLicensePlate() + ", ");
            }
        }
        System.out.println("\r\n");

        System.out.println(carInventory.size() + " cars left in store: ");
        for (Car car : carInventory) {
            System.out.println(car.getLicensePlate() + ", ");
        }
        System.out.println("\r\n");

        System.out.println("The store made $" + moneyMade + " today. \r\n" );
    }
}
