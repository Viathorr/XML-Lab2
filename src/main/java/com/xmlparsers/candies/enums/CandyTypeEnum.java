package com.xmlparsers.candies.enums;

public enum CandyTypeEnum {

    CARAMEL("Caramel"),
    TOFFEE("Toffee"),
    CHOCOLATE("Chocolate");

    private final String value;

    CandyTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CandyTypeEnum fromValue(String v) {
        for (CandyTypeEnum c: CandyTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
