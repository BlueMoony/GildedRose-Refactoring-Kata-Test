package com.gildedrose.specificitems;

import com.gildedrose.Item;

public class BackstageItem extends SpecificItem {
    public BackstageItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        increaseQuality();

        if (item.sellIn < 11) {
            increaseQuality();
        }

        if (item.sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    void handleExpiration() {
        item.quality = 0;
    }
}
