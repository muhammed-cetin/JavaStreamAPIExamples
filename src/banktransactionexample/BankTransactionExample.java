package banktransactionexample;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BankTransactionExample {

    public static List<BankTransaction> bankTransactionList = BankLoadData.loadBankTransactions();

    public static void main(String[] args) {
        //find the total  transactions done today
        long totalTransactions = getTotalTransactionsToday();
        System.out.println("Total transactions : " + totalTransactions);


        //find the max individual  transaction done today
        LocalDate when = LocalDate.now();
        Optional<BankTransaction> minTransaction = getSmallestTransaction(when);

        System.out.println(minTransaction
                .map(transaction -> transaction.getAmount().toPlainString())
                .orElse("No transactions on" + when));

        Optional<BankTransaction> maxTransaction = getBiggestTransaction(when);

        System.out.println(maxTransaction
                .map(transaction -> transaction.getAmount().toPlainString())
                .orElse("No transactions on" + when));
    }

    private static Optional<BankTransaction> getBiggestTransaction(LocalDate when){
        Comparator<BankTransaction> byAmount =Comparator.comparing(BankTransaction::getAmount);
        return bankTransactionList.stream()
                .filter(transaction -> transaction.getDate().equals(when))
                .max(byAmount);
    }

    private static Optional<BankTransaction> getSmallestTransaction(LocalDate when) {

        Comparator<BankTransaction> byAmount = Comparator.comparing(BankTransaction::getAmount);

        return bankTransactionList.stream()
                .filter(transaction -> transaction.getDate().equals(when))
                .min(byAmount);
    }

    private static long getTotalTransactionsToday() {
        return bankTransactionList.stream()
                .filter(transaction -> transaction.getDate().equals(LocalDate.now()))
                .count();
        /*
                filter(transaction -> transaction.getDate().equals(LocalDate.now())): Stream üzerinde bir filtreleme işlemi gerçekleştiriliyor.
                transaction.getDate().equals(LocalDate.now()) ifadesi, işlemin tarihini bugünkü tarih ile karşılaştırır.
         */
    }
}
