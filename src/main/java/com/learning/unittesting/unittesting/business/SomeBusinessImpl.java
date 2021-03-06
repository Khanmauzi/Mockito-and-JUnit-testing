package com.learning.unittesting.unittesting.business;

import com.learning.unittesting.unittesting.services.SomeDataService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

@Data
public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public int calculateSum(int[] data){
        int sum=0;
        for(int val: data){
            sum += val;
        }
        return sum;
    }

    public int calculateSumUsingDataService(){
        int[] data = someDataService.retrieveAllData();
        int sum=0;
        for(int val: data){
            sum+=val;
        }
        return sum;
    }

    public int calculateSumUsingFunctionalPrgramming(int[] data) {
//        OptionalInt number = Arrays.stream(data).reduce(Integer::sum);
//        return number.orElse(0);
        //short method
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }
}
