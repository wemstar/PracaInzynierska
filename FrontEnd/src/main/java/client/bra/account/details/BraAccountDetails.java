package client.bra.account.details;

import client.MainModule;
import client.bra.account.service.BraAccountDTO;
import client.bra.account.service.InstrumentInfoDTO;
import client.events.BraAccountContextChange;
import client.events.BraAccountContextChangeHandler;
import client.events.ReloadContext;
import client.file.search.service.ClientFileDTO;
import client.file.search.service.ClientFileService;
import client.instrument.order.service.dto.InstrumentDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 11.11.14.
 */
public class BraAccountDetails extends Composite implements Editor<BraAccountDTO> {
    private static final BraAccountDetailsDriver driver = GWT.create(BraAccountDetailsDriver.class);
    private static final InstrumentInfoDtoProperites gridProperties = GWT.create(InstrumentInfoDtoProperites.class);
    private static BraAccountDetailsUiBinder ourUiBinder = GWT.create(BraAccountDetailsUiBinder.class);

    @UiField(provided = true)
    public ListStore<InstrumentInfoDTO> listStore;

    @UiField
    public GridView<InstrumentInfoDTO> gridView;

    @UiField
    public Grid<InstrumentInfoDTO> grid;

    @UiField(provided = true)
    ColumnModel<InstrumentInfoDTO> columnModel;

    @UiField
    TextField braAccNo;

    @UiField
    TextField avalibleCashStr;

    @UiField
    TextField blockCashStr;

    ClientFileDTO client;

    public BraAccountDetails() {
        if (columnModel == null) {
            columnModel = initColumnModel();
            listStore = initListStore();

            initWidget(ourUiBinder.createAndBindUi(this));
            driver.initialize(this);
            MainModule.EVENT_BUS.addHandler(BraAccountContextChange.TYPE, new BraAccountContextChangeHandler() {
                @Override
                public void onBraAccountContextChangeHandler(BraAccountContextChange event) {
                    driver.edit(event.getBraAccount());
                    setInstruments(event.getBraAccount().getInstruments());
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
        Component[] widgets = new Component[]{avalibleCashStr, blockCashStr, grid};
        for (Component widg : widgets) {
            widg.setEnabled(mode);
        }
    }

    public List<InstrumentInfoDTO> getInstruments() {
        return listStore.getAll();
    }

    public void setInstruments(List<InstrumentInfoDTO> instruments) {
        listStore.clear();
        listStore.addAll(instruments);
    }

    private ListStore<InstrumentInfoDTO> initListStore() {
        return new ListStore<InstrumentInfoDTO>(gridProperties.key());
    }

    private ColumnModel<InstrumentInfoDTO> initColumnModel() {
        ColumnConfig<InstrumentInfoDTO, InstrumentDTO> instrumentCol = new ColumnConfig<InstrumentInfoDTO, InstrumentDTO>(gridProperties.instrument(), 150, "Instrument");
        ColumnConfig<InstrumentInfoDTO, Double> ammountCol = new ColumnConfig<InstrumentInfoDTO, Double>(gridProperties.ammount(), 150, "Ilość");
        ColumnConfig<InstrumentInfoDTO, Double> blockedCol = new ColumnConfig<InstrumentInfoDTO, Double>(gridProperties.blocked(), 150, "Zablokowana");

        List<ColumnConfig<InstrumentInfoDTO, ?>> columns = new ArrayList<ColumnConfig<InstrumentInfoDTO, ?>>();
        columns.add(instrumentCol);
        columns.add(ammountCol);
        columns.add(blockedCol);

        return new ColumnModel<InstrumentInfoDTO>(columns);
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

    interface InstrumentInfoDtoProperites extends PropertyAccess<InstrumentInfoDTO> {
        @Editor.Path("instrument")
        ModelKeyProvider<InstrumentInfoDTO> key();

        ValueProvider<InstrumentInfoDTO, InstrumentDTO> instrument();

        ValueProvider<InstrumentInfoDTO, Double> ammount();

        ValueProvider<InstrumentInfoDTO, Double> blocked();

    }
}