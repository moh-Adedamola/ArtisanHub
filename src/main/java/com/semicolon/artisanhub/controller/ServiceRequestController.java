package com.semicolon.artisanhub.controller;

import com.semicolon.artisanhub.data.model.ServicesRequesting;
import com.semicolon.artisanhub.dto.request.ServicesRequestDTO;
import com.semicolon.artisanhub.dto.response.ApiResponse;
import com.semicolon.artisanhub.services.ServicesRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Services")
public class ServiceRequestController {
    @Autowired
    private ServicesRequestService servicesRequestService;

    @PostMapping("RequestServices")

    public ResponseEntity<?>  RequestServices(ServicesRequestDTO servicesRequestDTO) {
        try{
            ServicesRequesting servicesRequesting = servicesRequestService.RequestServices(servicesRequestDTO);
            ApiResponse response = new ApiResponse(servicesRequesting, true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch(Exception e){
            ApiResponse errorResponse = new ApiResponse(e.getMessage(), false);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
         }
    }
}


