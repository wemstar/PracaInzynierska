package client.file.search.service;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wemstar on 08.11.14.
 */

public class SearchClientDTO implements Serializable {

    private String name;
    private String surname;
    private Date dateOfBirth;
    private String pesel;
    private String clientNo;

    @Override
    public String toString() {
        return "SearchcClientProxy{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", pesel='" + pesel + '\'' +
                ", clientNo=" + clientNo +
                '}';
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
