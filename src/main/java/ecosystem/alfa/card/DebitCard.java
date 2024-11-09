package ecosystem.alfa.card;

public class DebitCard extends BankCard {
    private final double bonusPercent;

    public DebitCard(double balance, double bonusPercent) {
        super(balance);
        this.bonusPercent = bonusPercent;
    }

    @Override
    public boolean pay(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма оплаты не может быть отрицательной.");
        }
        if (amount <= balance) {
            balance -= amount;
            bonusBalance += amount * bonusPercent / 100;
            return true;
        }
        return false;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма пополнения не может быть отрицательной.");
        } else {
            balance += amount;
        }
    }

    @Override
    public String getInformation() {
        return "Дебетовая карта: Баланс - " + balance + ", Бонусный баланс - " + bonusBalance;
    }
}
