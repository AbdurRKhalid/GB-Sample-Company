package com.abdurrkhalid.SampleCompany.repositories;

import com.abdurrkhalid.SampleCompany.models.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
