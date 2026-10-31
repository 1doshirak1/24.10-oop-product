package product;

public class Main {
    public static void main(String[] args) {
        Product[] products = { new Cosmetics("fat", true ), new Medicine(true , "salty"), new Toys(3, "cotton"), new Dishes("blue","gjel")};
        for ( Product c: products) {
            c.printInfo();
        }

    }
}