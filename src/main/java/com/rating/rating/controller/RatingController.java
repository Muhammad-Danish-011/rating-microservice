package com.rating.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.rating.rating.model.Rating;
    
import com.rating.rating.repository.RatingRepository;
import java.util.Collection;
    import java.util.Optional;
    
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
    @RequestMapping("/Rating")
    public class RatingController {
    
        @Autowired
        private RatingRepository RatingRepository;
    
        // posting Rating
        @PostMapping("/add")
        public Rating addRating(@RequestBody Rating Rating) {
            this.RatingRepository.save(Rating);
            return Rating
            ;
        }
    
        // Getting Rating with id
    
        // @GetMapping("/get")
        // public ResponseEntity<Object> getRating(@RequestBody Rating rating) {
        //     this.RatingRepository.findAll();
        //     return ResponseEntity.ok(rating);
        // }
    
        // Getting all Rating
        @GetMapping("/all")
        public Collection<Rating> getAllRating() {
            return RatingRepository.findAll();
        }
    
        // Delete a Rating with id
        @DeleteMapping("/delete/{id}")
        public void deleteRating(@PathVariable Long id) {
            RatingRepository.deleteById(id);
            
        }
        @DeleteMapping("/delete")
        public void deleteRating() {
            RatingRepository.deleteAll(getAllRating());;
            
    
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




