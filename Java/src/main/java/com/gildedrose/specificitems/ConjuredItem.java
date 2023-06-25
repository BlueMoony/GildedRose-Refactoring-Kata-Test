package com.gildedrose.specificitems;

import com.gildedrose.Item;

import java.util.stream.IntStream;

public class ConjuredItem extends SpecificItem {

    private final int degradationMultiplier = 2;

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateItemQuality() {
        IntStream.rangeClosed(1, degradationMultiplier)
            .forEach(i -> decreaseQuality());
    }

    @Override
    void handleExpiration() {
        IntStream.rangeClosed(1, degradationMultiplier)
            .forEach(i -> decreaseQuality());
    }
}
