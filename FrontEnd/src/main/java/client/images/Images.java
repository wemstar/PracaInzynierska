package client.images;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Created by wemstar on 08.11.14.
 */
public interface Images extends ClientBundle {

    public Images INSTANCE = GWT.create(Images.class);

    @Source("icons/search.png")
    ImageResource search();

    @Source("icons/addClientFile.png")
    ImageResource addClientFile();

    @Source("icons/instrumentList.png")
    ImageResource instrumentList();

    @Source("icons/orderList.png")
    ImageResource orderList();

    @Source("icons/braAccount.png")
    ImageResource braAccount();

    @Source("icons/clientFile.png")
    ImageResource clientFile();

    @Source("icons/newOrder.png")
    ImageResource newOrder();

    @Source("icons/wallet.png")
    ImageResource wallet();
}
