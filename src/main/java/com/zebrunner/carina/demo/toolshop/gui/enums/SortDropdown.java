package com.zebrunner.carina.demo.toolshop.gui.enums;


public enum SortDropdown {
    LOW_TO_HIGH("Price (Low - High)"),
    HIGH_TO_LOW("Price (High - Low)"),
    AZ("Name (A - Z)"),
    ZA("Name (Z - A)");

    private String sortType;

    SortDropdown(String sortType) {
        this.sortType = sortType;

    }

    public String getSortType() {
        return sortType;
    }
}
