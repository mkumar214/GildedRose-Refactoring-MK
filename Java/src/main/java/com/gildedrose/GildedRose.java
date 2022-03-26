package com.gildedrose;

class GildedRose {
    Item[] items;
    private static final int LOWEST_QUALITY_VALUE_POSSIBLE = 0;
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
    	 for (Item item : items) {
             customisedItem(item).updateState();
             if (hasReachedLowestQualityValue(item)) {
                 item.quality = LOWEST_QUALITY_VALUE_POSSIBLE;
             } else if (hasReachedHighestQualityValue(item)) {
                 item.quality = QualityValues.highestValuePossible(item);
             }
         }
    }
    
    
    private CustomisedItem customisedItem(Item item) {
        return new CustomisedItemFactory(item).customiseItem(item);
    }

    private boolean hasReachedLowestQualityValue(Item item) {
        return item.quality < LOWEST_QUALITY_VALUE_POSSIBLE;
    }

    private boolean hasReachedHighestQualityValue(Item item) {
        return item.quality > QualityValues.highestValuePossible(item);
    }
}