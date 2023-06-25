package com.gildedrose;

import com.gildedrose.specificitems.SpecificItem;

class GildedRose {
    Item[] items;
    private final ItemFactory itemFactory = new ItemFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            SpecificItem specificItem = itemFactory.createSpecificItem(item);
            specificItem.updateItemQuality();
            specificItem.updateSellIn();
        }
    }
}
