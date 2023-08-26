package com.abdurrkhalid.SampleCompany.controllers;

import com.abdurrkhalid.SampleCompany.models.Computer;
import com.abdurrkhalid.SampleCompany.services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("computers")
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @PostMapping("/add")
    public ResponseEntity addComputer(@RequestBody Computer computer) {
        try {
            HashMap response = new HashMap();
            computerService.saveComputer(computer);
            response.put("success", true);
            response.put("message", "Computer Added Successfully to Database!");
            return new ResponseEntity(response, HttpStatus.CREATED);
        } catch (Exception e) {
            HashMap response = new HashMap();
            response.put("success", false);
            response.put("error", e.getMessage());
            response.put("message", "Error Occurred While Adding the Computer to Database!");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity getComputers() {
        try {
            HashMap response = new HashMap();
            response.put("success", true);
            response.put("data", computerService.getAllComputers());
            response.put("message", "All Computers Fetched Successfully!");
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {
            HashMap response = new HashMap();
            response.put("success", false);
            response.put("error", e.getMessage());
            response.put("message", "Error Occurred While Fetching the Computers!");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
}
