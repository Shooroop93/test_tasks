package com.example.CaloriTrack.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "dishes")
@Setter
@Getter
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "calories")
    @NotNull
    @Min(1)
    private Integer calories;

    @Column(name = "proteins")
    @NotNull
    @Positive
    private Double proteins;

    @Column(name = "fats")
    @NotNull
    @Positive
    private Double fats;

    @Column(name = "carbs")
    @NotNull
    @Positive
    private Double carbs;

    @OneToMany(mappedBy = "dish", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<MealDish> mealDishes;
}