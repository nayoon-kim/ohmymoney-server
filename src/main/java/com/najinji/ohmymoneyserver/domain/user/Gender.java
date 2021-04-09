package com.najinji.ohmymoneyserver.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    FEMALE("female"),
    MALE("male"),
    OTHER("other"),
    UNKNOWN("N/A");

    private final String value;

    public String getValue() {
        return value;
    }
    public static Gender getGender(String value) {
        for(Gender gender: values()) {
            if (gender.value.equalsIgnoreCase(value)) {
                return gender;
            }
        }
        return UNKNOWN;
    }
}
