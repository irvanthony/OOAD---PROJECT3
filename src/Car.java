public abstract class Car {

    protected String licensePlate;
    protected String type;
    protected Integer price;
    protected Boolean isRented;

    public abstract String getLicensePlate();
    public abstract String getType();
    public abstract Integer getPrice();
    public abstract Boolean getIsRented();
    public abstract void setIsRented(Boolean isRented);

    @Override
    public String toString(){
        return "License Plate: " + this.getLicensePlate() + ", Type: " + this.getType() + ", Price: " + this.getPrice() + ", IsRented: " + this.getIsRented();
    }

}
