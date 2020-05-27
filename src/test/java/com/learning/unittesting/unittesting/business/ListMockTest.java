package com.learning.unittesting.unittesting.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List mock = mock(List.class);
    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValued() {

        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithParametrs() {
        when(mock.get(0)).thenReturn("Working");
        assertEquals("Working", mock.get(0));
    }

    @Test
    public void returnWithGenericParameter() {
        when(mock.get(anyInt())).thenReturn("Hello");
        assertEquals("Hello", mock.get(0));
    }

    @Test
    public void verificationBasics() {
      //SUT
        String value = (String)mock.get(0);

        //Verify
        verify(mock).get(0);            //verifying if method is called or not.
    }

    @Test
    public void argumentCapturing() {
        //SUT
        mock.add("Something");

        //Verification
        ArgumentCaptor<String>captor = ArgumentCaptor.forClass(String.class);       // here we are capturing the argument passed to our  method
        verify(mock).add(captor.capture());

        assertEquals("Something", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {           // this test case is for capturing multiple arguments
        //SUT
        mock.add("Something");
        mock.add("Something1");

        //Verification
        ArgumentCaptor<String>captor = ArgumentCaptor.forClass(String.class);       // here we are capturing the argument passed to our  method
        verify(mock, atLeast(1)).add(captor.capture());
        List<String>values = captor.getAllValues();
        assertEquals("Something", values.get(0));
        assertEquals("Something1",values.get(1));
    }

}
