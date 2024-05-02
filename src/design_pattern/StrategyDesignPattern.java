package design_pattern;

public class StrategyDesignPattern {
    /*
     * The Strategy Design Pattern is a behavioral design pattern. It allows you to
     * dynamically change the behavior of an object by encapsulating it into
     * different strategies.
     * 
     * This pattern enables an object to choose from multiple algorithms and
     * behaviors at runtime, rather than statically choosing a single one.
     */

    /*
     * The Strategy Design Pattern has been used extensively in various real-world
     * applications. One such example is the Java Collections Framework. The
     * Collections Framework provides a set of interfaces and classes to represent
     * collections of objects, such as lists, sets, and maps. The framework allows
     * different strategies to be applied to collections based on their behavior.
     * 
     * For instance, the Collections Framework includes a sort() method that allows
     * the sorting of collections. The sort() method takes a Comparator object as an
     * argument, which is responsible for comparing objects within the collection.
     * The Comparator interface defines a strategy for comparing two objects, and
     * the sort() method uses this strategy to sort the collection.
     */
    public static void main(String[] args) {
        PaymentInfo paymentInfo = new PaymentInfo(PaymentType.CREDIT_CARD);
        System.out.println(paymentInfo.getPaymentType());
    }
}

class PaymentInfo {
    private PaymentType paymentType;

    PaymentInfo(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

}

enum PaymentType {
    CASH,
    CREDIT_CARD,
    UPI
}