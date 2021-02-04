package com.housseine.clothes.entity;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {

		Map<String, String> currencies = getAvailableCurrencies();
		for (String country : currencies.keySet()) {
			String currencyCode = currencies.get(country);
			// System.out.println(country + " => " + currencyCode);
		}

		System.out.println(getKey(currencies, "EUR"));

	}

	private static Map<String, String> getAvailableCurrencies() {
		Locale[] locales = Locale.getAvailableLocales();

		// We use TreeMap so that the order of the data in the map sorted
		// based on the country name.
		Map<String, String> currencies = new TreeMap<>();
		for (Locale locale : locales) {
			try {
				currencies.put(locale.getDisplayCountry(), Currency.getInstance(locale).getCurrencyCode());
			} catch (Exception e) {
			}
		}
		return currencies;
	}

	private static String getCountry(String key) {
		return getAvailableCurrencies().get(key);
	}

	public static <K, V> List<String> getKey(Map<K, V> map, V value) {
		List<String> values = new ArrayList<>();
		for (Entry<K, V> entry : map.entrySet()) {
			if (entry.getValue().equals(value)) {
				values.add((String) entry.getKey());

			}
		}
		return values;
	}

}
