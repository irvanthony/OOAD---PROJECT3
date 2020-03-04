public class LuxuryCar extends Car{

    public LuxuryCar(String licensePlate){
        this.licensePlate = licensePlate;
        this.type = "Luxury";
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
