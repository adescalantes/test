package com.trainee.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.trainee.models.Parent;
import com.trainee.repositories.ParentRepository;

class ParentServiceTest {

  @Mock
  ParentRepository parentRepository;

  @InjectMocks
  ParentService parentService;

  @BeforeEach
  void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetAll() {
    List<Parent> parent = new ArrayList<>();
    parent.add(new Parent(1, "Mock", "Mock", "Mock", "Mock", "Mock"));
    parent.add(new Parent(2, "Mock", "Mock", "Mock", "Mock", "Mock"));

    List<Parent> parent2 = new ArrayList<>();
    parent2.add(new Parent(1, "Mockito", "Mockito", "Mockito", "Mockito", "Mockito"));
    parent2.add(new Parent(2, "Mockito", "Mockito", "Mockito", "Mockito", "Mockito"));

    when(parentRepository.findAll()).thenReturn(parent);
    assertEquals(parentService.getAll(), parent);
  }

  @Test
  public void testPostParent() {
    Parent parent = new Parent();
    parent.setId(1);
    parent.setFirstName("Mock");
    parent.setGender("Mock");
    parent.setLastName("Mock");
    parent.setMiddleName("Mock");
    parent.setOtherParentDetails("Mock");
    ResponseEntity<Parent> p = new ResponseEntity<Parent>(HttpStatus.OK);
    when(parentRepository.save(parent)).thenReturn(null);
    assertEquals(null, parent);
  }

}
