// package com.rating.rating;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.when;

// import java.sql.Date;
// import java.time.Instant;
// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.json.JacksonTester;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.rating.rating.controller.RatingController;
// import com.rating.rating.model.Rating;
// import com.rating.rating.repository.RatingRepository;

// @AutoConfigureJsonTesters
// @AutoConfigureMockMvc
// @SpringBootTest
// class RatingApplicationTests {

// 	@Autowired
// 	private MockMvc mvc;

// 	@Mock
// 	private RatingRepository RatingRepository;

// 	@InjectMocks
// 	private RatingController RatingController;

// 	private JacksonTester<Rating> jsonRating;
// 	private JacksonTester<List<Rating>> jsonRatings;

// 	@BeforeEach
// public void setUp() {
//     JacksonTester.initFields(this, new ObjectMapper());
//     mvc = MockMvcBuilders.standaloneSetup(RatingController).build();
// }

// // Test1: POST RATING

// @Test
// public void canPostARating() throws Exception {
//     Rating rating1 = new Rating(1L, Instant.now(), Instant.now(), 2L, 5L, "ajhadfha");

//     when(RatingRepository.save(rating1)).thenReturn(rating1);
    
//     mvc.perform(MockMvcRequestBuilders
//             .post("/Rating/add")
//             .contentType(MediaType.APPLICATION_JSON)
//             .content(jsonRating.write(rating1).getJson()))
//             .andExpect(MockMvcResultMatchers.status().isOk());
// }





	
// 	// Test2: Getting a list of Rating
// 	@Test
// 	public void canGetAllRating() throws Exception {
// 		Rating rating1 = new Rating(1L, Instant.now(), Instant.now(), 2L, 5L, "ajhadfha");
// 		Rating rating2 = new Rating(1L, Instant.now(), Instant.now(), 2L, 5L, "ajhadfha");
// 		List<Rating> RatingList = new ArrayList<>();
// 		RatingList.add(rating1);
// 		RatingList.add(rating2);

// 		when(RatingRepository.findAll()).thenReturn(RatingList);
// 		mvc.perform(MockMvcRequestBuilders
// 				.get("/Rating/all")
// 				.contentType(MediaType.APPLICATION_JSON))
// 				.andExpect(MockMvcResultMatchers.status().isOk())
// 				.andExpect(MockMvcResultMatchers.content().json(jsonRatings.write(RatingList).getJson()));
// 	}

// 	// Test3: delete a Rating with id
// 	@Test
// 	public void canDeleteARating() throws Exception {
// 		Long RatingId = 1l;
// 		doNothing().when(RatingRepository).deleteById(RatingId);
// 		mvc.perform(MockMvcRequestBuilders
// 				.delete("/Rating/1"))
// 				.andExpect(MockMvcResultMatchers.status().isOk());
// 	}
// }
// 	// Test4 : delete a whole Rating 


// // // Test5: update a Rating with id
// // @Test
// // public void canUpdateARating() throws Exception {
// // Rating updateRating = new Rating(1L, 1L, 1L, Date.valueOf(LocalDate.now()),
// // Date.valueOf(LocalDate.now()),
// // "Lorem ipsum dolor sit amet, consectetur");
// // when(RatingRepository.save(updateRating)).thenReturn((updateRating));
// // mvc.perform(MockMvcRequestBuilders
// // .put("/Rating/update")
// // .contentType(MediaType.APPLICATION_JSON)
// // .content(jsonRating.write(updateRating).getJson()))
// // .andExpect(MockMvcResultMatchers.status().isOk());
// // }
// // }
