import java.util.ArrayList;
import java.util.List;

public class CarRentalStore {
    private ArrayList<Car> carInventory;
    private List<CarRental> rentalRecords;
    private List<Customer> customers;

    public CarRentalStore(ArrayList<Car> carInventory, List<Customer> customers){
        this.carInventory = carInventory;
        this.customers = customers;
    }

    public void addRentalRecord(CarRental carRental){
     rentalRecords.add(carRental);
    }

    public Integer numberCarsAvailable(){
        Integer count = 0;
        for (Car i : this.getCarInventory()) {
            if (!i.getIsRented()){
                count ++;
            }
        }
        return count;
    }
    public void addToCarInventory(Car car) { carInventory.add(car); }

    public ArrayList<Car> getCarInventory(){
        return this.carInventory;
    }

    public List<Customer> getCustomers(){
        return this.customers;
    }

    public List<CarRental> getRentalRecords(){
        return this.rentalRecords;
    }
}
