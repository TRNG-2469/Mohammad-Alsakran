package Week1.Wedensday.OOP.Practice;

public class SavingsAccount extends BankAccount implements Taxable{

    private double interestRate;

    public SavingsAccount() {
    }

    public SavingsAccount(String accountName, String accountNumber, double balance, double interestRate) {
        super(accountName, accountNumber, balance);
        this.interestRate = interestRate;
    }


    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double getTaxAmount() {
        return getBalance() * interestRate;
    }
}
