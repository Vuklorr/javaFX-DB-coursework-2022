package ru.manikinos.profile.entity;

import java.time.LocalDate;

public record Document (int id, int idType, int idPersonalData, LocalDate startDate, LocalDate endDate) {}
