package client.instrument.list.charts;

/**
 * Created by wemstar on 21.12.14.
 */

import client.instrument.service.InstrumentHistory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.chart.client.chart.Chart.Position;
import com.sencha.gxt.chart.client.chart.axis.NumericAxis;
import com.sencha.gxt.chart.client.chart.axis.TimeAxis;
import com.sencha.gxt.chart.client.chart.series.LineSeries;
import com.sencha.gxt.chart.client.chart.series.Primitives;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.Sprite;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

import java.util.Date;

public class DynamicHistoryChart extends Composite {

    private static final SitePropertyAccess siteAccess = GWT.create(SitePropertyAccess.class);
    private static final DateTimeFormat f = DateTimeFormat.getFormat("MMM d");
    final ListStore<InstrumentHistory> store = new ListStore<InstrumentHistory>(siteAccess.nameKey());
    final Chart<InstrumentHistory> chart = new Chart<InstrumentHistory>(600, 400);
    private Timer update;
    private FramedPanel panel;

    public DynamicHistoryChart() {
        initWidget(asWidget());
    }

    public Widget asWidget() {


        chart.setDefaultInsets(20);


        chart.setStore(store);

        NumericAxis<InstrumentHistory> axis = new NumericAxis<InstrumentHistory>();
        axis.setPosition(Position.LEFT);
        axis.addField(siteAccess.openPrice());
        TextSprite title = new TextSprite("Number of Hits");
        title.setFontSize(18);
        axis.setTitleConfig(title);
        axis.setDisplayGrid(true);
        axis.setMinimum(0);
        axis.setMaximum(100);
        chart.addAxis(axis);

        final TimeAxis<InstrumentHistory> time = new TimeAxis<InstrumentHistory>();
        time.setField(siteAccess.date());
        time.setStartDate(f.parse("Feb 1"));
        time.setEndDate(f.parse("Feb 7"));
        time.setLabelProvider(new LabelProvider<Date>() {
            @Override
            public String getLabel(Date item) {
                return f.format(item);
            }
        });
        chart.addAxis(time);

        LineSeries<InstrumentHistory> series = new LineSeries<InstrumentHistory>();
        series.setYAxisPosition(Position.LEFT);
        series.setYField(siteAccess.openPrice());
        series.setStroke(new RGB(148, 174, 10));
        series.setShowMarkers(true);
        series.setMarkerIndex(1);
        Sprite marker = Primitives.circle(0, 0, 6);
        marker.setFill(new RGB(148, 174, 10));
        series.setMarkerConfig(marker);
        chart.addSeries(series);

        series = new LineSeries<InstrumentHistory>();
        series.setYAxisPosition(Position.LEFT);
        series.setYField(siteAccess.closePrice());
        series.setStroke(new RGB(17, 95, 166));
        series.setShowMarkers(true);
        series.setMarkerIndex(1);
        marker = Primitives.cross(0, 0, 6);
        marker.setFill(new RGB(17, 95, 166));
        series.setMarkerConfig(marker);
        chart.addSeries(series);

        series = new LineSeries<InstrumentHistory>();
        series.setYAxisPosition(Position.LEFT);
        series.setYField(siteAccess.minPrice());
        series.setStroke(new RGB(166, 17, 32));
        series.setShowMarkers(true);
        series.setMarkerIndex(1);
        marker = Primitives.diamond(0, 0, 6);
        marker.setFill(new RGB(166, 17, 32));
        series.setMarkerConfig(marker);
        chart.addSeries(series);

        update = new Timer() {
            @Override
            public void run() {
                Date startDate = CalendarUtil.copyDate(time.getStartDate());
                Date endDate = CalendarUtil.copyDate(time.getEndDate());
                CalendarUtil.addDaysToDate(startDate, 1);
                CalendarUtil.addDaysToDate(endDate, 1);
                //chart.getStore().add(new Site(endDate, Math.random() * 20 + 80, Math.random() * 20 + 40, Math.random() * 20));
                time.setStartDate(startDate);
                time.setEndDate(endDate);
                chart.redrawChart();
            }
        };

        update.scheduleRepeating(1000);

        chart.setAnimated(true);

        panel = new FramedPanel();
        panel.setLayoutData(new MarginData(10));
        panel.setCollapsible(true);
        panel.setHeadingText("Live Chart");
        panel.setPixelSize(620, 500);
        panel.setBodyBorder(true);

        VerticalLayoutContainer layout = new VerticalLayoutContainer();
        panel.add(layout);


        chart.setLayoutData(new VerticalLayoutData(1, 1));
        layout.add(chart);

        panel.addAttachHandler(new AttachEvent.Handler() {
            @Override
            public void onAttachOrDetach(AttachEvent event) {
                if (event.isAttached() == false) {
                    update.cancel();
                }
            }
        });


        return panel;
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
