public class BusinessCustomer extends Customer {

    public BusinessCustomer(String name){
        this.name = name;
        this.type = "Business";
        this.minDays = 7;
        this.maxDays = 7;
        this.minCars = 3;
        this.maxCars = 3;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public Integer getMinCars() {
        return this.minCars;
    }

    @Override
    public Integer getMaxCars() {
        return this.maxCars;
    }

    @Override
    public Integer getMinDays() {
        return this.minDays;
    }

    @Override
    public Integer getMaxDays() {
        return this.maxDays;
    }
}
