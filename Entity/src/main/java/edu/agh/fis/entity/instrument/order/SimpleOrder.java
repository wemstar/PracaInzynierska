package edu.agh.fis.entity.instrument.order;

import edu.agh.fis.enums.order.Side;

import javax.persistence.*;

/**
 * Created by wemstar on 18.09.14.
 */
@Entity
@Table(name = "ORDER_SIMPLE")
public class SimpleOrder {
    @Id
    @GeneratedValue
    @Column(name = "OR_ID")
    private Integer id;

    @Column(name="ORD_SIDE")
    private Side side;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }
}
