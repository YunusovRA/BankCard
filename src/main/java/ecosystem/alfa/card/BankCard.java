package ecosystem.alfa.card;

public abstract class BankCard {
    protected double balance;
    protected double bonusBalance;

    public BankCard(double balance) {
        this.balance = balance;
        this.bonusBalance = 0;
    }

    public abstract boolean pay(double amount);

    public abstract void deposit(double amount);

    public double getBalance() {
        return balance;
    }

    public double getBonusBalance() {
        return bonusBalance;
    }

    public abstract String getInformation();
}
