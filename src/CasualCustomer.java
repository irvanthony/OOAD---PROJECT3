public class CasualCustomer extends Customer {

    public CasualCustomer(String name){
        this.name = name;
        this.type = "Casual";
        this.minDays = 1;
        this.maxDays = 3;
        this.minCars = 1;
        this.maxCars = 1;
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
