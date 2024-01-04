package banktransactionexample;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankLoadData {
    static List<BankTransaction> bankTransactionList = new ArrayList<>();

    public static List<BankTransaction> loadBankTransactions(){

        bankTransactionList.add(new BankTransaction("123", BigDecimal.valueOf(250.00), LocalDate.now()));
        bankTransactionList.add(new BankTransaction("456", BigDecimal.valueOf(1250.00), LocalDate.now().minusDays(1)));
        bankTransactionList.add(new BankTransaction("789", BigDecimal.valueOf(2250.00), LocalDate.now()));
        bankTransactionList.add(new BankTransaction("987", BigDecimal.valueOf(550.00), LocalDate.now()));
        bankTransactionList.add(new BankTransaction("654", BigDecimal.valueOf(750.00), LocalDate.now()));
        bankTransactionList.add(new BankTransaction("123", BigDecimal.valueOf(4350.00), LocalDate.now()));
        bankTransactionList.add(new BankTransaction("789", BigDecimal.valueOf(150.00), LocalDate.now()));
        bankTransactionList.add(new BankTransaction("456", BigDecimal.valueOf(850.00), LocalDate.now().minusDays(2)));

        return bankTransactionList;
    }
}
