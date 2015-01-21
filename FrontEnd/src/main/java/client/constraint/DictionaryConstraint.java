package client.constraint;

/**
 * Stałe dla ComboBox
 */
public class DictionaryConstraint {

    public static EnumCombo[] side = new EnumCombo[]{new EnumCombo("SELL", "Sprzedaż"), new EnumCombo("BUY", "Kupno")};
    public static EnumCombo[] ordersType = new EnumCombo[]{new EnumCombo("Limit", "Z limitem"), new EnumCombo("PKC"), new EnumCombo("PCR"), new EnumCombo("StopLimit"), new EnumCombo("StopLoss")};
}
