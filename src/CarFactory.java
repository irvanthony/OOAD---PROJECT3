public class CarFactory {
    public static Car createCar(String licensePlate, String type){
        if (type.equalsIgnoreCase("Economy")){
            return new EconomyCar(licensePlate);
        }
        else if (type.equalsIgnoreCase("Standard")){
            return new StandardCar(licensePlate);
        }
        else if (type.equalsIgnoreCase("Luxury")){
            return new LuxuryCar(licensePlate);
        }
        else if (type.equalsIgnoreCase("SUV")){
            return new SUVCar(licensePlate);
        }
        else if (type.equalsIgnoreCase("Minivan")){
            return new MinivanCar(licensePlate);
        }

        return null;

    }
}
