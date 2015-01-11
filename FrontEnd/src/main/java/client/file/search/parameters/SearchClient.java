package client.file.search.parameters;

import client.file.search.grid.SearchResult;
import client.file.search.service.ClientFileDTO;
import client.file.search.service.ClientFileService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.box.AutoProgressMessageBox;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wemstar on 08.11.14.
 */
public class SearchClient extends Composite implements Editor<ClientFileDTO> {

    private static final PersonDriver driver = GWT.create(PersonDriver.class);
    private static final MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
    public final Logger logger = Logger.getLogger("NameOfYourLogger");

    @UiField
    public TextField name;

    @UiField
    public TextField surname;

    @UiField
    public DateField dateOfBirth;

    @UiField
    public TextField pesel;

    @UiField
    public TextField clientNo;

    private SearchResult result;



    public SearchClient() {
        initWidget(uiBinder.createAndBindUi(this));

        driver.initialize(this);
        driver.edit(new ClientFileDTO());
    }

    @UiHandler("search")
    public void search(SelectEvent event) {
        ClientFileDTO person = driver.flush();

        logger.log(Level.WARNING, person.toString());

        final AutoProgressMessageBox box = new AutoProgressMessageBox("Wyszukiwanie", "Wyszukiwanie prosze czekać");
        box.setProgressText("Wyszukiwanie...");
        box.auto();
        box.show();

        ClientFileService.App.getInstance().findClients(person, new AsyncCallback<List<ClientFileDTO>>() {
            public void onFailure(Throwable caught) {
                AlertMessageBox d = new AlertMessageBox("Wyszukiwanie", "Wyszukiwanie zakończone niepowodzeniem" + caught.toString());
                box.hide();
                d.show();
            }

            public void onSuccess(List<ClientFileDTO> results) {
                Info.display("Wyszukiwanie", "Wyszukano " + results.size() + " wyników");
                box.hide();
                result.setResult(results);


            }
        });
    }

    public SearchResult getResult() {
        return result;
    }

    public SearchClient setResult(SearchResult result) {
        this.result = result;
        return this;
    }


    public interface PersonDriver extends SimpleBeanEditorDriver<ClientFileDTO, SearchClient> {
    }


    public interface MyUiBinder extends UiBinder<VerticalPanel, SearchClient> {}


}