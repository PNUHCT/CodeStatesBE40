package com.codestates;

import java.util.HashMap;
import java.util.Map;

public class CryptoCurrency {
    private String currencyName;
    private String currencyUnit;
    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("BTC", "Bitcoin");
        map.put("ETH", "Ethereum");
        map.put("ADA", "ADA");
        map.put("POT", "Polkadot");
    }
}
