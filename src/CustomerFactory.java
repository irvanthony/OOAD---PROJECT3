public class CustomerFactory {
    public static Customer createCustomer(String name, String type){
        if (type.equalsIgnoreCase("Casual")){
            return new CasualCustomer(name);
        }
        else if (type.equalsIgnoreCase("Regular")){
            return new RegularCustomer(name);
        }
        else if (type.equalsIgnoreCase("Business")) {
            return new BusinessCustomer(name);
        }

        return null;

    }
}
