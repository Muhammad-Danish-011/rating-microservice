package com.rating.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.rating.rating.model.Rating;

import com.rating.rating.repository.RatingRepository;
import java.util.Collection;
import java.util.Optional;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingRepository RatingRepository;

    // Posting Rating
    @PostMapping("/add")
    public Rating addRating(@RequestBody Rating Rating) {
        try {
            this.RatingRepository.save(Rating);
            return Rating;
        } catch (Exception e) {
            // Handle any exceptions
            // You can log the error or return a custom response
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getbyappointment/{appointmentId}")
    public ResponseEntity<List<Rating>> getAppointmentById(@PathVariable Long appointmentId) {
        try {
            List<Rating> appointments = this.RatingRepository.findByAppointmentId(appointmentId);
            if (!appointments.isEmpty()) {
                return ResponseEntity.ok(appointments);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Getting all Rating
    @GetMapping("/all")
    public Collection<Rating> getAllRating() {
        try {
            return RatingRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Delete a Rating with id
    @DeleteMapping("/delete/{id}")
    public void deleteRating(@PathVariable Long id) {
        try {
            RatingRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delete")
    public void deleteRating() {
        try {
            RatingRepository.deleteAll(getAllRating());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/{id}")
public ResponseEntity<Rating> getRatingById(@PathVariable Long id) {
    try {
        Optional<Rating> rating = RatingRepository.findById(id);
        if (rating.isPresent()) {
            return ResponseEntity.ok(rating.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}


}
    
    //     //Update a note with id
    //     @PutMapping("/update")
    //     public String updateRating(@RequestBody Rating updateRating){
    //         Optional<Rating> ratingOptional =  RatingRepository.findById(updateRating.getId());
    
    //         if(Rating.isPresent()){
    //             Long a = Rating.getId();
    //             a.setContent(updateRating.getContent());
    //             a.setUpdated(updateRating.getUpdated());
    //             RatingRepository.save(a);
                
    //             return "rating has updated successfully";
    //         }else{
    //             return "rating does not exist";
    //         }
    
    
    //     }
    // }




