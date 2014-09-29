package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.PlainTabPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.info.Info;
/**
 * Created by wemstar on 04.09.14.
 */
public class MainModule implements IsWidget, EntryPoint {

    private VerticalPanel vp;

    public Widget asWidget() {
        if (vp == null) {
            vp = new VerticalPanel();
            vp.setSpacing(10);

            String txt = "";
            SelectionHandler<Widget> handler = new SelectionHandler<Widget>() {
                @Override
                public void onSelection(SelectionEvent<Widget> event) {
                    TabPanel panel = (TabPanel) event.getSource();
                    Widget w = event.getSelectedItem();
                    TabItemConfig config = panel.getConfig(w);
                    Info.display("Message", "'" + config.getText() + "' Selected");
                }
            };

            TabPanel folder = new TabPanel();
            folder.addSelectionHandler(handler);
            folder.setWidth(450);

            HTML shortText = new HTML(txt);

            folder.add(shortText, "Short Text");

            HTML longText = new HTML(txt + "<br><br>" + txt);

            folder.add(longText, "Long Text");

            final PlainTabPanel panel = new PlainTabPanel();
            panel.setPixelSize(450, 250);
            panel.addSelectionHandler(handler);

            Label normal = new Label("Just a plain old tab");

            panel.add(normal, "Normal");

            Label iconTab = new Label("Just a plain old tab with an icon");


            TabItemConfig config = new TabItemConfig("Icon Tab");
            panel.add(iconTab, config);

            Label disabled = new Label("This tab should be disabled");

            config = new TabItemConfig("Disabled");
            config.setEnabled(false);
            panel.add(disabled, config);

            vp.add(folder);
            vp.add(panel);
        }

        return vp;
    }

    public void onModuleLoad() {
        RootPanel.get().add(asWidget());
    }

}
