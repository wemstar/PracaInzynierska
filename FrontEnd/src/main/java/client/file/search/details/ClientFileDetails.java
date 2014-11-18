package client.file.search.details;

import client.bra.account.visualization.BraAccountCart;
import client.file.search.service.SearchClientDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;

/**
 * Created by wemstar on 11.11.14.
 */
public class ClientFileDetails extends Composite implements Editor<SearchClientDTO> {

    private static  ClientFileDetails instance;
    public static String title="Szczegóły";
    public static ClientFileDetails aClientFileDetails()
    {
        if(instance==null)instance= new ClientFileDetails();
        return instance;
    }
    private static final ClientFileDetailsDriver driver = GWT.create(ClientFileDetailsDriver.class);
    private static ClientFileDetailsUiBinder ourUiBinder = GWT.create(ClientFileDetailsUiBinder.class);
    @UiField
    FlowPanel chart;
    BraAccountCart cahrtWidg;

    public ClientFileDetails() {

        if(cahrtWidg==null) {
            initWidget(ourUiBinder.createAndBindUi(this));
            cahrtWidg=new BraAccountCart();
            chart.add(cahrtWidg);
            driver.initialize(this);
            driver.edit(new SearchClientDTO());
        }
    }

    interface ClientFileDetailsUiBinder extends UiBinder<HorizontalLayoutContainer, ClientFileDetails> {
    }

    public interface ClientFileDetailsDriver extends SimpleBeanEditorDriver<SearchClientDTO, ClientFileDetails> {
    }
}