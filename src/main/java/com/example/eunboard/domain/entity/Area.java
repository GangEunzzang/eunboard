package com.example.eunboard.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Area {
    INDONG("인동"), OOK("옥계"), GYUNGOON("경운대"), DAEGU("대구");

    final private String name;

    private Area(String name) {
        this.name = name;
    }

    public static Area nameOf(String name) {
        for (Area status : Area.values()) {
            if (status.getName().equals(name)) {
                return status;
            }
        }
        return null;
    }
}
