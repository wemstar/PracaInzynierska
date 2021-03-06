package edu.agh.fis.builder.entity.client.file;

import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.client.file.ClientFile;

import java.util.Date;
import java.util.Set;

/**
 * Builder dla kartoteki klienta
 */
public class ClientFileBuilder {
    private long clientNo;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String pesel;
    private Set<BraAccount> account;

    private ClientFileBuilder() {
    }

    public static ClientFileBuilder aClientFile() {
        return new ClientFileBuilder();
    }


    public ClientFileBuilder clientNo(long clientNo) {
        this.clientNo = clientNo;
        return this;
    }

    public ClientFileBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ClientFileBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public ClientFileBuilder dateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public ClientFileBuilder pesel(String pesel) {
        this.pesel = pesel;
        return this;
    }

    public ClientFileBuilder account(Set<BraAccount> account) {
        this.account = account;
        return this;
    }

    public ClientFileBuilder but() {
        return aClientFile().clientNo(clientNo).name(name).surname(surname).dateOfBirth(dateOfBirth).pesel(pesel).account(account);
    }

    public ClientFile build() {
        ClientFile clientFile = new ClientFile();
        clientFile.setClientNo(clientNo);
        clientFile.setName(name);
        clientFile.setSurname(surname);
        clientFile.setDateOfBirth(dateOfBirth);
        clientFile.setPesel(pesel);
        clientFile.setAccount(account);
        return clientFile;
    }
}
