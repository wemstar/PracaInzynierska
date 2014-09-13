package edu.agh.fis.entity.client.file;

import edu.agh.fis.entity.client.account.BraAccount;

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

    @Column(unique = true,name = "CLIENT_NUMBER")
    public long clientNo;

    @Column(name = "CLIENT_NAME")
    public String name;

    @Column(name="CLIENT_SURNAME")
    public String surname;

    @Column(name="CLIENT_DATE_OF_BIRTH")
    public Date dateOfBirth;

    @Column(name="CLIENT_PESEL")
    public String pesel;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "clientFile")
    public Set<BraAccount> account;



}
