/**
 * @Author Mauzi
 * This class is used for unit testing of SomeBusinessImpl method calculateSumUsingDataService
 * using mock
 * */

package com.learning.unittesting.unittesting.business;

import com.learning.unittesting.unittesting.services.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.configuration.injection.MockInjection;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;           // creating instance of SomeBusinessImpl and injecting dataService mock
    @Mock
    SomeDataService dataService;    // mocking SomeDataServiceClass

//    @Before
//    public void setDataService(){
//        business.setSomeDataService(dataService);
//    }

    @Test
    public void calculateSumUsingDataService_Basic(){
        when(dataService.retrieveAllData()).thenReturn(new int[] {1,2,3});
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_One(){
        when(dataService.retrieveAllData()).thenReturn(new int[] {5});
        assertEquals(5, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_Empty(){
        when(dataService.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, business.calculateSumUsingDataService());
    }
}
