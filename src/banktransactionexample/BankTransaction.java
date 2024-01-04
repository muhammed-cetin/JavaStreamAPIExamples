package banktransactionexample;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankTransaction {
    private String accNumber;
    private BigDecimal amount;
    private LocalDate date;

    public BankTransaction() {
    }

    public BankTransaction(String accNumber, BigDecimal amount, LocalDate date) {
        this.accNumber = accNumber;
        this.amount = amount;
        this.date = date;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
