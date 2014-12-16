package client.instrument.order;

import client.constraint.DictionaryConstraint;
import client.instrument.order.service.NewOrderService;
import client.instrument.order.service.dto.InstrumentDTO;
import client.instrument.order.service.dto.MarketDTO;
import client.instrument.order.service.dto.NewOrderDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.*;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.DoubleSpinnerField;
import com.sencha.gxt.widget.core.client.form.LongSpinnerField;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wemstar on 30.11.14.
 */
public class NewOrder extends Composite implements Editor<NewOrderDTO> {
    private static NewOrderUiBinder ourUiBinder = GWT.create(NewOrderUiBinder.class);
    private static InstrumentDTO.InstrumetnDTOProperties properties = GWT.create(InstrumentDTO.InstrumetnDTOProperties.class);
    private static MarketDTOProperties propertiesMarket = GWT.create(MarketDTOProperties.class);
    private static NewOrderDTODriver driver = GWT.create(NewOrderDTODriver.class);

    @UiField(provided = true)
    LabelProvider<InstrumentDTO> instrumentsLabel = properties.name();

    @UiField(provided = true)
    ListStore<InstrumentDTO> instrumentsList = new ListStore<InstrumentDTO>(properties.isin());

    @UiField(provided = true)
    LabelProvider<MarketDTO> marketsLabel = propertiesMarket.name();

    @UiField(provided = true)
    ListStore<MarketDTO> marketsList = new ListStore<MarketDTO>(propertiesMarket.code());

    @UiField(provided = true)
    LabelProvider<String> sideLabel = new StringLabelProvider<String>();

    @UiField
    SimpleComboBox<String> side;

    @UiField
    SimpleComboBox<String> type;

    @UiField
    ComboBox<InstrumentDTO> instrument;

    @UiField
    ComboBox<MarketDTO> market;

    @UiField
    DoubleSpinnerField price;

    @UiField
    LongSpinnerField amount;

    private AsyncCallback<List<MarketDTO>> callbackMarketList = new AsyncCallback<List<MarketDTO>>() {
        @Override
        public void onFailure(Throwable caught) {
            AlertMessageBox d = new AlertMessageBox("Błąd", "Problem podczas pobieranie rynków");
            d.show();
        }

        @Override
        public void onSuccess(List<MarketDTO> result) {
            marketsList.addAll(result);
        }
    };

    public NewOrder() {

        NewOrderService.App.getInstance().getMarkets(callbackMarketList);
        initWidget(ourUiBinder.createAndBindUi(this));
        side.add(Arrays.asList(DictionaryConstraint.side));
        type.add(Arrays.asList(DictionaryConstraint.ordersType));
        driver.initialize(this);
        driver.edit(new NewOrderDTO());
    }

    @UiHandler("market")
    public void valueChange(ValueChangeEvent<MarketDTO> events) {
        instrumentsList.addAll(events.getValue().getInstruments());
    }

    @UiHandler("newOrder")
    public void createNewOrder(SelectEvent event) {
        final AutoProgressMessageBox box = new AutoProgressMessageBox("Wysyłanie", "Wysyłanie zlecenia proszę czekać");
        box.setProgressText("Wysyłanie...");
        box.auto();
        box.show();
        NewOrderService.App.getInstance().createNewOrder(driver.flush(), new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                AlertMessageBox d = new AlertMessageBox("Błąd", "Problem podczas składania zlecenia");
                d.show();
            }

            @Override
            public void onSuccess(Void result) {
                Info.display("Info", "Zlecenie zostało wysłane");
                box.hide();
            }
        });
    }

    interface NewOrderUiBinder extends UiBinder<VerticalPanel, NewOrder> {
    }

    interface MarketDTOProperties extends PropertyAccess<MarketDTO> {
        ModelKeyProvider<MarketDTO> code();

        LabelProvider<MarketDTO> name();

        @Editor.Path("code")
        ValueProvider<MarketDTO, String> codeProp();
    }

    interface NewOrderDTODriver extends SimpleBeanEditorDriver<NewOrderDTO, NewOrder> {
    }

}