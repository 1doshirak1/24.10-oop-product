package product;

public class Toys extends Product implements Returnable, Giftable{
    private int minAge;
    private String material;

    public Toys(int minAge, String material) {
        this.minAge = minAge;
        this.material = material;
    }

    public Toys(String name, String category, double price, int number, double weight,
                     int minAge, String material) {
        super(name, category, price, number, weight);
        this.minAge = minAge;
        this.material = material;
    }

    public int getMinAge() { return this.minAge; }
    public String getMaterial() { return this.material; }
    public void setMinAge(int minAge) { this.minAge = minAge; }
    public void setMaterial(String material) { this.material = material; }


    @Override
    public double getGiftWrapPrice() {
        return 40;
    }

    @Override
    public void printGiftInfo() {
        System.out.println("Toys for kids in a cute box with a beautiful ribbon and rainbows!!");
        System.out.println("Gift wrap price: " + getGiftWrapPrice());
        System.out.println("Total with wrap: " + (getPrice() + getGiftWrapPrice()));
    }




    @Override
    public double deliveryCost() {
        double deliveryPrice = 20 + getWeight() * 10;
        return deliveryPrice;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("is for kids this age or older than: " + this.minAge);
        System.out.println("material: " + this.material);
        System.out.println("delivery costs: " + deliveryCost());
    }


    @Override
    public double randomDiscount() {
        double percent = Math.random() * 100;
        return getPrice() - getPrice() * percent / 100;
    }


    @Override
    public int getReturnPeriodDays() {
        return 21;
    }

    @Override
    public boolean canBeReturned(int daysSincePurchase) {
        return daysSincePurchase <= getReturnPeriodDays();
    }


    public void printReturnStatus(int daysSincePurchase) {
        if (canBeReturned(daysSincePurchase)) {
            System.out.println("Да, возврат возможен!");
        } else {
            System.out.println("Нет, возврат невозможен");
        }
    }


}
