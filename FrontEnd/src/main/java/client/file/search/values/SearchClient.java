package client.file.search.values;

import client.file.search.SearchclientDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.TextField;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wemstar on 08.11.14.
 */
public class SearchClient extends Composite implements Editor<SearchclientDto> {

    private static final PersonDriver driver = GWT.create(PersonDriver.class);
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
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
    Logger logger = Logger.getLogger("NameOfYourLogger");
    public SearchClient() {

        initWidget(uiBinder.createAndBindUi(this));
        driver.initialize(this);
        driver.edit(new SearchclientDto());
    }

    @UiHandler("search")
    public void search(SelectEvent event) {
        SearchclientDto person = driver.flush();
        System.out.println(person);
        logger.log(Level.WARNING, person.toString());
    }


    interface PersonDriver extends SimpleBeanEditorDriver<SearchclientDto, SearchClient> {
    }


    interface MyUiBinder extends UiBinder<VerticalPanel, SearchClient> {
    }


}