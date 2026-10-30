package product;

public class Cosmetics extends Product implements Giftable {
    private String skinType;
    private boolean isAggressive;

    public Cosmetics(String skinType, boolean isAggressive) {
        this.skinType = skinType;
        this.isAggressive = isAggressive;
    }

    public Cosmetics(String name, String category, double price, int number, double weight,
                  String skinType, boolean isAggressive) {
        super(name, category, price, number, weight);
        this.skinType = skinType;
        this.isAggressive = isAggressive;
    }


    public String getSkinType() { return this.skinType; }
    public boolean getIsAggressive() { return this.isAggressive; }
    public void setSkinType(String skinType) { this.skinType = skinType; }
    public void setIsAggressive(boolean isAggressive) { this.isAggressive = isAggressive; }

    @Override
    public double getGiftWrapPrice() {
        return 80;
    }

    @Override
    public void printGiftInfo() {
        System.out.println("Cosmetics in a beauty box from Golden Apple");
        System.out.println("Gift wrap price: " + getGiftWrapPrice());
        System.out.println("Total with wrap: " + (getPrice() + getGiftWrapPrice()));
    }



    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("skin type: " + this.skinType);
        System.out.println("can harm your skin: " + this.isAggressive);
        System.out.println("delivery costs: " + deliveryCost());
    }

    @Override
    public double deliveryCost() {
        double deliveryPrice = 70 + getWeight() * 25;
        return deliveryPrice;
    }

    @Override
    public double randomDiscount() {
        double percent = Math.random() * 10 + 1;
        return getPrice() - getPrice() * percent / 100;
    }





}
