package com.abdurrkhalid.SampleCompany.services;

import com.abdurrkhalid.SampleCompany.repositories.ComputerRepository;
import com.abdurrkhalid.SampleCompany.models.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    ComputerRepository computerRepository;


    @Override
    public Computer saveComputer(Computer computer) {
        List<Computer> computers = findByAbbreviation(computer.getEmployeeAbbreviation());
        if (computers.size() >= 3) {
            ResponseEntity result = sendNotification("warn", computer.getEmployeeAbbreviation(), "some message");
            return null;
        } else {
            return computerRepository.save(computer);
        }
    }

    @Override
    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    @Override
    public List<Computer> findByAbbreviation(String abbreviation) {
        return computerRepository.findComputerByEmployeeAbbreviation(abbreviation);
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return computerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        computerRepository.deleteById(id);
    }

    @Override
    public Computer reassignComputer(Long id, String abbreviation) {
        Computer computer = computerRepository.findById(id).get();
        computer.setEmployeeAbbreviation(abbreviation);
        return computerRepository.save(computer);
    }

    public ResponseEntity sendNotification(String level, String abbreviation, String message){
        String url = "http://localhost:8080/api/notify";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HashMap body = new HashMap();
        body.put("level", level);
        body.put("employeeAbbreviation", abbreviation);
        body.put("message", message);

        HttpEntity request = new HttpEntity(body);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.postForEntity(url, request, String.class);

        return response;
    }
}
