package modellayer.containers;

import modellayer.Loan;

import java.util.HashMap;

public class LoanCont<K, V> extends HashMap<K, V> {
    private static LoanCont<String, Loan> instance = new LoanCont();

    public static LoanCont<String, Loan> getInstance() {
        return instance;
    }

    private LoanCont() {
        super();
    }


}