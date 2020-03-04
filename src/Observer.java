import java.util.ArrayList;

public interface Observer {
    public void update(ArrayList<CarRental> completedRentals, ArrayList<CarRental> activeRentals, ArrayList<Car> carInventory, Integer moneyMade, Integer day);
}
