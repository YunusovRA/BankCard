package ecosystem.alfa.card;

public class PremiumDebitCard extends DebitCard {
    private final double cashbackPercent;
    private final double cashbackLimit;

    public PremiumDebitCard(double balance, double bonusPercent, double cashbackPercent, double cashbackLimit) {
        super(balance, bonusPercent);
        this.cashbackPercent = cashbackPercent;
        this.cashbackLimit = cashbackLimit;
    }

    @Override
    public boolean pay(double amount) {
        if (super.pay(amount)) {
            if (amount >= cashbackLimit) {
                super.deposit(amount * cashbackPercent / 100);
            }
            return true;
        }
        return false;
    }

    @Override
    public String getInformation() {
        return "Премиум " + super.getInformation();
    }
}
