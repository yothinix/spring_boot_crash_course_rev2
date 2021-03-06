package com.example.accountservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OddException extends RuntimeException {
    private String code;
    private String message;
}
