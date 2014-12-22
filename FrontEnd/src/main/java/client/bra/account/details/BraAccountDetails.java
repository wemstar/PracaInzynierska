package client.bra.account.details;

import client.MainModule;
import client.bra.account.service.BraAccountDTO;
import client.events.BraAccountContextChange;
import client.events.BraAccountContextChangeHandler;
import client.events.ReloadContext;
import client.file.search.service.ClientFileDTO;
import client.file.search.service.ClientFileService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

/**
 * Created by wemstar on 11.11.14.
 */
public class BraAccountDetails extends Composite implements Editor<BraAccountDTO> {
    private static final BraAccountDetailsDriver driver = GWT.create(BraAccountDetailsDriver.class);
    private static BraAccountDetailsUiBinder ourUiBinder = GWT.create(BraAccountDetailsUiBinder.class);



    @UiField
    TextField braAccNo;

    @UiField
    TextField avalibleCashStr;

    @UiField
    TextField blockCashStr;

    ClientFileDTO client;

    public BraAccountDetails() {
        if (braAccNo == null) {


            initWidget(ourUiBinder.createAndBindUi(this));
            driver.initialize(this);
            MainModule.EVENT_BUS.addHandler(BraAccountContextChange.TYPE, new BraAccountContextChangeHandler() {
                @Override
                public void onBraAccountContextChangeHandler(BraAccountContextChange event) {
                    driver.edit(event.getBraAccount());

                }
            });
            disableWidget(false);
        }
    }

    public ClientFileDTO getClient() {
        return client;
    }

    public void setClient(ClientFileDTO client) {
        this.client = client;
    }

    public void disableWidget(boolean mode) {
        Component[] widgets = new Component[]{avalibleCashStr, blockCashStr};
        for (Component widg : widgets) {
            widg.setEnabled(mode);
        }
    }





    @UiHandler("bAdd")
    public void add(SelectEvent event) {
        disableWidget(true);
        driver.edit(new BraAccountDTO());

    }

    @UiHandler("bSave")
    public void save(SelectEvent event) {
        ClientFileService.App.getInstance().saveBraAccount(client, driver.flush(), new AsyncCallback<BraAccountDTO>() {
            @Override
            public void onFailure(Throwable caught) {
                AlertMessageBox d = new AlertMessageBox("Zapis", "Zapis zakończony niepowodzeniem");
                d.show();

            }

            @Override
            public void onSuccess(BraAccountDTO result) {
                Info.display("Zapis", "Zapis Udany");
                MainModule.EVENT_BUS.fireEvent(new ReloadContext());
            }
        });
    }

    @UiHandler("bDelete")
    public void delete(SelectEvent event) {

    }

    interface BraAccountDetailsUiBinder extends UiBinder<VerticalPanel, BraAccountDetails> {
    }

    interface BraAccountDetailsDriver extends SimpleBeanEditorDriver<BraAccountDTO, BraAccountDetails> {
    }


}