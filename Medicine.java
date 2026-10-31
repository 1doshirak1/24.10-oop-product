package product;

public class Medicine extends Product implements Returnable{
    private boolean isAggressive;
    private String taste;

    public Medicine (boolean isAggressive, String taste) {
        this.isAggressive = isAggressive;
        this.taste = taste;
    }

    public Medicine(String name, String category, double price, int number, double weight,
                    boolean isAggressive, String taste) {
        super(name, category, price, number, weight);
        this.isAggressive = isAggressive;
        this.taste = taste;
    }

    public boolean getAggressive() { return this.isAggressive; }
    public String getTaste() { return this.taste; }
    public void setAggressive(boolean isAggressive) { this.isAggressive = isAggressive; }
    public void setTaste(String taste) { this.taste = taste; }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("can be harmful?: " + this.isAggressive);
        System.out.println("taste: " + this.taste);
        System.out.println("delivery costs: " + deliveryCost());
    }

    @Override
    public double deliveryCost() {
        double deliveryPrice = 150 + getWeight() * 50;
        return deliveryPrice;
    }

    @Override
    public int getReturnPeriodDays() {
        return 7;
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
