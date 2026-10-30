package product;

public interface Returnable {
    boolean canBeReturned(int daysSincePurchase);
    int getReturnPeriodDays();
}
