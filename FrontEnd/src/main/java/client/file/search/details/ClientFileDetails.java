package client.file.search.details;

import client.MainModule;
import client.bra.account.details.BraAccountDetails;
import client.bra.account.visualization.BraAccountCart;
import client.events.ClientContextChange;
import client.events.ClientContextChangeHandler;
import client.file.search.service.ClientSearchService;
import client.file.search.service.SearchClientDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

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
    public FramedPanel braAccountDetailsPanel;

    @UiField
    public TextField clientNo;
    @UiField
    FlowPanel chart;
    BraAccountCart cahrtWidg;
    private boolean newClient = false;
    private BraAccountDetails braAccountDetails;
    public ClientFileDetails() {
        initWidget(ourUiBinder.createAndBindUi(this));
        driver.initialize(this);

        cahrtWidg = new BraAccountCart();
        chart.add(cahrtWidg);
        disableWidgets(false);
        MainModule.EVENT_BUS.addHandler(ClientContextChange.TYPE, new ClientContextChangeHandler() {
            @Override
            public void onClientContextChange(ClientContextChange event) {
                setClientFile(event.getClientDetails());
            }
        });
        braAccountDetails = new BraAccountDetails();
        braAccountDetailsPanel.add(braAccountDetails);
    }

    public boolean isNewClient() {
        return newClient;
    }

    public void setNewClient(boolean newClient) {
        this.newClient = newClient;
    }

    public void setClientFile(SearchClientDTO clientFile) {
        driver.edit(clientFile);
        cahrtWidg.setBraAccounts(clientFile.getAccounts());
    }


    private void disableWidgets(boolean mode) {

        Component[] widgets = new Component[]{name, surname, dateOfBirth, pesel};
        for (Component widg : widgets) {
            widg.setEnabled(mode);

        }

    }

    @UiHandler("bSave")
    public void save(SelectEvent event) {
        SearchClientDTO dto = driver.flush();
        dto.setAccounts(cahrtWidg.getAccounts());
        if (!dto.getClientNo().isEmpty())
            ClientSearchService.App.getInstance().saveClient(dto, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    AlertMessageBox d = new AlertMessageBox("Zapis", "Zapis zakończony niepowodzeniem" + caught.toString());

                    d.show();
                }

                @Override
                public void onSuccess(Void result) {
                    Info.display("Zapis", "Zapis zakończono sukcesem");
                }
            });
        else ClientSearchService.App.getInstance().createClient(dto, new AsyncCallback<SearchClientDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                AlertMessageBox d = new AlertMessageBox("Zapis", "Zapis zakończony niepowodzeniem" + caught.toString());

                d.show();
            }

            @Override
            public void onSuccess(SearchClientDTO result) {
                Info.display("Zapis", "Zapis zakończono sukcesem");
                MainModule.EVENT_BUS.fireEvent(new ClientContextChange(result));
                braAccountDetails.disableWidget(false);
                disableWidgets(false);
            }
        });

    }

    @UiHandler("bEdit")
    public void edit(SelectEvent evet) {
        disableWidgets(true);
        braAccountDetails.disableWidget(true);
    }

    @UiHandler("bDelete")
    public void delete(SelectEvent evet) {
        ClientSearchService.App.getInstance().deleteClientFile(driver.flush(), new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {

            }

            @Override
            public void onSuccess(Void result) {
                Info.display("Delete", "Delete Sucesfull");
            }
        });
    }

    interface ClientFileDetailsUiBinder extends UiBinder<HorizontalLayoutContainer, ClientFileDetails> {
    }

    public interface ClientFileDetailsDriver extends SimpleBeanEditorDriver<SearchClientDTO, ClientFileDetails> {
    }
}