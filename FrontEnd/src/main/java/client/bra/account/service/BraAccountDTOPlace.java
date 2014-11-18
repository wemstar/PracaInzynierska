package client.bra.account.service;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by wemstar on 11.11.14.
 */
public class BraAccountDTOPlace extends Place {

    private String token;

    public BraAccountDTOPlace(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BraAccountDTOPlace) {
            return token.equals(((BraAccountDTOPlace) obj).token);
        }
        return false;
    }

    public String getExampleId() {
        return token;
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }

    public static class Tokenizer implements PlaceTokenizer<BraAccountDTOPlace> {

        @Override
        public BraAccountDTOPlace getPlace(String token) {
            return new BraAccountDTOPlace(token);
        }

        @Override
        public String getToken(BraAccountDTOPlace place) {
            return place.getExampleId();
        }
    }
}
