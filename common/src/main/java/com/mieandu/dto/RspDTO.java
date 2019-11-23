package com.mieandu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RspDTO {
    private Integer code;
    private String message;
}
