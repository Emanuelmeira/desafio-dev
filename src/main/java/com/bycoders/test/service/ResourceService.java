package com.bycoders.test.service;

import com.bycoders.test.domain.Operation;
import com.bycoders.test.domain.enums.OperationType;
import com.bycoders.test.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ResourceService {

    @Autowired
    private ConverterValueFromFile converterValueFromFile;
    @Autowired
    private OperationRepository operationRepository;

    private List<Operation> operationListToPersist;

    private static final Double VALUE_TO_DOUBT = 100.00;
    private static final int VALUE_TO_DIVISION = -1;

    public void processFile(MultipartFile file) throws IOException {

        File currentDirectory = new File(".");
        String path = currentDirectory.getAbsolutePath();
        var fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();

        Stream<String> lines = Files.lines(Paths.get(fileLocation));

        operationListToPersist = new ArrayList<>();
        lines.forEach( line -> {
            var operation = processLine(line);
            operationListToPersist.add(operation);
        });

        operationListToPersist.forEach(this::saveOperation);
    }

    public Operation processLine(String line) {

        var operation = new Operation();

        var opType = OperationType.getEnumFromNumType(Integer.parseInt(line.substring(0,1)));
        operation.setOperationType(opType);

        var value = Double.parseDouble(line.substring(9,19)) / VALUE_TO_DOUBT;
        var valueResolved = resolveValue(value, opType);
        operation.setValueOfOperation(valueResolved);

        operation.setDateOfOperation(converterValueFromFile.converterStringToDate(line.substring(1,9)));
        operation.setCpf(line.substring(19,30));
        operation.setCard(line.substring(30,42));
        operation.setTimeOfOperation(converterValueFromFile.converterStringToTime(line.substring(42,48)));
        operation.setStoreOwnerOperation(line.substring(48,62));
        operation.setStoreNameOperation(line.substring(62,80));
        return operation;
    }

    public Double resolveValue(Double value, OperationType opType) {
        if(opType.getSignalLikeBoolean()){
            return value;
        }
        return value * VALUE_TO_DIVISION;
    }

    private void saveOperation(Operation operation) {
        operationRepository.save(operation);
    }

}
