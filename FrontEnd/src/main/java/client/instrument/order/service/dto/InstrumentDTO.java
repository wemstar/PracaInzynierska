package client.instrument.order.service.dto;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

import java.io.Serializable;

/**
 * Created by wemstar on 30.11.14.
 */
public class InstrumentDTO implements Serializable {

    private String isin;
    private String name;


    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public interface InstrumetnDTOProperties extends PropertyAccess<InstrumentDTO> {
        ModelKeyProvider<InstrumentDTO> isin();

        LabelProvider<InstrumentDTO> name();

        @Editor.Path("name")
        ValueProvider<InstrumentDTO, String> nameProp();

        @Editor.Path("isin")
        ValueProvider<InstrumentDTO, String> isinProp();
    }
}
