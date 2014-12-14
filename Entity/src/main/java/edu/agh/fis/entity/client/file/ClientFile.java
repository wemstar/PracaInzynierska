package edu.agh.fis.entity.client.file;


import edu.agh.fis.entity.bra.acc.BraAccount;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by wemstar on 06.09.14.
 */
@Entity
@Table(name = "CLIENT_FILE")
public class ClientFile {


    @Column(unique = true, name = "CLIENT_NUMBER", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientNo;

    @Column(name = "CLIENT_NAME")
    private String name;

    @Column(name = "CLIENT_SURNAME")
    private String surname;

    @Column(name = "CLIENT_DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "CLIENT_PESEL")
    private String pesel;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clientFile")
    @Fetch(FetchMode.JOIN)
    private Set<BraAccount> account;

    @Override
    public String toString() {
        return "ClientFile{" +
                "account=" + account +
                ", clientNo=" + clientNo +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", pesel='" + pesel + '\'' +
                '}';
    }

    public Long getClientNo() {
        return clientNo;
    }

    public void setClientNo(Long clientNo) {
        this.clientNo = clientNo;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Set<BraAccount> getAccount() {
        return account;
    }

    public void setAccount(Set<BraAccount> account) {
        this.account = account;
    }


}
