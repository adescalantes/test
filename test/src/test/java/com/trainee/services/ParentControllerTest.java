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
import org.springframework.test.web.servlet.MockMvc;

import com.trainee.controllers.ParentController;
import com.trainee.models.Parent;
import com.trainee.repositories.ParentRepository;

class ParentControllerTest {

  private MockMvc mockMvc;

  @Mock
  ParentService parentService;

  @Mock
  ParentRepository parentRepository;

  @InjectMocks
  ParentController parentController;

  @BeforeEach
  void setUp() throws Exception {

    MockitoAnnotations.initMocks(this);
    // parent = new Parent(1, "Mock", "Mock", "Mock", "Mock", "Mock");
    // parentRepository.save(parent);
    // mockMvc = MockMvcBuilders.standaloneSetup(parentController).build();

  }

  @Test
  final void testGetAll() throws Exception {
    List<Parent> parent = new ArrayList();
    parent.add(new Parent(1, "Mock", "Mock", "Mock", "Mock", "Mock"));
    parent.add(new Parent(2, "Mock", "Mock", "Mock", "Mock", "Mock"));
    when(parentController.getAll()).thenReturn(parent);
    assertEquals(parentController.getAll(), null);
    // mockMvc.perform(get("/v1/parents").secure(true).accept(MediaType.APPLICATION_JSON)).andDo(print())
    // .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
    // .andExpect(MockMvcResultMatchers.jsonPath("$.gender").isNotEmpty());

    // mockMvc.perform(get("/v1/parents").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
    // .andExpect(jsonPath("$.id", Matchers.is(1))).andExpect(jsonPath("$.gender",
    // Matchers.is("Masculinos")))
    // .andExpect(jsonPath("$.firstName", Matchers.is("alex")))
    // .andExpect(jsonPath("$.middleName", Matchers.is("Escalante")))
    // .andExpect(jsonPath("$.lastName", Matchers.is("david")))
    // .andExpect(jsonPath("$.lastName", Matchers.is("no vive en casa")));

    // List<Parent> parent = new ArrayList<>();
    // parent.add(new Parent(1, "Mock", "Mock", "Mock", "Mock", "Mock"));
    // parent.add(new Parent(2, "Mock", "Mock", "Mock", "Mock", "Mock"));

    // when(parentController.getAll()).thenReturn(parentService.getAll());
    // assertEquals(parentController.getAll(), parentService.getAll());

  }

}
