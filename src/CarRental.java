import java.util.List;

public class CarRental extends CarRentalAbstract{

    public CarRental(Customer customer, List<Car> carsRented, Integer length, Integer childCarSeats, Integer gps, Integer satRadio, Integer returnDate){
        this.customer = customer;
        this.type = customer.getType();
        this.carsRented = carsRented;
        this.length = length;
        this.cost = 0;
        this.isActive = true;
        this.childCarSeats = childCarSeats;
        this.gps = gps;
        this.satRadio = satRadio;
        this.returnDate = returnDate;

        for (Car i: this.carsRented
             ) {
            i.setIsRented(true);
            this.cost += i.getPrice() * length;
        }
    }

    public String getType(){
        return this.type;
    }

    public Integer getCost(){
        return this.cost;
    }

    public List<Car> getCarsRented(){
        return this.carsRented;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public Boolean getIsActive(){
        return this.isActive;
    }

    public void setIsActive(Boolean isActive){
        this.isActive = isActive;
    }

    public Integer getLength(){
        return this.length;
    }

    public Integer getReturnDate() { return this.returnDate; }

    @Override
    public Integer getChildCarSeats() {
        return this.childCarSeats;
    }

    @Override
    public Integer getGps() {
        return this.gps;
    }

    @Override
    public Integer getSatRadio() {
        return this.satRadio;
    }

}
