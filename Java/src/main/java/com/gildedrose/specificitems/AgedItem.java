package com.gildedrose.specificitems;

import com.gildedrose.Item;

public class AgedItem extends SpecificItem {
    public AgedItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        increaseQuality();
    }

    @Override
    void handleExpiration() {
        increaseQuality();
    }
}
