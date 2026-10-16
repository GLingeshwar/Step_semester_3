class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: Amount must be positive");
        } else {
            savings += amount;
            System.out.println("Savings = " + savings);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be positive");
        } else if (amount > savings) {
            System.out.println("Withdrawal rejected: Insufficient savings");
        } else {
            savings -= amount;
            System.out.println("Savings = " + savings);
        }
    }

    public double getSavings() {
        return savings;
    }
}

public class Main {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Final savings: " + pb.getSavings());
    }
}
