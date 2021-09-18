package com.bycoders.test.service;

import com.bycoders.test.domain.enums.OperationType;
import com.bycoders.test.repository.OperationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class ResourceServiceTest {

    //Exemplo de construção de testes unitarios

    @Spy
    @InjectMocks
    private ResourceService resourceService;
    @Mock
    private OperationRepository operationRepository;
    @Mock
    private ConverterValueFromFile converterValueFromFile;

    @Test
    public void processFile_success() throws IOException {

        resourceService.processFile(new MockMultipartFile("CNAB", "CNAB.txt", MediaType.TEXT_PLAIN_VALUE,
                "text".getBytes()));

        verify(operationRepository,times(21) ).save(any());
        //EX de validação de chamadas de metodos
    }

    @Test
    public void processLine_success() {

        var op = resourceService.processLine("2201903010000010700845152540738723****9987123333MARCOS PEREIRAMERCADO DA AVENIDA");

        Assert.assertEquals(OperationType.TICKET, op.getOperationType());
        Assert.assertEquals("MARCOS PEREIRA", op.getStoreOwnerOperation());
        Assert.assertEquals("MERCADO DA AVENIDA", op.getStoreNameOperation());
        //EX de validação de dados de retorno
    }

    @Test
    public void resolveValue_get_positive_success() {
        var value = resourceService.resolveValue(10.00, OperationType.CREDIT);
        Assert.assertEquals(Double.valueOf(10.00), value);
    }

    @Test
    public void resolveValue_get_negative_success() {
        var value = resourceService.resolveValue(10.00, OperationType.TICKET);
        Assert.assertEquals(Double.valueOf(-10.00), value);
    }


}
