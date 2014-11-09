package client.file.search.grid;

import client.file.search.SearchclientDto;
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

    ColumnModel<SearchclientDto> columnModel;
    @UiField(provided = true)

    ListStore<SearchclientDto> listStore;
    @UiField

    GridView<SearchclientDto> gridView;
    @UiField
    Grid<SearchclientDto> grid;
    private ContentPanel widget;

    public SearchResult() {
        if (widget == null) {
            columnModel = initColumModel();
            listStore = initListStore();

            initWidget(uiBinder.createAndBindUi(this));

            // Auto expand the name column
            gridView.setAutoExpandColumn(columnModel.getColumn(0));
        }


    }

    private ColumnModel<SearchclientDto> initColumModel() {
        ColumnConfig<SearchclientDto, String> nameCol = new ColumnConfig<SearchclientDto, String>(gridProperties.name(), 150, "Imię");
        ColumnConfig<SearchclientDto, String> surnameCol = new ColumnConfig<SearchclientDto, String>(gridProperties.surname(), 100, "Nazwisko");
        ColumnConfig<SearchclientDto, String> peselCol = new ColumnConfig<SearchclientDto, String>(gridProperties.pesel(), 100, "Pesel");
        ColumnConfig<SearchclientDto, Date> dateCol = new ColumnConfig<SearchclientDto, Date>(gridProperties.dateOfBirth(), 100, "Data urodzenia");
        ColumnConfig<SearchclientDto, String> noCol = new ColumnConfig<SearchclientDto, String>(gridProperties.clientNo(), 100, "Numer klienta");

        List<ColumnConfig<SearchclientDto, ?>> columns = new ArrayList<ColumnConfig<SearchclientDto, ?>>();
        columns.add(nameCol);
        columns.add(surnameCol);
        columns.add(peselCol);
        columns.add(dateCol);
        columns.add(noCol);


        return new ColumnModel<SearchclientDto>(columns);
    }

    private ListStore<SearchclientDto> initListStore() {
        //listStore.addAll(TestData.getStocks());
        return new ListStore<SearchclientDto>(gridProperties.key());
    }

    public interface MyUiBinder extends UiBinder<ContentPanel, SearchResult> {
    }


}