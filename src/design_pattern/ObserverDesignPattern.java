package design_pattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {
    /*
     * The Observer Design Pattern is a behavioral design pattern that defines a
     * one-to-many dependency between objects so that when one object (the subject)
     * changes state, all its dependents (observers) are notified and updated
     * automatically.
     */

     // Notification System to notify for products in stock again.
    public static void main(String[] args) {
        Product product = new Product();
        User1 user1 = new User1();
        User2 user2 = new User2();
        User3 user3 = new User3();
        product.addObserver(user1);
        product.addObserver(user2);
        product.addObserver(user3);
        product.setData(20);
        product.setData(200);
        product.clearData();
        product.setData(10);
    }
}

class User1 implements Observer {
    @Override
    public void update() {
        System.out.println("User1 Notified");
    }
}

class User2 implements Observer {
    @Override
    public void update() {
        System.out.println("User2 Notified");
    }
}

class User3 implements Observer {
    @Override
    public void update() {
        System.out.println("User3 Notified");
    }
}

class Product implements Observable {

    private List<Observer> observers = new ArrayList<>();
    int items = 0;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setData(int noOfItems) {
        if (items == 0) {
            System.out.println("items added");
            items = noOfItems;
            notifyObservers();
        }
    }

    public void clearData() {
        items = 0;
    }

}

interface Observer {
    void update();
}

interface Observable {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}