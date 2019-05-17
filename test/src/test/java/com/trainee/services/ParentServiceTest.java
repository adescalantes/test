package com.trainee.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.trainee.models.Parent;

class ParentServiceTest {


  @Test
  public void testFindById() {
	  List mockList = Mockito.mock(ArrayList.class);
	     
	    mockList.add("one");
	    Mockito.verify(mockList).add("one");
	    assertEquals(0, mockList.size());
	 
	    when(mockList.size()).thenReturn(100);
	    assertEquals(100, mockList.size());
  }

}
