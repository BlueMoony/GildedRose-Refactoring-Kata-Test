package com.gildedrose.specificitems;

import com.gildedrose.Item;

public class LegendaryItem extends SpecificItem {
    public LegendaryItem(Item item) {
        super(item);
        item.quality = 80;
    }

    @Override
    public void updateItemQuality() {
        // Do nothing
    }

    @Override
    public void updateSellIn() {
        // Do nothing
    }

    @Override
    void handleExpiration() {
        // Do nothing
    }
}
