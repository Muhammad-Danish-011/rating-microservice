package com.rating.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.rating.rating.model.Rating;

public interface RatingRepository extends JpaRepository<Rating,Long> {
  
  List<Rating> findByAppointmentId(Long appointment_id);

}
