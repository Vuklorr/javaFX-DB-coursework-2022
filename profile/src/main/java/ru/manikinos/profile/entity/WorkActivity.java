package ru.manikinos.profile.entity;

import java.time.LocalDate;

public record WorkActivity(int id, String nameWork, int salary, int hoursWorked, LocalDate dateOfHiring, LocalDate dateOfDismissal) {
}
