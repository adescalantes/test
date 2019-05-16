package com.trainee.services;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.trainee.models.Parent;

class ParentServiceTest {

  @Mock
  private Parent parent;

  @Test
  public void testFindById() {
    parent.setId(1);
    parent.setFirstName("asd");
    parent.setGender("asddf");

    assertEquals(parent.getId(), 1);
  }

}
