package com.loadapi.load.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "Load_Table")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shipperId;

    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private String noOfTrucks;
    private String weight;
    private String comment;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}
