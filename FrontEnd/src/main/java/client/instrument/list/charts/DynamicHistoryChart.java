package client.instrument.list.charts;

/**
 * Created by wemstar on 21.12.14.
 */

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
import com.sencha.gxt.chart.client.chart.Chart.Position;
import com.sencha.gxt.chart.client.chart.Legend;
import com.sencha.gxt.chart.client.chart.axis.CategoryAxis;
import com.sencha.gxt.chart.client.chart.axis.NumericAxis;
import com.sencha.gxt.chart.client.chart.series.LineSeries;
import com.sencha.gxt.chart.client.chart.series.Primitives;
import com.sencha.gxt.chart.client.draw.Color;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.path.PathSprite;
import com.sencha.gxt.chart.client.draw.sprite.Sprite;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.Resizable;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.ExpandEvent;

import java.util.Date;
import java.util.List;

public class DynamicHistoryChart extends Composite {

    private static final SitePropertyAccess siteAccess = GWT.create(SitePropertyAccess.class);
    private static final DateTimeFormat f = DateTimeFormat.getFormat("MMM d");
    final ListStore<InstrumentHistory> store = new ListStore<InstrumentHistory>(siteAccess.nameKey());
    final Chart<InstrumentHistory> chart = new Chart<InstrumentHistory>(960, 375);

    private ContentPanel panel;


    public DynamicHistoryChart() {
        initWidget(asWidget());
        InstrumentListComposite.EVENT_BUS.addHandler(InstrumentListDetailsSelected.TYPE, new InstrumentListDetailsSelectedHandler() {
            @Override
            public void onItemSelected(InstrumentListDetailsSelected instrumentListDetailsSelected) {
                setData(instrumentListDetailsSelected.getInstrumentListDetails().getHistoryList());
            }
        });
    }

    public Widget asWidget() {


        if (panel == null) {

            chart.setStore(store);
            chart.setShadowChart(false);

            NumericAxis<InstrumentHistory> axis = new NumericAxis<InstrumentHistory>();
            axis.setPosition(Position.LEFT);
            axis.addField(siteAccess.maxPrice());
            axis.addField(siteAccess.minPrice());
            axis.addField(siteAccess.openPrice());
            axis.addField(siteAccess.closePrice());
            TextSprite title = new TextSprite("Cena");
            title.setFontSize(18);
            axis.setTitleConfig(title);
            axis.setMinorTickSteps(1);
            axis.setDisplayGrid(true);
            PathSprite odd = new PathSprite();
            odd.setOpacity(1);
            odd.setFill(new Color("#ddd"));
            odd.setStroke(new Color("#bbb"));
            odd.setStrokeWidth(0.5);
            axis.setGridOddConfig(odd);

            chart.addAxis(axis);

            CategoryAxis<InstrumentHistory, Date> catAxis = new CategoryAxis<InstrumentHistory, Date>();
            catAxis.setPosition(Position.BOTTOM);
            catAxis.setField(siteAccess.date());
            title = new TextSprite("Dzień");
            title.setFontSize(18);
            catAxis.setTitleConfig(title);
            catAxis.setLabelProvider(new LabelProvider<Date>() {
                @Override
                public String getLabel(Date item) {
                    return f.format(item);
                }
            });
            chart.addAxis(catAxis);

            final LineSeries<InstrumentHistory> series = new LineSeries<InstrumentHistory>();
            series.setYAxisPosition(Position.LEFT);
            series.setYField(siteAccess.closePrice());
            series.setStroke(new RGB(194, 0, 36));
            series.setShowMarkers(true);
            Sprite marker = Primitives.square(0, 0, 6);
            marker.setFill(new RGB(194, 0, 36));
            series.setMarkerConfig(marker);
            series.setHighlighting(true);
            chart.addSeries(series);

            final LineSeries<InstrumentHistory> series2 = new LineSeries<InstrumentHistory>();
            series2.setYAxisPosition(Position.LEFT);
            series2.setYField(siteAccess.maxPrice());
            series2.setStroke(new RGB(240, 165, 10));
            series2.setShowMarkers(true);
            series2.setSmooth(true);
            marker = Primitives.circle(0, 0, 6);
            marker.setFill(new RGB(240, 165, 10));
            series2.setMarkerConfig(marker);
            series2.setHighlighting(true);
            chart.addSeries(series2);

            final LineSeries<InstrumentHistory> series3 = new LineSeries<InstrumentHistory>();
            series3.setYAxisPosition(Position.LEFT);
            series3.setYField(siteAccess.minPrice());
            series3.setStroke(new RGB(32, 68, 186));
            series3.setShowMarkers(true);
            series3.setSmooth(true);

            marker = Primitives.diamond(0, 0, 6);
            marker.setFill(new RGB(32, 68, 186));
            series3.setMarkerConfig(marker);
            series3.setHighlighting(true);
            chart.addSeries(series3);

            final LineSeries<InstrumentHistory> series4 = new LineSeries<InstrumentHistory>();
            series4.setYAxisPosition(Position.LEFT);
            series4.setYField(siteAccess.openPrice());
            series4.setStroke(new RGB(3, 168, 186));
            series4.setShowMarkers(true);
            series4.setSmooth(true);
            marker = Primitives.diamond(0, 0, 6);
            marker.setFill(new RGB(3, 168, 186));
            series4.setMarkerConfig(marker);
            series4.setHighlighting(true);
            chart.addSeries(series4);

            final Legend<InstrumentHistory> legend = new Legend<InstrumentHistory>();
            legend.setItemHighlighting(true);
            legend.setItemHiding(true);
            legend.getBorderConfig().setStrokeWidth(0);
            chart.setLegend(legend);
            chart.setAnimated(true);


            panel = new FramedPanel();
            panel.setLayoutData(new MarginData(10));
            panel.setCollapsible(true);
            panel.getHeader().setVisible(false);
            panel.setSize("100%", "100%");
            panel.setBodyBorder(true);

            VerticalLayoutContainer layout = new VerticalLayoutContainer();
            panel.add(layout);

            final Resizable resize = new Resizable(panel, Resizable.Dir.E, Resizable.Dir.SE, Resizable.Dir.S);
            resize.setMinHeight(400);
            resize.setMinWidth(400);

            panel.addExpandHandler(new ExpandEvent.ExpandHandler() {
                @Override
                public void onExpand(ExpandEvent event) {
                    resize.setEnabled(true);
                }
            });
            panel.addCollapseHandler(new CollapseEvent.CollapseHandler() {
                @Override
                public void onCollapse(CollapseEvent event) {
                    resize.setEnabled(false);
                }
            });

            new Draggable(panel, panel.getHeader()).setUseProxy(false);


            chart.setLayoutData(new VerticalLayoutData(1, 1));
            layout.add(chart);
        }

        return panel;
    }

    public void setData(List<InstrumentHistory> history) {
        store.clear();
        if (history.size() < 20) store.addAll(history);
        else store.addAll(history.subList(history.size() - 20, history.size()));
        chart.redrawChart();

    }

    public interface SitePropertyAccess extends PropertyAccess<InstrumentHistory> {
        ValueProvider<InstrumentHistory, Date> date();

        @Path("date")
        ModelKeyProvider<InstrumentHistory> nameKey();

        ValueProvider<InstrumentHistory, Double> openPrice();

        ValueProvider<InstrumentHistory, Double> closePrice();

        ValueProvider<InstrumentHistory, Double> minPrice();

        ValueProvider<InstrumentHistory, Double> maxPrice();
    }
}
