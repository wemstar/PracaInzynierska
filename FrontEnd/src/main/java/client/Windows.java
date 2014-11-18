package client;

import client.file.search.details.ClientFileDetails;
import client.file.search.grid.SearchResult;
import client.file.search.parameters.SearchClient;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;

/**
 * Created by wemstar on 18.11.14.
 */
public class Windows {

    private static ClientFileDetails instance;
    public static ClientFileDetails aClientFileDetailsPanel()
    {
        if(instance==null)instance= new ClientFileDetails();
        return instance;
    }

    public static HorizontalLayoutContainer aSearchPanel()
    {
        HorizontalLayoutContainer con = new HorizontalLayoutContainer();
        SearchResult result = new SearchResult();
        con.add(new SearchClient().setResult(result), new HorizontalLayoutContainer.HorizontalLayoutData(0.5, 1));
        con.add(result, new HorizontalLayoutContainer.HorizontalLayoutData(0.5, 1));
        return con;
    }
}
