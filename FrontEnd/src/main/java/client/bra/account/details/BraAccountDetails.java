package client.bra.account.details;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

/**
 * Created by wemstar on 11.11.14.
 */
public class BraAccountDetails {
    interface BraAccountDetailsUiBinder extends UiBinder<DivElement, BraAccountDetails> {}

    private static BraAccountDetailsUiBinder ourUiBinder = GWT.create(BraAccountDetailsUiBinder.class);

    public BraAccountDetails() {
        DivElement rootElement = ourUiBinder.createAndBindUi(this);
    }
}