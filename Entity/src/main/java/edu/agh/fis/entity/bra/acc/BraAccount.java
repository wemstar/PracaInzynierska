package edu.agh.fis.entity.bra.acc;

import edu.agh.fis.entity.client.file.ClientFile;

import javax.persistence.*;

/**
 * Klasa przechowująca stan rachunku
 */
@Entity
@Table(name = "BRA_ACCOUNT")
public class BraAccount {

    @Id
    @GeneratedValue
    @Column(name = "BRA_ACCOUNT_ID")
    public long id;


    @ManyToOne
    @JoinColumn(name = "BRA_CLIENT_FILE_ID")
    public ClientFile clientFile;

    @Column(name = "BRA_BALANCE")
    public double balance;
}
