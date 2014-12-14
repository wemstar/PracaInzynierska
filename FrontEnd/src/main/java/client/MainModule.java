package client;

import client.bra.account.service.BraAccountDTO;
import client.events.*;
import client.file.search.details.ClientFileDetails;
import client.file.search.service.ClientFileDTO;
import client.file.search.service.ClientFileService;
import client.images.Images;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.ButtonCell.IconAlign;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.ButtonGroup;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

/**
 * Created by wemstar on 04.09.14.
 */
public class MainModule implements IsWidget, EntryPoint {


    public static EventBus EVENT_BUS = GWT.create(SimpleEventBus.class);
    public ClientFileDTO context;
    public BraAccountDTO braContext;
    private FlowLayoutContainer con;
    private SamplePanel panel;

    public Widget asWidget() {
        if (con == null) {
            con = new FlowLayoutContainer();
            con.getScrollSupport().setScrollMode(ScrollMode.AUTO);

            con.add(createMulti(), new MarginData(10));
            EVENT_BUS.addHandler(BraAccountContextChange.TYPE, new BraAccountContextChangeHandler() {
                @Override
                public void onBraAccountContextChangeHandler(BraAccountContextChange event) {
                    braContext = event.getBraAccount();
                    Info.display("Kontekst Rachunku", event.getBraAccount().getBraAccNo());
                }
            });
            EVENT_BUS.addHandler(ClientContextChange.TYPE, new ClientContextChangeHandler() {
                @Override
                public void onClientContextChange(ClientContextChange event) {
                    context = event.getClientDetails();
                    Info.display("Kontekst Klienta", event.getClientDetails().getName());
                }
            });
            EVENT_BUS.addHandler(ReloadContext.TYPE, new ReloadContextHandler() {
                @Override
                public void onContextReload(ReloadContext reloadContext) {
                    ClientFileService.App.getInstance().findClient(Integer.parseInt(context.getClientNo()), new AsyncCallback<ClientFileDTO>() {
                        @Override
                        public void onFailure(Throwable caught) {

                        }

                        @Override
                        public void onSuccess(ClientFileDTO result) {
                            context = result;
                            EVENT_BUS.fireEvent(new ClientContextChange(result));

                        }
                    });
                }
            });
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


                panel.addTab(Windows.aSearchPanel(), "Szukaj");
            }
        });

        table.setWidget(0, 0, btn);

        btn = new TextButton(ClientFileDetails.title);
        btn.setIcon(Images.INSTANCE.details32());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                ClientFileDetails details = Windows.aClientFileDetailsPanel();
                details.setClientFile(context);

                panel.addTab(details, ClientFileDetails.title);
            }
        });
        table.setWidget(0, 1, btn);

        btn = new TextButton("Nowa Kartoteka");
        btn.setIcon(Images.INSTANCE.details32());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {

                panel.addTab(Windows.aNewClientFilePanel(), "Nowa Kartoteka");
            }
        });
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

        TextButton btn = new TextButton("Nowe Zlecenie");
        btn.setIcon(Images.INSTANCE.details32());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {

                panel.addTab(Windows.aNewOrderPanle(), "Nowe Zlecenie");
            }
        });
        table.setWidget(0, 1, btn);

        btn = new TextButton("Lista Instrumentów");
        btn.setIcon(Images.INSTANCE.account32());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {

                panel.addTab(Windows.aInstrumentListPanle(), "Lista Instrumentów");
            }
        });
        table.setWidget(0, 2, btn);

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

        private void addTab(Widget composite, String title) {
            TabItemConfig config = advanced.getConfig(composite);
            if (config == null)
                advanced.add(composite, new TabItemConfig(title, true));
            advanced.setActiveWidget(composite);
        }
    }
}