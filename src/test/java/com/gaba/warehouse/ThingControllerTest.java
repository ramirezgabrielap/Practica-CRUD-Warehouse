package com.gaba.warehouse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.gaba.warehouse.controller.ThingController;
import com.gaba.warehouse.repository.ThingRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(ThingController.class)
@AutoConfigureMockMvc
public class ThingControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ThingRepository thingRepository;

    @InjectMocks
    private ThingController thingController;

    
    //@Test
    //void testCreateForm() throws Exception {
    //    mockMvc.perform(get("/thing/create"))
    //            .andExpect(status().isOk())
    //            .andExpect(view().name("create"));
    //}

    //@Test
    //void testSave() throws Exception {
    //    mockMvc.perform(post("/thing/save")
    //            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
    //            .param("name", "NewThing")
    //            .param("amount", "3"))
    //            .andExpect(status().is3xxRedirection())
    //            .andExpect(redirectedUrl("/thing/list"));
    //    verify(thingRepository).save(any());
    //}

    //@Test
    //void testDelete() throws Exception {
    //    mockMvc.perform(delete("/thing/7"))
    //            .andExpect(status().is3xxRedirection())
    //            .andExpect(redirectedUrl("/thing/list"));
    //    verify(thingRepository).deleteById(1);
    //}
    
}
