package client;

import client.file.search.grid.SearchResult;
import client.file.search.values.SearchClient;
import client.images.Images;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.ButtonCell.IconAlign;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.ButtonGroup;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

/**
 * Created by wemstar on 04.09.14.
 */
class MainModule implements IsWidget, EntryPoint {

    private FlowLayoutContainer con;
    private SamplePanel panel;

    public Widget asWidget() {
        if (con == null) {
            con = new FlowLayoutContainer();
            con.getScrollSupport().setScrollMode(ScrollMode.AUTO);

            con.add(createMulti(), new MarginData(10));

        }

        return con;
    }

    private ContentPanel createMulti() {
        panel = new SamplePanel();
        panel.setHeadingText("Multi Columns");


        panel.getToolBar().add(clientFileNav());
        panel.getToolBar().add(brocarageAccountNav());
        panel.getToolBar().add(instrumentNav());
        panel.getToolBar().add(ordersNav());


        return panel;
    }

    private ButtonGroup clientFileNav() {
        ButtonGroup group = new ButtonGroup();
        group.setHeadingText("Kartoteka klienta");

        FlexTable table = new FlexTable();
        group.add(table);

        TextButton btn = new TextButton("Szukaj");
        btn.setIcon(Images.INSTANCE.search32());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                HorizontalLayoutContainer con = new HorizontalLayoutContainer();
                con.add(new SearchClient(), new HorizontalLayoutContainer.HorizontalLayoutData(0.5, -1));
                con.add(new SearchResult(), new HorizontalLayoutContainer.HorizontalLayoutData(0.5, -1));

                panel.addTab(con);
            }
        });

        table.setWidget(0, 0, btn);

        btn = new TextButton("Szczegóły");
        btn.setIcon(Images.INSTANCE.details32());
        btn.setIconAlign(IconAlign.TOP);
        table.setWidget(0, 1, btn);

        btn = new TextButton("To do");
        table.setWidget(1, 0, btn);
        // //
        btn = new TextButton("To Do");
        table.setWidget(1, 1, btn);
        return group;
    }

    private ButtonGroup brocarageAccountNav() {
        ButtonGroup group = new ButtonGroup();
        group.setHeadingText("Rachunek");


        FlexTable table = new FlexTable();
        group.add(table);

        TextButton btn = new TextButton("Rachunek Brokerski");
        btn.setIcon(Images.INSTANCE.account32());
        btn.setIconAlign(IconAlign.TOP);
        table.setWidget(0, 0, btn);

        btn = new TextButton("Stan rachunku");
        btn.setIcon(Images.INSTANCE.state32());
        btn.setIconAlign(IconAlign.TOP);
        table.setWidget(0, 1, btn);

        btn = new TextButton("To do");
        table.setWidget(1, 0, btn);
        // //
        btn = new TextButton("To do");
        table.setWidget(1, 1, btn);
        return group;
    }

    private ButtonGroup instrumentNav() {
        ButtonGroup group = new ButtonGroup();
        group.setHeadingText("Instrumenty");

        FlexTable table = new FlexTable();
        group.add(table);
        return group;
    }

    private ButtonGroup ordersNav() {
        ButtonGroup group = new ButtonGroup();
        group.setHeadingText("Zlecenia");

        FlexTable table = new FlexTable();
        group.add(table);
        return group;
    }

    private void cleanCells(Element elem) {
        NodeList<Element> tds = elem.<XElement>cast().select("td");
        for (int i = 0; i < tds.getLength(); i++) {
            Element td = tds.getItem(i);

            if (!td.hasChildNodes() && td.getClassName().equals("")) {
                td.removeFromParent();
            }
        }
    }

    public void onModuleLoad() {
        RootPanel.get().add(asWidget());
    }

    class SamplePanel extends ContentPanel {

        private final VerticalLayoutContainer con = new VerticalLayoutContainer();

        private final ToolBar toolBar = new ToolBar();
        private final TabPanel advanced;
        private int index;

        public SamplePanel() {

            toolBar.setSpacing(2);

            con.add(toolBar, new VerticalLayoutData(1, -1));


            advanced = new TabPanel();
            con.add(advanced, new VerticalLayoutData(1, 600));
            add(con);


        }

        public ToolBar getToolBar() {
            return toolBar;
        }

        private void addTab(Widget composite) {
            advanced.add(composite, new TabItemConfig("New Tab " + ++index, index != 1));
        }
    }


}
