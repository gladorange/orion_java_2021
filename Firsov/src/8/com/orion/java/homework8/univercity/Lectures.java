package com.orion.java.homework8.univercity;

import java.time.LocalDate;

public enum Lectures {
    MAT( "Матанализ", LocalDate.of(2021,2, 1) ),
    MAT2( "Матанализ", LocalDate.of(2021,2, 19) ),
    HIS( "История", LocalDate.of(2021,2, 17)),
    HIS2( "История", LocalDate.of(2020,9, 11)),
    PHI( "Философия",LocalDate.of(2021,2, 12)),
    PHI2( "Философия",LocalDate.of(2020,9, 23)),
    ENG( "Английкий язык",LocalDate.of(2021,2, 15)),
    ENG2( "Английкий язык",LocalDate.of(2020,9, 10)),
    GYM( "Физкультура", LocalDate.of(2021,9, 16));

    private String name;
    private LocalDate date;

    Lectures(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}
