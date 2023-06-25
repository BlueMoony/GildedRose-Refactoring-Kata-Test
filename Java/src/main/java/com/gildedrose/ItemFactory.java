package com.gildedrose;

import com.gildedrose.specificitems.*;

public class ItemFactory {
    public ItemFactory() {
    }

    public SpecificItem createSpecificItem(Item item) {
        String itemName = item.name;

        switch (itemName) {
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryItem(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstageItem(item);
            case "Aged Brie":
                return new AgedItem(item);
            case "Conjured":
                return new ConjuredItem(item);
            default:
                return new SpecificItem(item);
        }
    }
}
