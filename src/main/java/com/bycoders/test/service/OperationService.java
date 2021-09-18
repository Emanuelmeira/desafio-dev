package com.bycoders.test.service;

import com.bycoders.test.domain.Operation;
import com.bycoders.test.domain.StoreResumeValues;
import com.bycoders.test.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public List<StoreResumeValues> processStore(){
        var operationsList = operationRepository.findAll();
        var opMap = operationsList.stream()
                .collect(Collectors.groupingBy(Operation::getStoreNameOperation));

        var storeResumeValuesList = new ArrayList<StoreResumeValues>();

        opMap.forEach((nameStore, operations) -> {

            var storeResumeValues = new StoreResumeValues();
            storeResumeValues.setStoreName(nameStore);
            storeResumeValues.setSumValue(operations.stream().mapToDouble(Operation::getValueOfOperation).sum());
            storeResumeValuesList.add(storeResumeValues);
        });

        return storeResumeValuesList;
    }

}
