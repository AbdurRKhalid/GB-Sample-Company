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
@CrossOrigin
@RequestMapping("computers")
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @PostMapping("/add")
    public ResponseEntity addComputer(@RequestBody Computer computer) {
        try {
            HashMap response = new HashMap();
            Computer savedComputer = computerService.saveComputer(computer);
            response.put("success", true);
            if (savedComputer == null) {
                response.put("message", "Computer Did not save and System Admin has been Notified!");
            } else {
                response.put("message", "Computer Added Successfully to Database!");
            }
            return new ResponseEntity(response, HttpStatus.OK);
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

    @GetMapping("/get-all-by-employee/{abbreviation}")
    public ResponseEntity getComputersByEmployee(@PathVariable String abbreviation) {
        try {
            HashMap response = new HashMap();
            response.put("success", true);
            response.put("data", computerService.findByAbbreviation(abbreviation));
            response.put("message", "All Computers of Employee Fetched Successfully!");
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e) {
            HashMap response = new HashMap();
            response.put("success", false);
            response.put("error", e.getMessage());
            response.put("message", "Error Occurred While Fetching the Computers!");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity getComputerById(@PathVariable Long id) {
        try {
            HashMap response = new HashMap();
            response.put("success", true);
            response.put("data", computerService.findById(id));
            response.put("message", "All Computers of Employee Fetched Successfully!");
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e) {
            HashMap response = new HashMap();
            response.put("success", false);
            response.put("error", e.getMessage());
            response.put("message", "Error Occurred While Fetching the Computers!");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        try {
            computerService.deleteById(id);
            HashMap response = new HashMap();
            response.put("success", true);
            response.put("message", "Computer Deleted Successfully!");
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e) {
            HashMap response = new HashMap();
            response.put("success", false);
            response.put("error", e.getMessage());
            response.put("message", "Error Occurred While Deleting the Computer!");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/reassign/{id}/{abbreviation}")
    public ResponseEntity reassignComputer(@PathVariable Long id, @PathVariable String abbreviation) {
        try {
            computerService.reassignComputer(id, abbreviation);
            HashMap response = new HashMap();
            response.put("success", true);
            response.put("message", "Computer Reassigned Successfully!");
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e) {
            HashMap response = new HashMap();
            response.put("success", false);
            response.put("error", e.getMessage());
            response.put("message", "Error Occurred While Reassigning!");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-computer")
    public ResponseEntity updateComputer(@RequestBody Computer computer) {
        try {
            computerService.updateComputer(computer);
            HashMap response = new HashMap();
            response.put("success", true);
            response.put("message", "Computer Updated Successfully!");
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e) {
            HashMap response = new HashMap();
            response.put("success", false);
            response.put("error", e.getMessage());
            response.put("message", "Error Occurred While Updating Computer!");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
}
