package com.institutohidrografico.application.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

public interface ControllerGeneric<Q,P,K> {

    @ApiOperation(value = "Create")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "${response.201}"),
            @ApiResponse(code = 400, message = "${response.400}")
    })
    public abstract P create(/*AuthenticatedUser authenticatedUser,*/ Q dtoRequest);

    @ApiOperation(value = "Find by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "${response.200}"),
            @ApiResponse(code = 404, message = "${response.404}")
    })
    public abstract P retrieve(/*AuthenticatedUser authenticatedUser,*/ K id);

    @ApiOperation(value = "Find all")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "${response.200}")
    })
    public abstract List<P> retrieve(/*AuthenticatedUser authenticatedUser,*/);

    @ApiOperation(value = "Update")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "${response.200}"),
            @ApiResponse(code = 400, message = "${response.400}"),
            @ApiResponse(code = 404, message = "${response.404}")

    })
    public abstract P update(/*AuthenticatedUser authenticatedUser,*/ K id, Q object);

    @ApiOperation(value = "Delete")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "${response.204}")
    })
    public abstract void delete();

    @ApiOperation(value = "Delete by id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "${response.204}"),
            @ApiResponse(code = 404, message = "${response.404}")
    })
    public abstract void delete(/*AuthenticatedUser authenticatedUser,*/ K id);
}