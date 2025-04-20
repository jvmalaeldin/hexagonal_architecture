package com.alaeldin.hexgonaluserservice.domain.service;

import com.alaeldin.hexgonaluserservice.domain.model.User;
import com.alaeldin.hexgonaluserservice.domain.port.out.UserRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest
{
    @Mock
    private UserRepositoryPort userRepository;
    @InjectMocks
    private UserServiceImpl userService;
    @BeforeEach
    void setUp(){

        userService = new UserServiceImpl(userRepository);

    }

    @Test
    void testGetUserById_UserExists()
    {
        long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setName("Alaeldin");
        mockUser.setEmail("alaeldinmusa99@gmail.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));
        User result = userService.getUserById(userId);
        assertNotNull(result);
        assertEquals(userId,result.getId());
        assertEquals("Alaeldin",result.getName());
        verify(userRepository,times(1)).findById(userId);


    }

    @Test
    void testGetUserById_UserNotFound() {
        // Arrange
        Long userId = 2L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.getUserById(userId);
        });

        assertTrue(exception.getMessage().contains("User not found"));
        verify(userRepository, times(1)).findById(userId);
    }

}
