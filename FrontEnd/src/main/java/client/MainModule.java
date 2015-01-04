package client;

import client.bra.account.service.BraAccountDTO;
import client.events.*;
import client.file.search.details.ClientFileDetails;
import client.file.search.service.ClientFileDTO;
import client.file.search.service.ClientFileService;
import client.images.Images;
import client.instrument.list.composite.InstrumentListComposite;
import client.instrument.order.NewOrder;
import client.instrument.order.list.OrderList;
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
import com.sencha.gxt.widget.core.client.*;
import com.sencha.gxt.widget.core.client.button.ButtonGroup;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

import static client.Windows.anBraAccountInstrumentListPanel;
import static client.Windows.anInstrumentListPanel;

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
                    panel.setBraAccount(braContext.getBraAccNo());
                    Info.display("Kontekst Rachunku", event.getBraAccount().getBraAccNo());
                }
            });
            EVENT_BUS.addHandler(ClientContextChange.TYPE, new ClientContextChangeHandler() {
                @Override
                public void onClientContextChange(ClientContextChange event) {
                    context = event.getClientDetails();
                    panel.setClientName(context.getName() + " " + context.getSurname());
                    Info.display("Kontekst Klienta", event.getClientDetails().getName());
                    if (context.getAccounts().size() > 0)
                        EVENT_BUS.fireEvent(new BraAccountContextChange(context.getAccounts().get(0)));
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
        btn.setIcon(Images.INSTANCE.search());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {


                panel.addTab(Windows.aSearchPanel(), "Szukaj");
            }
        });

        table.setWidget(0, 0, btn);

        btn = new TextButton(ClientFileDetails.title);
        btn.setIcon(Images.INSTANCE.clientFile());
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
        btn.setIcon(Images.INSTANCE.addClientFile());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {

                panel.addTab(Windows.aNewClientFilePanel(), "Nowa Kartoteka");
            }
        });
        table.setWidget(0, 2, btn);
        return group;
    }

    private ButtonGroup brocarageAccountNav() {
        ButtonGroup group = new ButtonGroup();
        group.setHeadingText("Rachunek");

        FlexTable table = new FlexTable();
        group.add(table);

        TextButton btn = new TextButton("Rachunek Brokerski");
        btn.setIcon(Images.INSTANCE.braAccount());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                Info.display("Rachunek Brokerski", "Funkcjonalnośc w przgotowaniu");


            }
        });
        table.setWidget(0, 0, btn);

        btn = new TextButton("Lista Instrumentów na rachunku");
        btn.setIcon(Images.INSTANCE.instrumentList());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                InstrumentListComposite composite = anBraAccountInstrumentListPanel();
                panel.addTab(composite, "Lista Instrumentów na rachunku");
                composite.setBraContext(braContext);


            }
        });
        table.setWidget(0, 1, btn);
        return group;
    }

    private ButtonGroup instrumentNav() {
        ButtonGroup group = new ButtonGroup();
        group.setHeadingText("Instrumenty");

        FlexTable table = new FlexTable();

        TextButton btn = new TextButton("Lista Instrumentów");
        btn.setIcon(Images.INSTANCE.wallet());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                InstrumentListComposite composite = anInstrumentListPanel();
                panel.addTab(composite, "Lista Instrumentów");
                composite.getForAllAccount();



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
        TextButton btn = new TextButton("Nowe Zlecenie");
        btn.setIcon(Images.INSTANCE.newOrder());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                NewOrder panle = Windows.aNewOrderPanle();
                panle.setBraAccount(braContext);
                panel.addTab(panle, "Nowe Zlecenie");
            }
        });
        table.setWidget(0, 1, btn);

        btn = new TextButton("Lista Zleceń");
        btn.setIcon(Images.INSTANCE.orderList());
        btn.setIconAlign(IconAlign.TOP);
        btn.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                OrderList panle = Windows.aNewOrderListPanel();
                panle.setClientFile(context);
                panel.addTab(panle, "Lista Zleceń");
            }
        });
        table.setWidget(0, 2, btn);


        group.add(table);
        return group;
    }


    public void onModuleLoad() {

        RootPanel.get().add(asWidget());
        checkLogin();
    }

    private void checkLogin() {
        final Dialog complex = new Dialog();
        complex.setBodyBorder(false);
        complex.setHeadingText("Login");
        complex.setWidth(200);
        complex.setHeight(225);
        complex.setModal(true);
        complex.setClosable(false);
        complex.setPredefinedButtons(Dialog.PredefinedButton.OK);


        VerticalLayoutContainer layout = new VerticalLayoutContainer();
        final TextField login = new TextField();
        login.setAllowBlank(false);
        login.setEmptyText("Podaj Login");
        layout.add(new FieldLabel(login, "Login"), new VerticalLayoutData(1, -1));
        PasswordField password = new PasswordField();
        layout.add(new FieldLabel(password, "Hasło"), new VerticalLayoutData(1, -1));
        complex.add(layout);
        complex.getButton(Dialog.PredefinedButton.OK).addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                Info.display("Hura", login.getText());
                complex.hide();
            }
        });
        complex.show();
    }

    class SamplePanel extends ContentPanel {

        private final VerticalLayoutContainer con = new VerticalLayoutContainer();
        private final ToolBar toolBar = new ToolBar();
        private final TabPanel advanced;
        private Status clientName = new Status();
        private Status accountNumber = new Status();

        public SamplePanel() {

            toolBar.setSpacing(2);
            //contextBar();
            con.add(toolBar, new VerticalLayoutData(1, -1));

            advanced = new TabPanel();
            con.add(advanced, new VerticalLayoutData(1, 600));
            add(con);
        }

        public void contextBar() {
            HorizontalLayoutContainer container = new HorizontalLayoutContainer();
            clientName = new Status(GWT.<Status.StatusAppearance>create(Status.BoxStatusAppearance.class));
            accountNumber = new Status(GWT.<Status.StatusAppearance>create(Status.BoxStatusAppearance.class));
            clientName.setWidth(100);
            accountNumber.setWidth(100);
            container.add(clientName, new HorizontalLayoutContainer.HorizontalLayoutData(100, -1));
            container.add(accountNumber, new HorizontalLayoutContainer.HorizontalLayoutData(100, -1));
            ContentPanel conPanel = new ContentPanel();
            conPanel.add(clientName);
            conPanel.add(accountNumber);
            con.add(conPanel, new VerticalLayoutData(1, 105));


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

        public void setClientName(String clientNameStr) {
            clientName.setText(clientNameStr);
        }

        public void setBraAccount(String braAccount) {
            accountNumber.setText(braAccount);
        }
    }
}