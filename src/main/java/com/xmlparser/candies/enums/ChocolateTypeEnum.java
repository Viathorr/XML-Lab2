package com.xmlparser.candies.enums;

public enum ChocolateTypeEnum {

    WHITE("White"),
    MILK("Milk"),
    DARK("Dark");

    private final String value;

    ChocolateTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChocolateTypeEnum fromValue(String v) {
        for (ChocolateTypeEnum c: ChocolateTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
