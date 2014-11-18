package client.bra.account.service;

import java.io.Serializable;

/**
 * Created by wemstar on 11.11.14.
 */
public class BraAccountDTO implements Serializable {

    private String braAccNo;
    private Double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBraAccNo() {
        return braAccNo;
    }

    public void setBraAccNo(String braAccNo) {
        this.braAccNo = braAccNo;
    }
}
