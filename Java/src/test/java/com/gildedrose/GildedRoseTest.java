package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final int MAX_QUALITY = 50;

    @Test
    void givenNormalItem_whenUpdated_dateDecreaseAndQualityDrops() {
        Item[] items = new Item[]{new Item("Cake", 2, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Cake", 1, 19);
    }

    @Test
    void givenNormalItem_whenUpdatedAfterSellDate_qualityDropsDouble() {
        Item[] items = new Item[]{new Item("Cake", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Cake", -1, 18);
    }

    @Test
    void givenNormalItem_whenUpdatedWithZeroQuality_qualityRemainsZero() {
        Item[] items = new Item[]{new Item("Cake", -10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Cake", -11, 0);
    }

    @Test
    void givenAgedBrie_whenUpdated_qualityIncreases() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Aged Brie", 4, 21);
    }

    @Test
    void givenAgedBrie_whenUpdatedWithMaxQuality_qualityRemains() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, MAX_QUALITY)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Aged Brie", 4, MAX_QUALITY);
    }

    @Test
    void givenAgedBrie_whenUpdatedWithAfterExpiry_qualityIncreasesDouble() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Aged Brie", -1, 12);
    }

    @Test
    void givenLegendaryItem_whenUpdated_sellInNorQualityDecreases() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Sulfuras, Hand of Ragnaros", 10, 80);
    }

    @Test
    void givenBackstagePassWithMoreThan10Days_whenUpdated_qualityIncreasesBy1() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Backstage passes to a TAFKAL80ETC concert", 10, 21);
    }

    @Test
    void givenBackstagePassWithMoreThan5ButLessThan10Days_whenUpdated_qualityIncreasesBy2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Backstage passes to a TAFKAL80ETC concert", 5, 22);
    }

    @Test
    void givenBackstagePassWithLessThan5Days_whenUpdated_qualityIncreasesBy3() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Backstage passes to a TAFKAL80ETC concert", 3, 23);
    }

    @Test
    void givenBackstagePassAtConcertDate_whenUpdated_qualityDecreasesToZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Backstage passes to a TAFKAL80ETC concert", -1, 0);
    }

    @Test
    void givenBackstagePassWithAlmostMaxQuality_whenUpdated_qualityCapsAtMax() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Backstage passes to a TAFKAL80ETC concert", 0, MAX_QUALITY);
    }

    @Test
    void givenConjuredItem_whenUpdated_qualityDecreasesTwice() {
        Item[] items = new Item[]{new Item("Conjured", 1, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Conjured", 0, 38);
    }

    @Test
    void givenConjuredItemExpired_whenUpdated_qualityDecreasesTwice() {
        Item[] items = new Item[]{new Item("Conjured", -2, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.length);
        testItem(app.items[0], "Conjured", -3, 36);
    }

    private void testItem(Item item, String itemName, int sellIn, int quality) {
        assertEquals(itemName, item.name);
        assertEquals(sellIn, item.sellIn);
        assertEquals(quality, item.quality);
    }
}
