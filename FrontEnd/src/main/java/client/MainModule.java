package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.ButtonCell.ButtonArrowAlign;
import com.sencha.gxt.cell.core.client.ButtonCell.ButtonScale;
import com.sencha.gxt.cell.core.client.ButtonCell.IconAlign;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.core.client.dom.XElement;

import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.ButtonGroup;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuItem;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.google.gwt.user.client.ui.Label;

/**
 * Created by wemstar on 04.09.14.
 */
public class MainModule implements IsWidget, EntryPoint {

    class SamplePanel extends ContentPanel {

        private VerticalLayoutContainer con = new VerticalLayoutContainer();

        private ToolBar toolBar = new ToolBar();
        private TabPanel advanced;

        public SamplePanel() {

            toolBar.setSpacing(2);

            con.add(toolBar, new VerticalLayoutData(1, -1));


            advanced = new TabPanel();
            addTab();
            addTab();
            con.add(advanced, new VerticalLayoutData(1, 1));
            add(con);
        }
        private int index;
        public ToolBar getToolBar() {
            return toolBar;
        }
        private void addTab() {
            Label item = new Label("Tab Body " );
            item.addStyleName("pad-text");
            advanced.add(item, new TabItemConfig("New Tab " + ++index, index != 1));
        }
    }

    private FlowLayoutContainer con;

    public Widget asWidget() {
        if (con == null) {
            con = new FlowLayoutContainer();
            con.getScrollSupport().setScrollMode(ScrollMode.AUTO);

            con.add(createMulti(), new MarginData(10));

        }

        return con;
    }



    private ContentPanel createMulti() {
        SamplePanel panel = new SamplePanel();
        panel.setHeadingText("Multi Columns");

        ButtonGroup group = new ButtonGroup();
        group.setHeadingText("Clipboard");
        panel.getToolBar().add(group);

        FlexTable table = new FlexTable();
        group.add(table);

        TextButton btn = new TextButton("Cool");
        table.setWidget(0, 0, btn);

        btn = new TextButton("Cut");
        Menu menu = new Menu();
        menu.add(new MenuItem("Copy me"));
        btn.setMenu(menu);
        table.setWidget(0, 1, btn);

        btn = new TextButton("Copy");
        table.setWidget(1, 0, btn);
        // //
        btn = new TextButton("Paste");
        table.setWidget(1, 1, btn);

        group = new ButtonGroup();
        group.setHeadingText("Other Bogus Actions");
        panel.getToolBar().add(group);

        table = new FlexTable();
        group.add(table);

        btn = new TextButton("Cool");
        table.setWidget(0, 0, btn);

        btn = new TextButton("Cut");
        menu = new Menu();
        menu.add(new MenuItem("Copy me"));
        btn.setMenu(menu);
        table.setWidget(0, 1, btn);

        btn = new TextButton("Copy");
        table.setWidget(1, 0, btn);
        // //
        btn = new TextButton("Paste");
        table.setWidget(1, 1, btn);

        return panel;
    }



    private void cleanCells(Element elem) {
        NodeList<Element> tds = elem.<XElement> cast().select("td");
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



}
