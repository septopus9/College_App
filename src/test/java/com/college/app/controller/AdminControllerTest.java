package com.college.app.controller;

import com.college.app.model.StudentProfile;
import com.college.app.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class AdminControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void addStudent_ShouldReturnStudentProfile_WhenValidRequest() throws Exception {
        // Arrange
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setUser_id(1);
        studentProfile.setPhoto("photo.jpg");
        studentProfile.setYear("2024");

        // Mock the service call
        when(adminService.saveStudent(any(StudentProfile.class))).thenReturn(studentProfile);

        // Act and Assert
        mockMvc.perform(post("/api/admin/students_profiles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"user_id\":1,\"photo\":\"photo.jpg\",\"year\":\"2024\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.photo").value("photo.jpg"))
                .andExpect(jsonPath("$.year").value("2024"));

        // Verify that the service was called once
        verify(adminService, times(1)).saveStudent(any(StudentProfile.class));
    }

    @Test
    public void addStudent_ShouldReturnBadRequest_WhenInvalidRequest() throws Exception {
        // Act and Assert
        mockMvc.perform(post("/api/admin/students_profiles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"user_id\":1,\"photo\":null,\"year\":\"\"}")) // Invalid data
                .andExpect(status().isBadRequest());
    }
}
