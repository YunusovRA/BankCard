package ecosystem.alfa.card;

public class CreditCard extends BankCard {
    private final double creditLimit;
    private double creditBalance;
    private final double bonusPercent;

    public CreditCard(double balance, double creditLimit, double bonusPercent) {
        super(balance);
        this.creditLimit = creditLimit;
        this.creditBalance = creditLimit;
        this.bonusPercent = bonusPercent;
    }

    @Override
    public boolean pay(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма оплаты не может быть отрицательной.");
        }
        if (amount <= balance + creditBalance) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                double temp = amount - balance;
                balance = 0;
                creditBalance -= temp;
            }
            bonusBalance += amount * bonusPercent / 100;
            return true;
        }
        return false;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма пополнения не может быть отрицательной.");
        }
        if (creditBalance < creditLimit) {
            if (amount <= creditLimit - creditBalance) {
                creditBalance += amount;
            } else {
                double temp = amount - (creditLimit - creditBalance);
                creditBalance = creditLimit;
                balance += temp;
            }
        } else {
            balance += amount;
        }
    }

    @Override
    public String getInformation() {
        return "Кредитная карта: Баланс - " + balance + ", Кредитный баланс - " + creditBalance + ", Бонусный баланс - " + bonusBalance;
    }
}