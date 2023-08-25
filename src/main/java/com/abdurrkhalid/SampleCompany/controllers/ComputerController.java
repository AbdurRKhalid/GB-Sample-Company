package com.abdurrkhalid.SampleCompany.controllers;

import com.abdurrkhalid.SampleCompany.models.Computer;
import com.abdurrkhalid.SampleCompany.services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("computers")
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @PostMapping("/add")
    public String addComputer(@RequestBody Computer computer) {
        Computer computer1 = computerService.saveComputer(computer);
        return "Added!";
    }
}
