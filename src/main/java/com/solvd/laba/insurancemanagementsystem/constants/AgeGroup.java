package com.solvd.laba.insurancemanagementsystem.constants;

public enum AgeGroup {
    CHILD(1),
    YOUTH(2),
    YOUNG_ADULT(3),
    ADULT(4),
    SENIOR(5);

    AgeGroup(Integer i) { this.id = i; };

    private final Integer id;

    public Integer getId() { return id; }
}
