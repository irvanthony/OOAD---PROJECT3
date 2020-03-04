public class ChildCarSeat extends AddOnDecorator{

    CarRental rentalHolder;

    public ChildCarSeat(CarRental rentalHolder){
        this.rentalHolder = rentalHolder;
    }


    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getType() {
        return rentalHolder.getType();
    }

    @Override
    public Integer getCost() {
        return rentalHolder.getCost() + 10;
    }

    @Override
    public Customer getCustomer() {
        return rentalHolder.getCustomer();
    }

    @Override
    public Car getCar() {
        return rentalHolder.getCar();
    }

    @Override
    public Boolean getIsActive() {
        return rentalHolder.getIsActive();
    }

    @Override
    public void setIsActive(Boolean isActive) {
        rentalHolder.setIsActive(isActive);
    }

    @Override
    public Integer getLength() {
        return rentalHolder.getLength();
    }
}
