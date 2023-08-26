package com.abdurrkhalid.SampleCompany.repositories;

import com.abdurrkhalid.SampleCompany.models.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
    List<Computer> findComputerByEmployeeAbbreviation(String abbreviation);
}
