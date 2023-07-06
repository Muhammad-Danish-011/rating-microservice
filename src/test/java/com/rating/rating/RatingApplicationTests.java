// package com.rating.rating;

// import com.rating.rating.controller.RatingController;
// import com.rating.rating.model.Rating;
// import com.rating.rating.repository.RatingRepository;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;

// class RatingControllerTest {

//     private RatingController ratingController;

//     @Mock
//     private RatingRepository ratingRepository;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//         ratingController = new RatingController();
//         ratingController.setRatingRepository(ratingRepository);
//     }

//     @Test
//     void addRating_ValidRating_ReturnsRating() {
//         // Arrange
//         Rating rating = new Rating();
//         when(ratingRepository.save(rating)).thenReturn(rating);

//         // Act
//         Rating result = ratingController.addRating(rating);

//         // Assert
//         assertEquals(rating, result);
//         verify(ratingRepository, times(1)).save(rating);
//     }

//     @Test
//     void getAppointmentById_ValidAppointmentId_ReturnsAppointments() {
//         // Arrange
//         Long appointmentId = 1L;
//         Rating rating = new Rating();
//         List<Rating> appointments = Arrays.asList(rating);
//         when(ratingRepository.findByAppointmentId(appointmentId)).thenReturn(appointments);

//         // Act
//         ResponseEntity<List<Rating>> response = ratingController.getAppointmentById(appointmentId);

//         // Assert
//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertEquals(appointments, response.getBody());
//         verify(ratingRepository, times(1)).findByAppointmentId(appointmentId);
//     }

//     @Test
//     void getAppointmentById_InvalidAppointmentId_ReturnsNoContent() {
//         // Arrange
//         Long appointmentId = 1L;
//         when(ratingRepository.findByAppointmentId(appointmentId)).thenReturn(null);

//         // Act
//         ResponseEntity<List<Rating>> response = ratingController.getAppointmentById(appointmentId);

//         // Assert
//         assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//         assertEquals(null, response.getBody());
//         verify(ratingRepository, times(1)).findByAppointmentId(appointmentId);
//     }

//     // Add more tests for other methods in the controller

//     // Remember to test error cases and handle exceptions appropriately

//     private void setRatingRepository(RatingRepository ratingRepository) {
//         this.ratingRepository = ratingRepository;
//     }
// }
