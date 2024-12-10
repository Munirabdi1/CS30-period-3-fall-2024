package chapter11;

import java.io.Serializable;

public class PiggyBank implements Serializable {
    private static final long serialVersionUID = 1L;
    private double total;

    public void addPenny() {
        total += 0.01;
    }

    public void addNickel() {
        total += 0.05;
    }

    public void addDime() {
        total += 0.10;
    }

    public void addQuarter() {
        total += 0.25;
    }

    public boolean takeMoney(double amount) {
        if (amount <= total) {
            total -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getTotal() {
        return Math.round(total * 100.0) / 100.0;
    }
}
//