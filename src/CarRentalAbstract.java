import java.util.List;

public abstract class CarRentalAbstract {
    protected String type;
    protected Integer cost;
    protected Customer customer;
    protected List<Car> carsRented;
    protected Boolean isActive;
    protected Integer length;
    protected Integer childCarSeats;
    protected Integer gps;
    protected Integer satRadio;
    protected Integer returnDate;

    public abstract String getType();
    public abstract Integer getCost();
    public abstract Customer getCustomer();
    public abstract List<Car> getCarsRented();
    public abstract Boolean getIsActive();
    public abstract void setIsActive(Boolean isActive);
    public abstract Integer getLength();
    public abstract Integer getChildCarSeats();
    public abstract Integer getGps();
    public abstract Integer getSatRadio();
    public abstract Integer getReturnDate();
}
