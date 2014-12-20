package client.constraint;

/**
 * Created by wemstar on 01.12.14.
 */
public class DictionaryConstraint {

    public static EnumCombo[] side = new EnumCombo[]{new EnumCombo("SELL", "Sprzedaż"), new EnumCombo("BUY", "Kupno")};
    public static EnumCombo[] ordersType = new EnumCombo[]{new EnumCombo("Limit", "Z limitem"), new EnumCombo("PKC"), new EnumCombo("PCR"), new EnumCombo("PEG"), new EnumCombo("StopLimit"), new EnumCombo("StopLoss")};
}
