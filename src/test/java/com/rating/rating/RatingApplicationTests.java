package com.rating.rating;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rating.rating.controller.RatingController;
import com.rating.rating.model.Rating;
import com.rating.rating.repository.RatingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
class RatingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private RatingController ratingController;

    private JacksonTester<Rating> jsonRating;
    private JacksonTester<List<Rating>> jsonRatings;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        JacksonTester.initFields(this, new ObjectMapper().registerModule(new JavaTimeModule()));
        mvc = MockMvcBuilders.standaloneSetup(ratingController).build();
    }

    @Test
    void testAddRating() throws Exception {
        Rating rating = new Rating();
        when(ratingRepository.save(rating)).thenReturn(rating);

        mvc.perform(MockMvcRequestBuilders.post("/rating/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRating.write(rating).getJson()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    

    @Test
    void testGetAllRating() throws Exception {
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating());
        ratings.add(new Rating());

        when(ratingRepository.findAll()).thenReturn(ratings);

        mvc.perform(MockMvcRequestBuilders.get("/rating/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
                
    }

    @Test
    void testDeleteRating() throws Exception {
        Long id = 1L;

        doNothing().when(ratingRepository).deleteById(id);

        mvc.perform(MockMvcRequestBuilders.delete("/rating/delete/" + id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteAllRating() throws Exception {
        doNothing().when(ratingRepository).deleteAll();

        mvc.perform(MockMvcRequestBuilders.delete("/rating/delete"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

  
}
