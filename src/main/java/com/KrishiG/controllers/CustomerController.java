package com.KrishiG.controllers;

import com.KrishiG.dtos.request.CustomerAddressDto;
import com.KrishiG.dtos.request.CustomerDto;
import com.KrishiG.dtos.response.CustomerAddressResponseDto;
import com.KrishiG.dtos.response.CustomerResponseDto;
import com.KrishiG.responsesApiMessages.ApiResponseMessage;
import com.KrishiG.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //create
    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerResponseDto createdCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable("customerId") Long customerId) {
        CustomerDto updatedCustomer = customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponseMessage> deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.deleteCustomer(customerId);
        ApiResponseMessage message = ApiResponseMessage.builder().message("Customer Deleted Successfully")
                                                                 .status(HttpStatus.OK).success(true).build();

        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    //getAll
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers()
    {
       List<CustomerDto> customerDtos =  customerService.getAllCustomers();
       return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }

    @PostMapping("/addAddress")
    public ResponseEntity<CustomerAddressResponseDto> addAddressOfCustomer(@RequestBody CustomerAddressDto addressDto) {
        CustomerAddressResponseDto addressDtos = customerService.addCustomerAddress(addressDto);
        return new ResponseEntity<>(addressDtos, HttpStatus.CREATED);
    }
}
