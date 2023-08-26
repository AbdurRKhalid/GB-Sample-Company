package com.abdurrkhalid.SampleCompany.services;

import com.abdurrkhalid.SampleCompany.models.Computer;

import java.util.List;

public interface ComputerService {
    Computer saveComputer(Computer computer);
    List<Computer> getAllComputers();
    List<Computer> findByAbbreviation(String abbreviation);
}
