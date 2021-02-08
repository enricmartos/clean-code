package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseADefaultItemRefactoredTest {

	private static final int NOT_EXPIRED_SELLIN = 15;
	private static final int DEFAULT_QUALITY = 3;
	private static final String DEFAULT_ITEM = "DEFAULT_ITEM";

	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 1 when the item is not expired
	 * and sell in should decrease by 1.
	 * 
	 */
	@Test
	public void unexpiredDefaultItem_qualityDecreasesBy1() {
		// GIVEN
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);

		// THEN
		app.updateQuality();

		// THEN
		Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 1);

		assertItem(app.items[0], expected);
	}

	private void assertItem(Item actual, Item expected) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.sellIn, actual.quality);
	}

	private GildedRose createGildedRoseWithOneItem(String defaultItem, int notExpiredSellin, int defaultQuality) {
		Item item = new Item(defaultItem, notExpiredSellin, defaultQuality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}

	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
	 * 
	 */
	@Test
	public void testUpdateQualityForExpiredItem() {
		GildedRose app = createGildedRoseWithOneItem("DEFAULT_ITEM", -1, 3);
		app.updateQuality();
		assertEquals("DEFAULT_ITEM", app.items[0].name);
		assertEquals(-2, app.items[0].sellIn);
		assertEquals(1, app.items[0].quality);
	}
}