package com.skypay.bank.infrastructure;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SystemDateProvider implements DateProvider {
    @Override
    public String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
