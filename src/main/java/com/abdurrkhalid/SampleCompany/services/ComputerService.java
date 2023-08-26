package com.abdurrkhalid.SampleCompany.services;

import com.abdurrkhalid.SampleCompany.models.Computer;

import java.util.List;
import java.util.Optional;

public interface ComputerService {
    Computer saveComputer(Computer computer);
    List<Computer> getAllComputers();
    List<Computer> findByAbbreviation(String abbreviation);
    Optional<Computer> findById(Long id);
    void deleteById(Long id);
    Computer reassignComputer(Long id, String abbreviation);
}
