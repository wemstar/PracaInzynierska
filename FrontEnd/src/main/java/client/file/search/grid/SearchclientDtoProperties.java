package client.file.search.grid;

import client.file.search.SearchclientDto;
import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

import java.util.Date;

/**
 * Created by wemstar on 08.11.14.
 */
interface SearchclientDtoProperties extends PropertyAccess<SearchclientDto> {

    @Editor.Path("clientNo")
    ModelKeyProvider<SearchclientDto> key();

    @Editor.Path("clientNo")
    LabelProvider<SearchclientDto> nameLabel();

    ValueProvider<SearchclientDto, String> name();

    ValueProvider<SearchclientDto, String> surname();

    ValueProvider<SearchclientDto, Date> dateOfBirth();

    ValueProvider<SearchclientDto, String> pesel();

    ValueProvider<SearchclientDto, String> clientNo();
}
