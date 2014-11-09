package client.images;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Created by wemstar on 08.11.14.
 */
public interface Images extends ClientBundle {

    public Images INSTANCE = GWT.create(Images.class);

    @Source("icons/round62.png")
    ImageResource add32();

    @Source("icons/search32.png")
    ImageResource search32();

    @Source("icons/details32.png")
    ImageResource details32();

    @Source("icons/account32.png")
    ImageResource account32();

    @Source("icons/state_account32.png")
    ImageResource state32();
}
