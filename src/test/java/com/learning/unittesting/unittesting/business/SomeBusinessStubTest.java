/**
 * @Author Mauzi
 * This class is used for unit testing of SomeBusinessImpl method calculateSumUsingDataService
 * using stub method.
 * */

package com.learning.unittesting.unittesting.business;

import com.learning.unittesting.unittesting.services.SomeDataService;
import org.junit.Test;
import static org.junit.Assert.*;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return (new int[] {1, 2, 3} );
    }
}

class SomeDataServiceStub1 implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return (new int[] {5} );
    }
}

class SomeDataServiceStubEmpty implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return (new int[] {} );
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataServiceOne() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub1());
        assertEquals(5, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataServiceEmpty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubEmpty());
        assertEquals(0, business.calculateSumUsingDataService());
    }
}
