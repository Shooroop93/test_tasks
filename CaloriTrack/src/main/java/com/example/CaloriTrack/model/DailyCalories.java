package com.example.CaloriTrack.model;

import com.example.CaloriTrack.constants.Formulas;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "daily_calories ")
@Getter
@Setter
@NoArgsConstructor
public class DailyCalories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calories")
    @Positive
    @Min(1)
    @NotNull
    private Double calories;

    @Column(name = "formula")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Formulas formula;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public DailyCalories(Double calories, Formulas formula, User user) {
        this.calories = calories;
        this.formula = formula;
        this.user = user;
    }
}