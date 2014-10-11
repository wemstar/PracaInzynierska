package edu.agh.fis.client.file;

import edu.agh.fis.bra.acc.BraAccountDTO;

import java.util.Date;
import java.util.Set;

/**
 * Created by wemstar on 13.09.14.
 */
public class ClientFileDTO {
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Set<BraAccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<BraAccountDTO> accounts) {
        this.accounts = accounts;
    }

    public long getClientNo() {
        return clientNo;
    }

    public void setClientNo(long clientNo) {
        this.clientNo = clientNo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;
    public String surname;
    public Date dateOfBirth;
    public String pesel;
    public Set<BraAccountDTO> accounts;
    public long clientNo;


}
