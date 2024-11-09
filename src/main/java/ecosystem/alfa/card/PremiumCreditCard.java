package ecosystem.alfa.card;

public class PremiumCreditCard extends CreditCard {
    private final double accumulationPercent;

    public PremiumCreditCard(double balance, double creditLimit, double bonusPercent, double accumulationPercent) {
        super(balance, creditLimit, bonusPercent);
        this.accumulationPercent = accumulationPercent;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        super.deposit(amount * accumulationPercent / 100);
    }

    @Override
    public String getInformation() {
        return "Премиум " + super.getInformation();
    }
}
