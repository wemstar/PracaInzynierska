package edu.agh.fis.entity.instrument.details;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wemstar on 29.09.14.
 */
@Entity
@Table(name = "INSTRUMENT_DEFINITION")
public class InstrumentDefinition {

    @Id
    private long id;
}
