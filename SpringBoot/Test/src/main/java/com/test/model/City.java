package com.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="cities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "City name must not be empty.")
    @Size(max = 500, message = "City name must be equal or less than 100 characters.")
    private String cityName;

    @Column(nullable = false)
    @NotNull(message = "City area must not be empty.")
    @Min(value = 0, message = "City area must be greater than 0.")
    private double area;

    @Column(nullable = false)
    @NotNull(message = "City population must not be empty.")
    @Min(value = 0, message = "City population must be greater than 0.")
    @Max(value = 1000000000, message = "City population must be equal or less than 1,000,000,000.")
    private long population;

    @Column(nullable = false)
    @NotNull(message = "City GDP must not be empty.")
    @Min(value = 0, message = "City GDP must be greater than 0.")
    @Max(value = 1000000000, message = "City GDP must be equal or less than 1,000,000,000.")
    private double gdp;

    @Column(nullable = false, length = 500)
    @Size(max = 500, message = "City description must be equal or less than 500 characters.")
    private String description;

    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "nation_id", referencedColumnName = "id")
    private Nation nation;
}
