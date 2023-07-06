package com.rating.rating.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.micrometer.common.lang.NonNull;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="rating")
public class Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


    @CreationTimestamp
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant created ; 

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")    
    @CreationTimestamp
    private Instant updated;
    
    @NonNull
    private Long appointmentId;

    private Float value ;
    private String note;
    

}
