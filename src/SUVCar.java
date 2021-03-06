public class SUVCar extends Car {

    public SUVCar(String licensePlate){
        this.licensePlate = licensePlate;
        this.type = "SUV";
        this.price = 40;
        this.isRented = false;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public Boolean getIsRented() {
        return this.isRented;
    }

    @Override
    public void setIsRented(Boolean isRented) {
        this.isRented = isRented;
    }
}
