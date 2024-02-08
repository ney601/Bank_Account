import java.time.LocalDate;

public class BankAccount {

    //Properties
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String accountNumber;
    private double balance;
    private static String accountType;
    private double overdraft;

    // CONSTRUCTOR
    public BankAccount(String firstName, String lastName, LocalDate dateOfBirth, String accountNumber, double balance, String accountType, double overdraft){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.accountType = accountType;
        this.overdraft = overdraft;
    }

    public BankAccount() {

    }

    // GETTERS & SETTERS
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    // Methods
    public double deposit(int amount){
        return balance + amount;
    }

    public Double withdrawal(int amount) {
        if(balance - amount > overdraft) {
            return balance -= amount;
        }
        return null;
    }

    public static Double payInterest(double interest) {
        if(accountType.equalsIgnoreCase("savingsAccount")) {
            return interest = 0.05;
        } if(accountType.equalsIgnoreCase("currentAccount")) {
            return interest = 0.03;
        }
        return null;
    }

}
