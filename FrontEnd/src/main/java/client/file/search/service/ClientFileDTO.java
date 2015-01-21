package client.file.search.service;

import client.bra.account.service.BraAccountDTO;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO dla kartoteki klienta
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientFileDTO implements Serializable {

    private String name;
    private String surname;
    private Date dateOfBirth;
    private String pesel;
    private String clientNo = "";
    private List<BraAccountDTO> accounts = new ArrayList<BraAccountDTO>();

    @Override
    public String toString() {
        return "SearchClientDTO{" +
                "accounts=" + accounts +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", pesel='" + pesel + '\'' +
                ", clientNo='" + clientNo + '\'' +
                '}';
    }

    public List<BraAccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BraAccountDTO> accounts) {
        this.accounts = accounts;
    }


    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }


}
