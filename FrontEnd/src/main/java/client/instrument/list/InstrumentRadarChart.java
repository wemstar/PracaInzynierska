package client.instrument.list;

/**
 * Created by wemstar on 04.12.14.
 */
public class InstrumentRadarChart /*extends Composite*/ {

    /*public interface DataPropertyAccess extends PropertyAccess<InstrumentDTO> {

        ValueProvider<InstrumentDTO,Double> data();
        ValueProvider<InstrumentDTO, String> name();

        @Path("id")
        ModelKeyProvider<InstrumentDTO> nameKey();


    }

    private static final DataPropertyAccess dataAccess = GWT.create(DataPropertyAccess.class);
    private Color[] colors = {new RGB("#6d9824"), new RGB("#87146e"), new RGB("#2a9196")};
    private Color[] currentColor = {Color.NONE, Color.NONE, Color.NONE};
    private double strokeWidth = 2;
    private double opacity = 1;
    private FramedPanel panel;
    final ListStore<InstrumentDTO> store = new ListStore<InstrumentDTO>(dataAccess.nameKey());
    final Chart<InstrumentDTO> chart = new Chart<InstrumentDTO>(600, 400);

    public void setData(List<InstrumentDTO> data)
    {
        store.clear();
        store.addAll(data);
        chart.redrawChart();
    }

    public Widget asWidget() {
        if (panel == null) {




            chart.setStore(store);
            chart.setDefaultInsets(20);

            RadialAxis<InstrumentDTO, String> axis = new RadialAxis<InstrumentDTO, String>();
            axis.setCategoryField(dataAccess.name());
            axis.setDisplayGrid(true);
            chart.addAxis(axis);

            final RadarSeries<InstrumentDTO> radar = new RadarSeries<InstrumentDTO>();
            radar.setYField(dataAccess.data());
            radar.setStroke(colors[0]);
            radar.setShowMarkers(true);
            Sprite marker = Primitives.circle(0, 0, 4);
            marker.setFill(colors[0]);
            radar.setMarkerConfig(marker);
            radar.setLineRenderer(createRenderer(0));
            chart.addSeries(radar);


            chart.setAnimated(true);
            radar.setShowMarkers(false);






            panel = new FramedPanel();
            panel.setLayoutData(new MarginData(10));
            panel.setCollapsible(true);
            panel.setHeadingText("Radar Chart");
            panel.setPixelSize(620, 500);
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
        }

        return panel;
    }

    public SeriesRenderer<InstrumentDTO> createRenderer(final int seriesIndex) {
        return new SeriesRenderer<InstrumentDTO>() {
            @Override
            public void spriteRenderer(Sprite sprite, int index, ListStore<InstrumentDTO> store) {
                sprite.setStrokeWidth(strokeWidth);
                sprite.setOpacity(opacity);
                sprite.setFill(currentColor[seriesIndex]);
                sprite.redraw();
            }
        };
    }

    public InstrumentRadarChart() {
        initWidget(asWidget());
    }*/
}
