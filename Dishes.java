package product;

public class Dishes extends Product implements Returnable {
    private String color;
    private String dishesPainting;

    public Dishes(String color, String dishesPainting) {
        this.color = color;
        this.dishesPainting = dishesPainting;
    }

    public Dishes(String name, String category, double price, int number, double weight,
                 String color, String dishesPainting) {
        super(name, category, price, number, weight);
        this.color = color;
        this.dishesPainting = dishesPainting;
    }

    public String getColor() { return this.color; }
    public String getDishesPainting() { return this.dishesPainting; }
    public void setColor(String color) { this.color = color; }
    public void setDishesPainting(String dishesPainting) { this.dishesPainting = dishesPainting; }

    //переделка методов класса-родителя


    @Override
    public double deliveryCost() {
        double deliveryPrice = 100 + getWeight() * 50;
        return deliveryPrice;
    }


    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("color: " + this.color);
        System.out.println("painting: " + this.dishesPainting);
        System.out.println("delivery costs: " + deliveryCost());
    }

    // скидку до 20%
    @Override
    public double randomDiscount() {
        double percent = Math.random() * 16 + 5;
        return getPrice() - getPrice() * percent / 100;
    }

    // когда можем вернуть
    @Override
    public int getReturnPeriodDays() {
        return 14;
    }
    // можем ли вернуть
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