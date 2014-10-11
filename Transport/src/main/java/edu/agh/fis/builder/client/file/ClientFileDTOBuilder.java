package edu.agh.fis.builder.client.file;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.client.file.ClientFileDTO;

import java.util.Date;
import java.util.Set;

/**
 * Created by wemstar on 11.10.14.
 */
public class ClientFileDTOBuilder {
    public String name;
    public String surname;
    public Date dateOfBirth;
    public String pesel;
    public Set<BraAccountDTO> accounts;
    public long clientNo;

    private ClientFileDTOBuilder() {
    }

    public static ClientFileDTOBuilder aClientFileTransport() {
        return new ClientFileDTOBuilder();
    }

    public ClientFileDTOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ClientFileDTOBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public ClientFileDTOBuilder dateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public ClientFileDTOBuilder pesel(String pesel) {
        this.pesel = pesel;
        return this;
    }

    public ClientFileDTOBuilder accounts(Set<BraAccountDTO> accounts) {
        this.accounts = accounts;
        return this;
    }

    public ClientFileDTOBuilder clientNo(long clientNo) {
        this.clientNo = clientNo;
        return this;
    }

    public ClientFileDTOBuilder but() {
        return aClientFileTransport().name(name).surname(surname).dateOfBirth(dateOfBirth).pesel(pesel).accounts(accounts).clientNo(clientNo);
    }

    public ClientFileDTO build() {
        ClientFileDTO clientFileDTO = new ClientFileDTO();
        clientFileDTO.setName(name);
        clientFileDTO.setSurname(surname);
        clientFileDTO.setDateOfBirth(dateOfBirth);
        clientFileDTO.setPesel(pesel);
        clientFileDTO.setAccounts(accounts);
        clientFileDTO.setClientNo(clientNo);
        return clientFileDTO;
    }
}
