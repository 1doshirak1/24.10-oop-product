package product;

import java.util.Objects;

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
    public int hashCode(){
        return Objects.hash(this.getName(), this.getPrice(), isAggressive, taste);
    }



    @Override
    public String toString(){
        return this.getName() + " " + this.taste;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        Medicine medicine = (Medicine) object;
        return this.isAggressive == medicine.isAggressive
                && this.taste.equals(medicine.getTaste())
                && this.getName().equals(medicine.getName())
                && Double.compare(this.getPrice(), medicine.getPrice()) == 0;
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
