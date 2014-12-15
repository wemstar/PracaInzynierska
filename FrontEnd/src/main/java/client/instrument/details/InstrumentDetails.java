package client.instrument.details;

import client.instrument.order.service.dto.InstrumentDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;

/**
 * Created by wemstar on 15.12.14.
 */
public class InstrumentDetails implements Editor<InstrumentDTO> {
    private static final InstrumentDTODriver driver = GWT.create(InstrumentDTODriver.class);
    private static InstrumentDetailsUiBinder ourUiBinder = GWT.create(InstrumentDetailsUiBinder.class);

    public InstrumentDetails() {
        DivElement rootElement = ourUiBinder.createAndBindUi(this);
    }

    interface InstrumentDetailsUiBinder extends UiBinder<DivElement, InstrumentDetails> {
    }

    public interface InstrumentDTODriver extends SimpleBeanEditorDriver<InstrumentDTO, InstrumentDetails> {
    }
}