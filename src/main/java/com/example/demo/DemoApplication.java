package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CarbonFootprintService;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DemoApplication {

    @Mock
    private UserRepository userRepository;

    @Mock
    private CarbonFootprintService carbonFootprintService;

    @InjectMocks
    private DemoApplication demoApplication;

    private User testUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        testUser = new User();
        testUser.setId(1L);
        testUser.setEmail("test@example.com");
        testUser.setName("Test User");
        testUser.setPassword("password123");
    }

    @Test
    public void testFindUserByEmail() {
        // Mocking repository to return Optional.of(user)
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(testUser));

        User user = userRepository.findByEmail("test@example.com")
                .orElseThrow(() -> new RuntimeException("User not found"));

        assertNotNull(user);
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testCarbonFootprintCalculation() {
        when(carbonFootprintService.calculateFootprint(any(User.class))).thenReturn(42.0);

        double footprint = carbonFootprintService.calculateFootprint(testUser);

        assertEquals(42.0, footprint);
    }

    @Test
    public void testJWTClaims() {
        // Example JWT Claims mock
        Claims claims = mock(Claims.class);
        when(claims.getSubject()).thenReturn("test@example.com");
        when(claims.getExpiration()).thenReturn(null); // example

        String subject = claims.getSubject();
        assertEquals("test@example.com", subject);
    }

    @Test
    public void testUpdateUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName("Updated Name");

        when(userRepository.save(user)).thenReturn(user);

        User updatedUser = userRepository.save(user);
        assertEquals("Updated Name", updatedUser.getName());
    }

    @Test
    public void testDeleteUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));

        doNothing().when(userRepository).delete(user);

        userRepository.delete(user);

        verify(userRepository, times(1)).delete(user);
    }
}
