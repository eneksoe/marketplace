package com.example.marketplace.service.impl;

import com.example.marketplace.model.Image;
import com.example.marketplace.model.Product;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.UserRepository;
import com.sun.security.auth.UserPrincipal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testCreate() throws UnsupportedEncodingException {
        Image image = new Image();
        image.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image.setContentType("text/plain");
        image.setId(123L);
        image.setName("Name");
        image.setOriginalFileName("foo.txt");
        image.setPreviewImage(true);
        image.setProduct(new Product());
        image.setSize(3L);

        User user = new User();
        user.setActive(true);
        user.setAvatar(image);
        user.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setProducts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        Product product = new Product();
        product.setCity("Oxford");
        product.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        product.setDescription("The characteristics of someone or something");
        product.setId(123L);
        product.setImages(new ArrayList<>());
        product.setName("Name");
        product.setPreviewImageId(123L);
        product.setPrice(1);
        product.setUser(user);

        Image image1 = new Image();
        image1.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image1.setContentType("text/plain");
        image1.setId(123L);
        image1.setName("Name");
        image1.setOriginalFileName("foo.txt");
        image1.setPreviewImage(true);
        image1.setProduct(product);
        image1.setSize(3L);

        User user1 = new User();
        user1.setActive(true);
        user1.setAvatar(image1);
        user1.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("4105551212");
        user1.setProducts(new ArrayList<>());
        user1.setRoles(new HashSet<>());

        Image image2 = new Image();
        image2.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image2.setContentType("text/plain");
        image2.setId(123L);
        image2.setName("Name");
        image2.setOriginalFileName("foo.txt");
        image2.setPreviewImage(true);
        image2.setProduct(new Product());
        image2.setSize(3L);

        User user2 = new User();
        user2.setActive(true);
        user2.setAvatar(image2);
        user2.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setEmail("jane.doe@example.org");
        user2.setId(123L);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("4105551212");
        user2.setProducts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Product product1 = new Product();
        product1.setCity("Oxford");
        product1.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        product1.setDescription("The characteristics of someone or something");
        product1.setId(123L);
        product1.setImages(new ArrayList<>());
        product1.setName("Name");
        product1.setPreviewImageId(123L);
        product1.setPrice(1);
        product1.setUser(user2);

        Image image3 = new Image();
        image3.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image3.setContentType("text/plain");
        image3.setId(123L);
        image3.setName("Name");
        image3.setOriginalFileName("foo.txt");
        image3.setPreviewImage(true);
        image3.setProduct(product1);
        image3.setSize(3L);

        User user3 = new User();
        user3.setActive(true);
        user3.setAvatar(image3);
        user3.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setEmail("jane.doe@example.org");
        user3.setId(123L);
        user3.setName("Name");
        user3.setPassword("iloveyou");
        user3.setPhoneNumber("4105551212");
        user3.setProducts(new ArrayList<>());
        user3.setRoles(new HashSet<>());

        when(userRepository.findByEmail(any())).thenReturn(user1);
        when(userRepository.save(any())).thenReturn(user3);

        User user4 = new User();
        user4.setActive(true);
        user4.setAvatar(new Image());
        user4.setDateOfCreated(null);
        user4.setEmail("jane.doe@example.org");
        user4.setId(123L);
        user4.setName("Name");
        user4.setPassword("iloveyou");
        user4.setPhoneNumber("4105551212");
        user4.setProducts(new ArrayList<>());
        user4.setRoles(new HashSet<>());

        Product product2 = new Product();
        product2.setCity("Oxford");
        product2.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        product2.setDescription("The characteristics of someone or something");
        product2.setId(123L);
        product2.setImages(new ArrayList<>());
        product2.setName("Name");
        product2.setPreviewImageId(123L);
        product2.setPrice(1);
        product2.setUser(user4);

        Image image4 = new Image();
        image4.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image4.setContentType("text/plain");
        image4.setId(123L);
        image4.setName("Name");
        image4.setOriginalFileName("foo.txt");
        image4.setPreviewImage(true);
        image4.setProduct(product2);
        image4.setSize(3L);

        User user5 = new User();
        user5.setActive(true);
        user5.setAvatar(image4);
        user5.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user5.setEmail("jane.doe@example.org");
        user5.setId(123L);
        user5.setName("Name");
        user5.setPassword("iloveyou");
        user5.setPhoneNumber("4105551212");
        user5.setProducts(new ArrayList<>());
        user5.setRoles(new HashSet<>());

        assertFalse(userServiceImpl.create(user5));
        verify(userRepository).findByEmail(any());
    }

    @Test
    void testList() {
        ArrayList<User> userList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList);

        List<User> actualListResult = userServiceImpl.list();

        assertSame(userList, actualListResult);
        assertTrue(actualListResult.isEmpty());
        verify(userRepository).findAll();
    }

    @Test
    void testBanUser() throws UnsupportedEncodingException {
        User user = new User();
        user.setActive(true);
        user.setAvatar(new Image());
        user.setDateOfCreated(null);
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setProducts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        Product product = new Product();
        product.setCity("Oxford");
        product.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        product.setDescription("The characteristics of someone or something");
        product.setId(123L);
        product.setImages(new ArrayList<>());
        product.setName("Name");
        product.setPreviewImageId(123L);
        product.setPrice(1);
        product.setUser(user);

        Image image = new Image();
        image.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image.setContentType("text/plain");
        image.setId(123L);
        image.setName("Name");
        image.setOriginalFileName("foo.txt");
        image.setPreviewImage(true);
        image.setProduct(product);
        image.setSize(3L);

        User user1 = new User();
        user1.setActive(true);
        user1.setAvatar(image);
        user1.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("4105551212");
        user1.setProducts(new ArrayList<>());
        user1.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user1);

        Image image1 = new Image();
        image1.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image1.setContentType("text/plain");
        image1.setId(123L);
        image1.setName("Name");
        image1.setOriginalFileName("foo.txt");
        image1.setPreviewImage(true);
        image1.setProduct(new Product());
        image1.setSize(3L);

        User user2 = new User();
        user2.setActive(true);
        user2.setAvatar(image1);
        user2.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setEmail("jane.doe@example.org");
        user2.setId(123L);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("4105551212");
        user2.setProducts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Product product1 = new Product();
        product1.setCity("Oxford");
        product1.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        product1.setDescription("The characteristics of someone or something");
        product1.setId(123L);
        product1.setImages(new ArrayList<>());
        product1.setName("Name");
        product1.setPreviewImageId(123L);
        product1.setPrice(1);
        product1.setUser(user2);

        Image image2 = new Image();
        image2.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image2.setContentType("text/plain");
        image2.setId(123L);
        image2.setName("Name");
        image2.setOriginalFileName("foo.txt");
        image2.setPreviewImage(true);
        image2.setProduct(product1);
        image2.setSize(3L);

        User user3 = new User();
        user3.setActive(true);
        user3.setAvatar(image2);
        user3.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setEmail("jane.doe@example.org");
        user3.setId(123L);
        user3.setName("Name");
        user3.setPassword("iloveyou");
        user3.setPhoneNumber("4105551212");
        user3.setProducts(new ArrayList<>());
        user3.setRoles(new HashSet<>());

        when(userRepository.save((User) any())).thenReturn(user3);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);

        userServiceImpl.banUser(123L);

        verify(userRepository).save(any());
        verify(userRepository).findById(any());
    }

    @Test
    void testChangeUserRoles() throws UnsupportedEncodingException {
        Image image = new Image();
        image.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image.setContentType("text/plain");
        image.setId(123L);
        image.setName("Name");
        image.setOriginalFileName("foo.txt");
        image.setPreviewImage(true);
        image.setProduct(new Product());
        image.setSize(3L);

        User user = new User();
        user.setActive(true);
        user.setAvatar(image);
        user.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setProducts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        Product product = new Product();
        product.setCity("Oxford");
        product.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        product.setDescription("The characteristics of someone or something");
        product.setId(123L);
        product.setImages(new ArrayList<>());
        product.setName("Name");
        product.setPreviewImageId(123L);
        product.setPrice(1);
        product.setUser(user);

        Image image1 = new Image();
        image1.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image1.setContentType("text/plain");
        image1.setId(123L);
        image1.setName("Name");
        image1.setOriginalFileName("foo.txt");
        image1.setPreviewImage(true);
        image1.setProduct(product);
        image1.setSize(3L);

        User user1 = new User();
        user1.setActive(true);
        user1.setAvatar(image1);
        user1.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("4105551212");
        user1.setProducts(new ArrayList<>());
        user1.setRoles(new HashSet<>());

        when(userRepository.save(any())).thenReturn(user1);

        User user2 = new User();
        user2.setActive(true);
        user2.setAvatar(new Image());
        user2.setDateOfCreated(null);
        user2.setEmail("jane.doe@example.org");
        user2.setId(123L);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("4105551212");
        user2.setProducts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Product product1 = new Product();
        product1.setCity("Oxford");
        product1.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        product1.setDescription("The characteristics of someone or something");
        product1.setId(123L);
        product1.setImages(new ArrayList<>());
        product1.setName("Name");
        product1.setPreviewImageId(123L);
        product1.setPrice(1);
        product1.setUser(user2);

        Image image2 = new Image();
        image2.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image2.setContentType("text/plain");
        image2.setId(123L);
        image2.setName("Name");
        image2.setOriginalFileName("foo.txt");
        image2.setPreviewImage(true);
        image2.setProduct(product1);
        image2.setSize(3L);

        User user3 = new User();
        user3.setActive(true);
        user3.setAvatar(image2);
        user3.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setEmail("jane.doe@example.org");
        user3.setId(123L);
        user3.setName("Name");
        user3.setPassword("iloveyou");
        user3.setPhoneNumber("4105551212");
        user3.setProducts(new ArrayList<>());
        user3.setRoles(new HashSet<>());

        userServiceImpl.changeUserRoles(user3, new HashMap<>());

        verify(userRepository).save(any());
        assertTrue(user3.getAuthorities().isEmpty());
    }

    @Test
    void testGetUserByPrincipal() throws UnsupportedEncodingException {
        Image image = new Image();
        image.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image.setContentType("text/plain");
        image.setId(123L);
        image.setName("Name");
        image.setOriginalFileName("foo.txt");
        image.setPreviewImage(true);
        image.setProduct(new Product());
        image.setSize(3L);

        User user = new User();
        user.setActive(true);
        user.setAvatar(image);
        user.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setProducts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        Product product = new Product();
        product.setCity("Oxford");
        product.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        product.setDescription("The characteristics of someone or something");
        product.setId(123L);
        product.setImages(new ArrayList<>());
        product.setName("Name");
        product.setPreviewImageId(123L);
        product.setPrice(1);
        product.setUser(user);

        Image image1 = new Image();
        image1.setBytes("AAAAAAAA".getBytes("UTF-8"));
        image1.setContentType("text/plain");
        image1.setId(123L);
        image1.setName("Name");
        image1.setOriginalFileName("foo.txt");
        image1.setPreviewImage(true);
        image1.setProduct(product);
        image1.setSize(3L);

        User user1 = new User();
        user1.setActive(true);
        user1.setAvatar(image1);
        user1.setDateOfCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("4105551212");
        user1.setProducts(new ArrayList<>());
        user1.setRoles(new HashSet<>());

        when(userRepository.findByEmail(any())).thenReturn(user1);
        assertSame(user1, userServiceImpl.getUserByPrincipal(new UserPrincipal("principal")));
        verify(userRepository).findByEmail(any());
    }
}

