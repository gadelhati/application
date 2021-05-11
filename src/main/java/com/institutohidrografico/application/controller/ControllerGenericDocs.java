package com.institutohidrografico.application.controller;

import com.institutohidrografico.application.persistence.dto.request.DTORequestSeal;
import com.institutohidrografico.application.persistence.dto.response.DTOResponseSeal;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.UUID;

public interface ControllerGenericDocs {

    @ApiOperation(value = "Creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success creation"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or already registered on system")
    })
    DTOResponseSeal create(/*AuthenticatedUser authenticatedUser,*/ DTORequestSeal dTORequestSeal);

    @ApiOperation(value = "Find by id and user operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success found"),
            @ApiResponse(code = 404, message = "Not found error")
    })
    DTOResponseSeal retrieve(/*AuthenticatedUser authenticatedUser,*/ Long id);

    @ApiOperation(value = "List all by a specific authenticated user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List found by authenticated user informed")
    })
    List<DTOResponseSeal> retrieveAll(/*AuthenticatedUser authenticatedUser*/);

    @ApiOperation(value = "Update operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "By user successfully updated"),
            @ApiResponse(code = 404, message = "Not found error"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or already registered on system")
    })
    DTOResponseSeal update(/*AuthenticatedUser authenticatedUser,*/ UUID id, DTORequestSeal dTORequestSeal);

    @ApiOperation(value = "Delete operation")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "By user successfully deleted"),
            @ApiResponse(code = 404, message = "Not found error")
    })
    void delete(/*AuthenticatedUser authenticatedUser,*/ UUID id);
}