package com.learning.unittesting.unittesting.business;

import com.learning.unittesting.unittesting.services.SomeDataService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
public class SomeBusinessImpl {

    @Getter
    @Setter
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
}
