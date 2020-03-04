public abstract class Customer {
    protected String name;
    protected String type;
    protected Integer minCars;
    protected Integer maxCars;
    protected Integer minDays;
    protected Integer maxDays;

    public abstract String getName();
    public abstract String getType();
    public abstract Integer getMinCars();
    public abstract Integer getMaxCars();
    public abstract Integer getMinDays();
    public abstract Integer getMaxDays();

    @Override
    public String toString(){
        return "Name: " + this.getName() + ", Type: " + this.getType();
    }
}
