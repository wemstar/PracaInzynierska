package client.events;

import client.instrument.service.InstrumentListDetails;
import com.google.gwt.event.shared.GwtEvent;

/**
 * event wybrania instrumentu
 */
public class InstrumentListDetailsSelected extends GwtEvent<InstrumentListDetailsSelectedHandler> {

    public static GwtEvent.Type<InstrumentListDetailsSelectedHandler> TYPE = new Type<InstrumentListDetailsSelectedHandler>();
    private final InstrumentListDetails instrumentListDetails;

    public InstrumentListDetailsSelected(InstrumentListDetails instrumentListDetails) {
        this.instrumentListDetails = instrumentListDetails;
    }

    public InstrumentListDetails getInstrumentListDetails() {
        return instrumentListDetails;
    }

    @Override
    public Type<InstrumentListDetailsSelectedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(InstrumentListDetailsSelectedHandler handler) {
        handler.onItemSelected(this);
    }
}
