package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseADefaultItemRefactoredTest {

	private static final int NOT_EXPIRED_SELLIN = 15;
	private static final int DEFAULT_QUALITY = 3;
	private static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	private static final int EXPIRED_SELLIN = -1;

	@Test
	public void unexpiredDefaultItem_qualityDecreasesBy1() {
		// GIVEN
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);

		// THEN
		app.updateQuality();

		// THEN
		Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 1);

		assertItem(expected, app.items[0]);
	}

	@Test
	public void expiredDefaultItem_qualityDecreasesBy2() {
		// GIVEN
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, EXPIRED_SELLIN, DEFAULT_QUALITY);

		// THEN
		app.updateQuality();

		// THEN
		Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 2);

		assertItem(expected, app.items[0]);
	}

	private GildedRose createGildedRoseWithOneItem(String defaultItem, int notExpiredSellin, int defaultQuality) {
		Item item = new Item(defaultItem, notExpiredSellin, defaultQuality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}

	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

}