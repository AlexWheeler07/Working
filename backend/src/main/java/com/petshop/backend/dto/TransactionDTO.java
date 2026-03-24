package com.petshop.backend.dto;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long transactionId;
    private Long customerId;
    private Long petId;
    private Date transactionDate;
    private Double amount;
    private String transactionStatus;



}
