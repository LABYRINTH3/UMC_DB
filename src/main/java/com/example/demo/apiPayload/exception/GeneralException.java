package com.example.demo.apiPayload.exception;

import com.example.demo.apiPayload.code.BaseErrorCode;
import com.example.demo.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private final BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return code.getReasonHttpStatus();
    }
}