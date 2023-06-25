package com.gildedrose.specificitems;

import com.gildedrose.Item;

public class SpecificItem {

    public static final int MAX_QUALITY = 50;
    protected final Item item;

    public SpecificItem(Item item) {
        this.item = item;
    }

    public void updateItemQuality() {
        decreaseQuality();
    }

    public void updateSellIn() {
        item.sellIn--;

        if (isExpired()) {
            handleExpiration();
        }
    }

    void increaseQuality() {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }

    void handleExpiration() {
        decreaseQuality();
    }
}
