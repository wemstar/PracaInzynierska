package client.instrument.list.composite;

import client.MainModule;
import client.bra.account.service.BraAccountDTO;
import client.events.BraAccountContextChange;
import client.events.BraAccountContextChangeHandler;
import client.instrument.list.charts.DynamicHistoryChart;
import client.instrument.list.charts.InstrumentHistoryRadar;
import client.instrument.list.grid.InstrumentListGrid;
import client.instrument.service.InstrumentListDetails;
import client.instrument.service.InstrumentService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.List;

/**
 * Created by wemstar on 21.12.14.
 */
public class InstrumentListComposite extends Composite {


    public static EventBus EVENT_BUS = GWT.create(SimpleEventBus.class);
    private static InstrumentListCompositeUiBinder ourUiBinder = GWT.create(InstrumentListCompositeUiBinder.class);
    @UiField
    FramedPanel grid;
    @UiField
    FramedPanel radar;
    @UiField
    FramedPanel dynamic;
    private InstrumentListGrid gridView;
    private InstrumentHistoryRadar radarView = new InstrumentHistoryRadar();
    private DynamicHistoryChart dynamicView = new DynamicHistoryChart();

    public InstrumentListComposite() {
        if (gridView == null) {
            gridView = new InstrumentListGrid();
            initWidget(ourUiBinder.createAndBindUi(this));
            grid.add(gridView);
            radar.add(radarView);
            dynamic.add(dynamicView);
            MainModule.EVENT_BUS.addHandler(BraAccountContextChange.TYPE, new BraAccountContextChangeHandler() {
                @Override
                public void onBraAccountContextChangeHandler(BraAccountContextChange event) {
                    setBraContext(event.getBraAccount());
                }
            });
        }

    }

    public void setBraContext(BraAccountDTO braContext) {
        if (braContext != null)
            InstrumentService.App.getInstance().getInstrumentForBraAccount(braContext, new AsyncCallback<List<InstrumentListDetails>>() {
                @Override
                public void onFailure(Throwable caught) {
                    AlertMessageBox messageBox = new AlertMessageBox("Błąd", "Błąd pobierania histori");
                    messageBox.show();
                }

                @Override
                public void onSuccess(List<InstrumentListDetails> result) {
                    Info.display("Pobieranie Histori", "Pobrano " + result.size() + " wyników");
                    gridView.setData(result);
                }
            });
    }

    interface InstrumentListCompositeUiBinder extends UiBinder<VerticalLayoutContainer, InstrumentListComposite> {
    }
}