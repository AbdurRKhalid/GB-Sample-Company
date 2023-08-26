package com.abdurrkhalid.SampleCompany.services;

import com.abdurrkhalid.SampleCompany.repositories.ComputerRepository;
import com.abdurrkhalid.SampleCompany.models.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    ComputerRepository computerRepository;


    @Override
    public Computer saveComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    @Override
    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }
}
