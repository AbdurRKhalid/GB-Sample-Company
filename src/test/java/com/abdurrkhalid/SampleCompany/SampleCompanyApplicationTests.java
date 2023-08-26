package com.abdurrkhalid.SampleCompany;

import com.abdurrkhalid.SampleCompany.models.Computer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.abdurrkhalid.SampleCompany.repositories.ComputerRepository;
import com.abdurrkhalid.SampleCompany.services.ComputerService;
import com.abdurrkhalid.SampleCompany.services.ComputerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.springframework.data.util.Predicates.isTrue;

@SpringBootTest
class SampleCompanyApplicationTests {
    @Autowired
    ComputerService computerService;

    @BeforeEach
    void addData() {
        Computer computer = new Computer(null, "random-IP Address", "Random Name", "Random Mac", "XYZ", "desc");
        Computer saved = computerService.saveComputer(computer);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void addComputerTest() {
        Computer computer = new Computer(null, "ip", "cname", "mac", "ark", "desc");
        Computer saved = computerService.saveComputer(computer);
        assertEquals(saved.getComputerName(), "cname", "Add Computer Test");
    }

    @Test
    void getAllComputersTest() {
        List<Computer> computers = computerService.getAllComputers();
        assertEquals(computers.size(),1, "Get All Computers Test");
    }
}
