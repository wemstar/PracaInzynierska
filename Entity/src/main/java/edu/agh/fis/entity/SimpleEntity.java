package edu.agh.fis.entity;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wemstar on 06.09.14.
 */
@Entity
public class SimpleEntity {

    @Id
    @GeneratedValue
    public int id;

    @Column
    public String name;
}
