package Week1.Wedensday.OOP.Practice;

public class CheckingAccount extends BankAccount{

    private double overdraft;

    public CheckingAccount() {
    }

    public CheckingAccount(double overdraft) {
        this.overdraft = overdraft;
    }

    public CheckingAccount(String accountName, String accountNumber, double balance, double overdraft) {
        super(accountName, accountNumber, balance);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
}
