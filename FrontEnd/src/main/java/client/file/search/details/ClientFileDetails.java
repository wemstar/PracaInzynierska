package client.file.search.details;

import client.MainModule;
import client.bra.account.visualization.BraAccountCart;
import client.file.search.service.SearchClientDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Created by wemstar on 11.11.14.
 */
public class ClientFileDetails extends Composite implements Editor<SearchClientDTO> {


    public static String title="Szczegóły";

    private static final ClientFileDetailsDriver driver = GWT.create(ClientFileDetailsDriver.class);
    private static ClientFileDetailsUiBinder ourUiBinder = GWT.create(ClientFileDetailsUiBinder.class);
    @UiField
    FlowPanel chart;

    @UiField
    public TextField name;
    @UiField
    public TextField surname;
    @UiField
    public DateField dateOfBirth;
    @UiField
    public TextField pesel;


    BraAccountCart cahrtWidg;

    public ClientFileDetails() {

        if(cahrtWidg==null) {
            initWidget(ourUiBinder.createAndBindUi(this));
            cahrtWidg=new BraAccountCart(MainModule.context.getBraAccount());
            chart.add(cahrtWidg);
            driver.initialize(this);
            driver.edit(MainModule.context);

            disableWidgets(new Component[]{name, surname, dateOfBirth, pesel},false);
        }
    }

    private void disableWidgets(Component[] widgets,boolean mode) {
        for(Component widg:widgets)
            widg.setEnabled(mode);
    }

    interface ClientFileDetailsUiBinder extends UiBinder<HorizontalLayoutContainer, ClientFileDetails> {
    }

    public interface ClientFileDetailsDriver extends SimpleBeanEditorDriver<SearchClientDTO, ClientFileDetails> {
    }
}