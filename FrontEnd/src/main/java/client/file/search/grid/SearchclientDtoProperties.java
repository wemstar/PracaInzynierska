package client.file.search.grid;

import client.file.search.service.SearchClientDTO;
import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

import java.util.Date;

/**
 * Created by wemstar on 08.11.14.
 */
interface SearchclientDtoProperties extends PropertyAccess<SearchClientDTO> {

    @Editor.Path("clientNo")
    ModelKeyProvider<SearchClientDTO> key();

    ValueProvider<SearchClientDTO, String> name();

    ValueProvider<SearchClientDTO, String> surname();

    ValueProvider<SearchClientDTO, Date> dateOfBirth();

    ValueProvider<SearchClientDTO, String> pesel();

    ValueProvider<SearchClientDTO, String> clientNo();
}
