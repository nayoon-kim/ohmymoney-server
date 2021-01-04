package com.najinji.ohmymoneyserver.domain.place;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    RESTAURANT("CATEGORY_RESTAURANT", "맛집"),
    LANDMARK("CATEGORY_LANDMARK", "명소"),
    SHOPPINGMALL("CATEGORY_SHOPPINGMALL", "쇼핑");

    private final String key;
    private final String title;
}
