package client.constraint;

/**
 * Created by wemstar on 20.12.14.
 */
public class EnumCombo {

    private String value;
    private String code;

    public EnumCombo(String code) {
        this.code = code;
        this.value = code;

    }

    public EnumCombo() {
    }

    public EnumCombo(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
