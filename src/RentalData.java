import java.util.ArrayList;
import java.util.List;

public class RentalData implements Subject {
    private ArrayList<Observer> observers;
    private ArrayList<CarRental> completedRentals;
    private ArrayList<CarRental> activeRentals;
    private ArrayList<Car> carInventory;
    private Integer moneyMade;
    private Integer day;

    public RentalData(){
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        Integer i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers(){
        for (Observer observer : observers){
            observer.update(completedRentals, activeRentals, carInventory, moneyMade, day);
        }
    }

    public void recordChanged() {
        notifyObservers();
    }

    public void setRentalData(ArrayList<CarRental> completedRentals, ArrayList<CarRental> activeRentals, ArrayList<Car> carInventory, Integer moneyMade, Integer day){
        this.completedRentals = completedRentals;
        this.activeRentals = activeRentals;
        this.carInventory = carInventory;
        this.moneyMade = moneyMade;
        this.day = day;

        recordChanged();
    }

}
