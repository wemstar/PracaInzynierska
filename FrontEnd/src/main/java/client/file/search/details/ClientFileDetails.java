package client.file.search.details;

import client.MainModule;
import client.bra.account.details.BraAccountDetails;
import client.bra.account.visualization.BraAccountCart;
import client.events.ClientContextChange;
import client.events.ClientContextChangeHandler;
import client.file.search.service.SearchClientDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Created by wemstar on 11.11.14.
 */
public class ClientFileDetails extends Composite implements Editor<SearchClientDTO> {


    private static final ClientFileDetailsDriver driver = GWT.create(ClientFileDetailsDriver.class);
    public static String title = "Szczegóły";
    private static ClientFileDetailsUiBinder ourUiBinder = GWT.create(ClientFileDetailsUiBinder.class);
    @UiField
    public TextField name;
    @UiField
    public TextField surname;
    @UiField
    public DateField dateOfBirth;
    @UiField
    public TextField pesel;
    @UiField
    public FramedPanel braAccountDetails;
    @UiField
    FlowPanel chart;
    BraAccountCart cahrtWidg;


    public ClientFileDetails() {
        initWidget(ourUiBinder.createAndBindUi(this));
        driver.initialize(this);

        cahrtWidg = new BraAccountCart();
        chart.add(cahrtWidg);
        disableWidgets(new Component[]{name, surname, dateOfBirth, pesel}, false);
        MainModule.EVENT_BUS.addHandler(ClientContextChange.TYPE, new ClientContextChangeHandler() {
            @Override
            public void onClientContextChange(ClientContextChange event) {
                setClientFile(event.getClientDetails());
            }
        });
        braAccountDetails.add(new BraAccountDetails());
    }

    public void setClientFile(SearchClientDTO clientFile) {
        driver.edit(clientFile);
        cahrtWidg.setBraAccounts(clientFile.getBraAccount());
    }

    private void disableWidgets(Component[] widgets,boolean mode) {
        for(Component widg:widgets)
            widg.setEnabled(mode);
    }

    interface ClientFileDetailsUiBinder extends UiBinder<HorizontalLayoutContainer, ClientFileDetails> {
    }

    public interface ClientFileDetailsDriver extends SimpleBeanEditorDriver<SearchClientDTO, ClientFileDetails> {
    }
}