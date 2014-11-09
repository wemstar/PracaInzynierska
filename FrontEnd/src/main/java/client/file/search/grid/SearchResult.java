package client.file.search.grid;

import client.file.search.service.SearchClientDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wemstar on 08.11.14.
 */
public class SearchResult extends Composite {
    private static final SearchclientDtoProperties gridProperties = GWT.create(SearchclientDtoProperties.class);
    private static final MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
    @UiField(provided = true)

    public ListStore<SearchClientDTO> listStore;
    @UiField

    public GridView<SearchClientDTO> gridView;
    @UiField
    public Grid<SearchClientDTO> grid;
    @UiField(provided = true)

    ColumnModel<SearchClientDTO> columnModel;
    private ContentPanel widget;

    public SearchResult() {
        if (widget == null) {
            columnModel = initColumModel();
            listStore = initListStore();

            initWidget(uiBinder.createAndBindUi(this));


            //gridView.setAutoExpandColumn(columnModel.getColumn(0));
        }


    }

    private ColumnModel<SearchClientDTO> initColumModel() {
        ColumnConfig<SearchClientDTO, String> nameCol = new ColumnConfig<SearchClientDTO, String>(gridProperties.name(), 150, "Imię");
        ColumnConfig<SearchClientDTO, String> surnameCol = new ColumnConfig<SearchClientDTO, String>(gridProperties.surname(), 100, "Nazwisko");
        ColumnConfig<SearchClientDTO, String> peselCol = new ColumnConfig<SearchClientDTO, String>(gridProperties.pesel(), 100, "Pesel");
        ColumnConfig<SearchClientDTO, Date> dateCol = new ColumnConfig<SearchClientDTO, Date>(gridProperties.dateOfBirth(), 100, "Data urodzenia");
        ColumnConfig<SearchClientDTO, String> noCol = new ColumnConfig<SearchClientDTO, String>(gridProperties.clientNo(), 100, "Numer klienta");

        List<ColumnConfig<SearchClientDTO, ?>> columns = new ArrayList<ColumnConfig<SearchClientDTO, ?>>();
        columns.add(nameCol);
        columns.add(surnameCol);
        columns.add(peselCol);
        columns.add(dateCol);
        columns.add(noCol);


        return new ColumnModel<SearchClientDTO>(columns);
    }

    private ListStore<SearchClientDTO> initListStore() {


        return new ListStore<SearchClientDTO>(gridProperties.key());
    }

    public interface MyUiBinder extends UiBinder<ContentPanel, SearchResult> {
    }


}