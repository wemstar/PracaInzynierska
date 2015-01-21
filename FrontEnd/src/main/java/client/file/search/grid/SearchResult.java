package client.file.search.grid;

import client.MainModule;
import client.events.ClientContextChange;
import client.file.search.service.ClientFileDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Wyniki wyszukiwania
 */
public class SearchResult extends Composite {

    private static final SearchclientDtoProperties gridProperties = GWT.create(SearchclientDtoProperties.class);
    private static final MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField(provided = true)
    public ListStore<ClientFileDTO> listStore;

    @UiField
    public GridView<ClientFileDTO> gridView;

    @UiField
    public Grid<ClientFileDTO> grid;

    @UiField(provided = true)
    ColumnModel<ClientFileDTO> columnModel;


    public SearchResult() {
        if (columnModel == null) {
            columnModel = initColumModel();
            listStore = initListStore();

            initWidget(uiBinder.createAndBindUi(this));
        }
        grid.getSelectionModel().addSelectionChangedHandler(new SelectionChangedEvent.SelectionChangedHandler<ClientFileDTO>() {
            @Override
            public void onSelectionChanged(SelectionChangedEvent<ClientFileDTO> event) {
                MainModule.EVENT_BUS.fireEvent(new ClientContextChange(event.getSelection().get(0)));
            }
        });
    }

    public void setResult(List<ClientFileDTO> result) {
        listStore.clear();
        listStore.addAll(result);
    }

    private ColumnModel<ClientFileDTO> initColumModel() {
        ColumnConfig<ClientFileDTO, String> nameCol = new ColumnConfig<ClientFileDTO, String>(gridProperties.name(), 150, "Imię");
        ColumnConfig<ClientFileDTO, String> surnameCol = new ColumnConfig<ClientFileDTO, String>(gridProperties.surname(), 100, "Nazwisko");
        ColumnConfig<ClientFileDTO, String> peselCol = new ColumnConfig<ClientFileDTO, String>(gridProperties.pesel(), 100, "Pesel");
        ColumnConfig<ClientFileDTO, Date> dateCol = new ColumnConfig<ClientFileDTO, Date>(gridProperties.dateOfBirth(), 100, "Data urodzenia");
        ColumnConfig<ClientFileDTO, String> noCol = new ColumnConfig<ClientFileDTO, String>(gridProperties.clientNo(), 100, "Numer klienta");

        List<ColumnConfig<ClientFileDTO, ?>> columns = new ArrayList<ColumnConfig<ClientFileDTO, ?>>();
        columns.add(nameCol);
        columns.add(surnameCol);
        columns.add(peselCol);
        columns.add(dateCol);
        columns.add(noCol);

        return new ColumnModel<ClientFileDTO>(columns);
    }

    private ListStore<ClientFileDTO> initListStore() {

        return new ListStore<ClientFileDTO>(gridProperties.key());
    }

    public interface MyUiBinder extends UiBinder<ContentPanel, SearchResult> {
    }

    interface SearchclientDtoProperties extends PropertyAccess<ClientFileDTO> {

        @Editor.Path("clientNo")
        ModelKeyProvider<ClientFileDTO> key();

        ValueProvider<ClientFileDTO, String> name();

        ValueProvider<ClientFileDTO, String> surname();

        ValueProvider<ClientFileDTO, Date> dateOfBirth();

        ValueProvider<ClientFileDTO, String> pesel();

        ValueProvider<ClientFileDTO, String> clientNo();
    }


}