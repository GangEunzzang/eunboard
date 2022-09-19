package com.example.eunboard.domain.entity;

import lombok.Getter;

@Getter
public enum Area {
    INDONG("인동", 1), OOK("옥계", 2), GYUNGOON("경운대", 3), DAEGU("대구", 4);

    private String areaName;
    private int areaCode;

    Area(String areaName, int areaCode) {
        this.areaName = areaName;
        this.areaCode = areaCode;
    }
}
