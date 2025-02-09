package com.divakar.service;

import com.divakar.entity.User;
import com.divakar.repository.UserRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

    @Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final String URL = "https://dummyjson.com/users";

    public List<User> fetchAndSaveUsers() {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            JsonNode usersNode = rootNode.get("users");

            List<User> users = Arrays.asList(objectMapper.treeToValue(usersNode, User[].class));
            List<User> savedUsers = userRepository.saveAll(users);

            log.info("Successfully saved {} users", savedUsers.size());
            return savedUsers;

        } catch (Exception e) {
            log.error("Error fetching and saving users", e);
            throw new RuntimeException("Failed to fetch and save users", e);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    public List<User> getUsersSortedByAge(String order) {
        Sort sort = order.equalsIgnoreCase("desc") ?
            Sort.by("age").descending() :
            Sort.by("age").ascending();
        return userRepository.findAll(sort);
    }

    public Optional<User> getUserByIdOrSSN(Long id, String ssn) {
        return userRepository.findByIdOrSsn(id, ssn);
    }
        public List<User> getUsersByRoleAndSortedByAge(String role, String order) {
            List<User> usersByRole = getUsersByRole(role);
            return getUsersSortedByAge(usersByRole, order);
        }

        private List<User> getUsersSortedByAge(List<User> users, String order) {
            if ("asc".equalsIgnoreCase(order)) {
                users.sort(Comparator.comparingInt(User::getAge));
            } else if ("desc".equalsIgnoreCase(order)) {
                users.sort(Comparator.comparingInt(User::getAge).reversed());
            }
            return users;
        }

    }
