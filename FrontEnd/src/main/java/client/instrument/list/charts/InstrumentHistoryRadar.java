package client.instrument.list.charts;

import client.events.InstrumentListDetailsSelected;
import client.events.InstrumentListDetailsSelectedHandler;
import client.instrument.list.composite.InstrumentListComposite;
import client.instrument.service.InstrumentHistory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.chart.client.chart.Legend;
import com.sencha.gxt.chart.client.chart.axis.RadialAxis;
import com.sencha.gxt.chart.client.chart.series.Primitives;
import com.sencha.gxt.chart.client.chart.series.RadarSeries;
import com.sencha.gxt.chart.client.chart.series.SeriesRenderer;
import com.sencha.gxt.chart.client.draw.Color;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.Sprite;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Resizable;
import com.sencha.gxt.widget.core.client.Resizable.Dir;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;
import com.sencha.gxt.widget.core.client.event.ExpandEvent.ExpandHandler;

import java.util.Date;
import java.util.List;

/**
 * historia instrumentów
 */
public class InstrumentHistoryRadar extends Composite {

    private static final DataPropertyAccess dataAccess = GWT.create(DataPropertyAccess.class);
    private static final DateTimeFormat f = DateTimeFormat.getFormat("MMM d");
    final ListStore<InstrumentHistory> store = new ListStore<InstrumentHistory>(dataAccess.nameKey());
    final Chart<InstrumentHistory> chart = new Chart<InstrumentHistory>(550, 375);
    private Color[] colors = {new RGB("#6d9824"), new RGB("#87146e"), new RGB("#2a9196"), new RGB("#2f9176")};
    private double strokeWidth = 2;
    private double opacity = 1;
    private ContentPanel panel;

    public InstrumentHistoryRadar() {
        initWidget(getWidget());
    }

    public void setData(List<InstrumentHistory> data) {
        store.clear();
        if (data.size() != 0 && data.size() < 8)
            store.addAll(data);
        else if (data.size() >= 8)
            store.addAll(data.subList(data.size() - 8, data.size()));
        chart.redrawChart();
    }

    public Widget getWidget() {

        if (panel == null) {
            chart.setStore(store);
            chart.setDefaultInsets(20);

            RadialAxis<InstrumentHistory, Date> axis = new RadialAxis<InstrumentHistory, Date>();
            axis.setCategoryField(dataAccess.date());
            axis.setDisplayGrid(true);
            axis.setLabelProvider(new LabelProvider<Date>() {
                @Override
                public String getLabel(Date item) {
                    return f.format(item);
                }
            });
            chart.addAxis(axis);

            final RadarSeries<InstrumentHistory> radar = new RadarSeries<InstrumentHistory>();
            radar.setYField(dataAccess.openPrice());
            radar.setStroke(colors[0]);
            radar.setShowMarkers(true);
            Sprite marker = Primitives.circle(0, 0, 4);
            marker.setFill(colors[0]);
            radar.setMarkerConfig(marker);
            radar.setLineRenderer(createRenderer(0));
            radar.setLegendTitle("Cena Otwarcia");
            chart.addSeries(radar);

            final RadarSeries<InstrumentHistory> radar2 = new RadarSeries<InstrumentHistory>();
            radar2.setYField(dataAccess.minPrice());
            radar2.setStroke(colors[1]);
            radar2.setShowMarkers(true);
            marker = Primitives.diamond(0, 0, 4);
            marker.setFill(colors[1]);
            radar2.setMarkerConfig(marker);
            radar2.setLineRenderer(createRenderer(1));
            radar2.setLegendTitle("Cena Minimalna");
            chart.addSeries(radar2);

            final RadarSeries<InstrumentHistory> radar3 = new RadarSeries<InstrumentHistory>();
            radar3.setYField(dataAccess.maxPrice());
            radar3.setStroke(colors[2]);
            radar3.setShowMarkers(true);
            marker = Primitives.square(0, 0, 4);
            marker.setFill(colors[2]);
            radar3.setMarkerConfig(marker);
            radar3.setLineRenderer(createRenderer(2));
            radar3.setLegendTitle("Cena Maxymalna");
            chart.addSeries(radar3);

            final RadarSeries<InstrumentHistory> radar4 = new RadarSeries<InstrumentHistory>();
            radar4.setYField(dataAccess.closePrice());
            radar4.setStroke(colors[2]);
            radar4.setShowMarkers(true);
            marker = Primitives.square(0, 0, 4);
            marker.setFill(colors[3]);
            radar4.setMarkerConfig(marker);
            radar4.setLineRenderer(createRenderer(3));
            radar4.setLegendTitle("Cena Zamknięcia");
            chart.addSeries(radar4);

            final Legend<InstrumentHistory> legend = new Legend<InstrumentHistory>();
            legend.setItemHighlighting(true);
            legend.setItemHiding(true);
            legend.getBorderConfig().setStrokeWidth(0);
            legend.setPosition(Chart.Position.LEFT);
            chart.setLegend(legend);

            panel = new ContentPanel();
            panel.setLayoutData(new MarginData(10));
            panel.setCollapsible(true);
            panel.setSize("100%", "100%");
            panel.getHeader().setVisible(false);
            panel.setBodyBorder(true);
            chart.setAnimated(true);
            opacity = 0.4;
            chart.redrawChart();


            final Resizable resize = new Resizable(panel, Dir.E, Dir.SE, Dir.S);
            resize.setMinHeight(300);
            resize.setMinWidth(300);

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
            InstrumentListComposite.EVENT_BUS.addHandler(InstrumentListDetailsSelected.TYPE, new InstrumentListDetailsSelectedHandler() {
                @Override
                public void onItemSelected(InstrumentListDetailsSelected instrumentListDetailsSelected) {
                    setData(instrumentListDetailsSelected.getInstrumentListDetails().getHistoryList());
                }
            });
        }


        return panel;
    }

    public SeriesRenderer<InstrumentHistory> createRenderer(final int seriesIndex) {
        return new SeriesRenderer<InstrumentHistory>() {
            @Override
            public void spriteRenderer(Sprite sprite, int index, ListStore<InstrumentHistory> store) {
                sprite.setStrokeWidth(strokeWidth);
                sprite.setOpacity(opacity);
                sprite.setFill(colors[seriesIndex]);
                sprite.redraw();
            }
        };
    }

    public interface DataPropertyAccess extends PropertyAccess<InstrumentHistory> {
        ValueProvider<InstrumentHistory, Double> openPrice();

        ValueProvider<InstrumentHistory, Double> minPrice();

        ValueProvider<InstrumentHistory, Double> maxPrice();

        ValueProvider<InstrumentHistory, Double> closePrice();

        ValueProvider<InstrumentHistory, Date> date();

        @Path("date")
        ModelKeyProvider<InstrumentHistory> nameKey();
    }


}
