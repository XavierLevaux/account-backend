package com.mybank.account.web;

import com.mybank.account.api.AccountsApi;
import com.mybank.account.api.model.Account;
import com.mybank.account.api.model.AllOfaccountType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountsController implements AccountsApi {


    @Override
    @Operation(summary = "Get the properties of an account.", description = "Use this operation to update properties of an account.", security = {
            @SecurityRequirement(name = "basicAuth")    }, tags={ "Accounts" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account retrieved successfully.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class))) })
    @RequestMapping(value = "/accounts/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@Parameter(in = ParameterIn.PATH, description = "Id of the account", required=true, schema=@Schema()) @PathVariable("id") String id) {
        AllOfaccountType allOfaccountType = new AllOfaccountType();
        allOfaccountType.setCodeId("PA65");
        allOfaccountType.setCodeId("1");
        Account account = new Account()
                .id(id)
                .type(allOfaccountType)
                .iban("BE68 5390 0754 7034");

        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
