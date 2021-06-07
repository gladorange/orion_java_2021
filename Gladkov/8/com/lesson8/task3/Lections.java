package com.lesson8.task3;

import java.time.LocalDate;

public enum Lections {
    MAT( "Матанализ", LocalDate.of(2020,9, 20) ),
    PHI( "Философия",LocalDate.of(2020,9, 21)),
    ENG( "Английкий язык",LocalDate.of(2020,9, 20)),
    HIS( "История", LocalDate.of(2020,9, 21)),
    MAT2( "Матанализ", LocalDate.of(2020,9, 22) ),
    PHI2( "Философия",LocalDate.of(2020,9, 23)),
    ENG2( "Английкий язык",LocalDate.of(2020,9, 22)),
    HIS2( "История", LocalDate.of(2020,9, 23)),
    GYM( "Физкультура", LocalDate.of(2020,9, 20));

    private String name;
    private LocalDate date;

    Lections(String name, LocalDate date) {
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
