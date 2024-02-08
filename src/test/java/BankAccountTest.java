import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
            bankAccount = new BankAccount("Yesica", "Nithiyanantha", LocalDate.of(2001, 6, 7), "663567882", 0, "current");
    }

    @Test
    public void getFirstName(){
        String expected = "Yesica";
        String actual = bankAccount.getFirstName();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void setFirstName(){
        String expected = "Natali";
        bankAccount.setFirstName("Natali");
        String actual = bankAccount.getFirstName();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getLastName(){
        String expected = "Nithiyanantha";
        String actual = bankAccount.getLastName();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void setLastName(){
        String expected = "Graham";
        bankAccount.setLastName("Graham");
        String actual = bankAccount.getLastName();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getDateOfBirth() {
        LocalDate expected = LocalDate.of(2001, 6, 7);
        LocalDate actual = bankAccount.getDateOfBirth();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void setDateOfBirth() {
        LocalDate expected = LocalDate.of(1985, 3, 20);
        bankAccount.setDateOfBirth(expected);
        LocalDate actual = bankAccount.getDateOfBirth();
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void getAccountNumber() {
        String expected = "663567882";
        String actual = bankAccount.getAccountNumber();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void setAccountNumber() {
        String expected = "793521839";
        bankAccount.setAccountNumber("793521839");
        String actual = bankAccount.getAccountNumber();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getBalance() {
        double expected = 0.0;
        double actual = bankAccount.getBalance();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getAccountType() {
        String expected = "current";
        String actual = bankAccount.getAccountType();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSetAccountType() {
        String expected = "savings";
        bankAccount.setAccountType("savings");
        String actual = bankAccount.getAccountType();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getOverdraft() {
        double expected = 0;
        double actual = bankAccount.getOverdraft();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void setOverdraft() {
        double expected = 200.0;
        bankAccount.setOverdraft((int) expected);
        double actual = bankAccount.getOverdraft();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void deposit() {
        double startBalance = bankAccount.getBalance();
        int depositAmount = 200;
        double finalBalance = startBalance + depositAmount;
        double actual = bankAccount.deposit((int) depositAmount);
        assertThat(actual).isEqualTo(finalBalance);

    }

    @Test
    public void withdrawal() {
        double startBalance = bankAccount.getBalance();
        int withdrawalAmount = -100;
        double finalBalance = startBalance + withdrawalAmount;
        double actual = bankAccount.deposit((int) withdrawalAmount);
        assertThat(actual).isEqualTo(finalBalance);
    }

    @Test
    public void WithdrawalWithOverdraft() {
        double initialBalance = bankAccount.getBalance();
        double withdrawalAmount = 100;
        double actual = bankAccount.withdrawal((int) withdrawalAmount);
        assertThat(actual).isEqualTo(initialBalance);
    }

    @Test
    public void payInterestForCurrentAccount() {
        bankAccount.setAccountType("current");
        double actual = bankAccount.getBalance();
        double expected = actual * (1 + 0.03);
        bankAccount.payInterest(0.03);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void payInterestForSavingsAccountTypes() {
        bankAccount.setAccountType("savings");
        double actual = bankAccount.getBalance();
        double expected = actual * (1 + 0.05);
        bankAccount.payInterest(0.05);
        assertThat(bankAccount.getBalance()).isEqualTo(expected);
    }


}
