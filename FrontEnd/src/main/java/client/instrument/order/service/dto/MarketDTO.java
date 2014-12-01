package client.instrument.order.service.dto;

import java.io.Serializable;

/**
 * Created by wemstar on 30.11.14.
 */
public class MarketDTO implements Serializable {
    String code;
    String name;
    String type;

    @Override
    public String toString() {
        return "MerketsDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
