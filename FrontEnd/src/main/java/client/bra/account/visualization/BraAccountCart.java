package client.bra.account.visualization;

import client.MainModule;
import client.bra.account.service.BraAccountDTO;
import client.events.BraAccountEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.user.client.ui.Composite;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.chart.client.chart.Chart.Position;
import com.sencha.gxt.chart.client.chart.Legend;
import com.sencha.gxt.chart.client.chart.event.SeriesSelectionEvent;
import com.sencha.gxt.chart.client.chart.series.PieSeries;
import com.sencha.gxt.chart.client.chart.series.Series.LabelPosition;
import com.sencha.gxt.chart.client.chart.series.SeriesLabelConfig;
import com.sencha.gxt.chart.client.draw.Gradient;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.Stop;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextAnchor;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextBaseline;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.*;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Resizable;
import com.sencha.gxt.widget.core.client.Resizable.Dir;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;
import com.sencha.gxt.widget.core.client.event.ExpandEvent.ExpandHandler;

import java.util.List;

/**
 * Created by wemstar on 11.11.14.
 */
public class BraAccountCart extends Composite {

    private static final DataPropertyAccess dataAccess = GWT.create(DataPropertyAccess.class);
    final Chart<BraAccountDTO> chart;
    private final ListStore<BraAccountDTO> store;
    private FramedPanel panel;

    public BraAccountCart() {

        store = new ListStore<BraAccountDTO>(dataAccess.nameKey());

        chart = new Chart<BraAccountDTO>();
        chart.setDefaultInsets(50);
        chart.setStore(store);
        chart.setShadowChart(false);

        Gradient slice1 = new Gradient(45);
        slice1.addStop(new Stop(0, new RGB(148, 174, 10)));
        slice1.addStop(new Stop(100, new RGB(107, 126, 7)));
        chart.addGradient(slice1);

        Gradient slice2 = new Gradient(45);
        slice2.addStop(new Stop(0, new RGB(17, 95, 166)));
        slice2.addStop(new Stop(100, new RGB(12, 69, 120)));
        chart.addGradient(slice2);

        Gradient slice3 = new Gradient(45);
        slice3.addStop(new Stop(0, new RGB(166, 17, 32)));
        slice3.addStop(new Stop(100, new RGB(120, 12, 23)));
        chart.addGradient(slice3);

        Gradient slice4 = new Gradient(45);
        slice4.addStop(new Stop(0, new RGB(255, 136, 9)));
        slice4.addStop(new Stop(100, new RGB(213, 110, 0)));
        chart.addGradient(slice4);

        Gradient slice5 = new Gradient(45);
        slice5.addStop(new Stop(0, new RGB(255, 209, 62)));
        slice5.addStop(new Stop(100, new RGB(255, 197, 11)));
        chart.addGradient(slice5);

        Gradient slice6 = new Gradient(45);
        slice6.addStop(new Stop(0, new RGB(166, 17, 135)));
        slice6.addStop(new Stop(100, new RGB(120, 12, 97)));
        chart.addGradient(slice6);

        final PieSeries<BraAccountDTO> series = new PieSeries<BraAccountDTO>();
        series.setAngleField(dataAccess.avalibleCash());
        series.addColor(slice1);
        series.addColor(slice2);
        series.addColor(slice3);
        series.addColor(slice4);
        series.addColor(slice5);
        series.addColor(slice6);
        TextSprite textConfig = new TextSprite();
        textConfig.setFont("Arial");
        textConfig.setTextBaseline(TextBaseline.MIDDLE);
        textConfig.setFontSize(18);
        textConfig.setTextAnchor(TextAnchor.MIDDLE);
        textConfig.setZIndex(15);
        SeriesLabelConfig<BraAccountDTO> labelConfig = new SeriesLabelConfig<BraAccountDTO>();
        labelConfig.setSpriteConfig(textConfig);
        labelConfig.setLabelPosition(LabelPosition.START);
        labelConfig.setValueProvider(dataAccess.braAccNo(), new StringLabelProvider<String>());
        series.setLabelConfig(labelConfig);
        series.setHighlighting(true);
        series.setDonut(35);
        series.setLegendValueProvider(dataAccess.braAccNo(), new LabelProvider<String>() {

            @Override
            public String getLabel(String item) {
                return item.substring(0, 3);
            }
        });
        chart.addSeries(series);
        series.addSeriesSelectionHandler(new SeriesSelectionEvent.SeriesSelectionHandler<BraAccountDTO>() {


            @Override
            public void onSeriesSelection(SeriesSelectionEvent<BraAccountDTO> event) {


                MainModule.EVENT_BUS.fireEvent(new BraAccountEvent(event.getItem()));
            }
        });

        final Legend<BraAccountDTO> legend = new Legend<BraAccountDTO>();
        legend.setPosition(Position.RIGHT);
        legend.setItemHighlighting(true);
        legend.setItemHiding(true);
        legend.getBorderConfig().setStrokeWidth(0);
        chart.setLegend(legend);
        chart.setAnimated(true);


        panel = new FramedPanel();
        panel.setLayoutData(new MarginData(10));
        panel.setCollapsible(true);
        panel.setHeadingText("Rachunki Klienta");
        panel.setHeight(600);

        panel.setBodyBorder(true);

        final Resizable resize = new Resizable(panel, Dir.E, Dir.SE, Dir.S);
        resize.setMinHeight(400);
        resize.setMinWidth(400);

        panel.addExpandHandler(new ExpandHandler() {
            @Override
            public void onExpand(ExpandEvent event) {
                resize.setEnabled(true);
            }
        });
        panel.addCollapseHandler(new CollapseHandler() {
            @Override
            public void onCollapse(CollapseEvent event) {
                resize.setEnabled(false);
            }
        });

        new Draggable(panel, panel.getHeader()).setUseProxy(false);

        VerticalLayoutContainer layout = new VerticalLayoutContainer();
        panel.add(layout);


        chart.setLayoutData(new VerticalLayoutData(1, 1));
        layout.add(chart);

        initWidget(panel);

    }

    public void setBraAccounts(List<BraAccountDTO> braAccounts) {
        store.clear();
        for (BraAccountDTO item : braAccounts) {
            store.add(item);

        }
        chart.redrawChart();


    }

    public interface DataPropertyAccess extends PropertyAccess<BraAccountDTO> {
        ValueProvider<BraAccountDTO, Double> avalibleCash();

        ValueProvider<BraAccountDTO, String> braAccNo();

        @Path("braAccNo")
        ModelKeyProvider<BraAccountDTO> nameKey();
    }


}
