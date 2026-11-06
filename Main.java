package product;

public class Main {
    public static void main(String[] args) {
        Product[] products = { new Cosmetics("fat", true ), new Medicine(true , "salty"), new Toys(3, "cotton"), new Dishes("blue","gjel")};
        for ( Product c: products) {
            c.printInfo();
        }
        Medicine med1 = new Medicine(true, "Salty");
        med1.setName("Antibiotic");
        med1.setPrice(120);
        Medicine med3 = new Medicine(true, "Salty");
        med3.setName("Antibiotic");
        med3.setPrice(120);
        System.out.println(med1.toString());
        System.out.println(med3.toString());
        System.out.println(med1.equals(med3));
        System.out.println(med1.hashCode());
        Dishes dish = new Dishes("Красный", "Gjel");
    }
}