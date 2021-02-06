package com.najinji.ohmymoneyserver.domain.place;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    음식("CATEGORY_RESTAURANT", "음식"),
    명소("CATEGORY_LANDMARK", "명소"),
    쇼핑("CATEGORY_SHOPPINGMALL", "쇼핑"),
    카페("CATEGORY_CAFE", "카페");

    private final String key;
    private final String title;

}