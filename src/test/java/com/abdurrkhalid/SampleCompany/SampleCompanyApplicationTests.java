package com.abdurrkhalid.SampleCompany;

import com.abdurrkhalid.SampleCompany.models.Computer;
import com.abdurrkhalid.SampleCompany.repositories.ComputerRepository;
import com.abdurrkhalid.SampleCompany.services.ComputerService;
import com.abdurrkhalid.SampleCompany.services.ComputerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.springframework.data.util.Predicates.isTrue;

@SpringBootTest
class SampleCompanyApplicationTests {
    @Autowired
    ComputerService computerService;

    @Test
    void contextLoads() {
    }

    @Test
    void addComputerTest() {
        Computer computer = new Computer(null, "ip", "cname", "mac", "ark", "desc");
        Computer saved = computerService.saveComputer(computer);
        Assert.isTrue(saved != null);
    }
}
