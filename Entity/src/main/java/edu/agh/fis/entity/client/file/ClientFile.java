package edu.agh.fis.entity.client.file;


import edu.agh.fis.entity.bra.acc.BraAccount;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by wemstar on 06.09.14.
 */
@Entity
@Table(name = "CLIENT_FILE")
public class ClientFile {

    @Id
    @GeneratedValue
    @Column(name = "CLIENT_FILE_ID", unique = true, nullable = false)
    public long id;

    @Column(unique = true, name = "CLIENT_NUMBER")
    public long clientNo;

    @Column(name = "CLIENT_NAME")
    public String name;

    @Column(name = "CLIENT_SURNAME")
    public String surname;

    @Column(name = "CLIENT_DATE_OF_BIRTH")
    public Date dateOfBirth;

    @Column(name = "CLIENT_PESEL")
    public String pesel;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clientFile")
    public Set<BraAccount> account;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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



    public String toString() {
        return " " + id + " " + clientNo + " " + name;
    }

}
