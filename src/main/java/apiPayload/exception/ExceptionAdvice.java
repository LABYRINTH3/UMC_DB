package apiPayload.exception;

import apiPayload.ApiResponse;
import apiPayload.code.ErrorReasonDTO;
import apiPayload.code.status.ErrorStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ExceptionAdvice extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {

    /** Validation 에러(@Validated 등) **/
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex,
            WebRequest request) {

        // 가장 첫 번째 메시지만 추출
        String errorMessage = ex.getConstraintViolations().stream()
                .map(cv -> cv.getMessage())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("ConstraintViolationException 메시지 추출 실패"));

        // 메시지를 에러 코드(enum 이름과 일치시켜 사용)
        ErrorStatus status = ErrorStatus.valueOf(errorMessage);
        return handleExceptionInternalConstraint(
                ex,
                status,
                HttpHeaders.EMPTY,
                request
        );
    }

    /** @Valid 실패 시 **/
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        Map<String, String> errors = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fe -> {
            String field = fe.getField();
            String msg = Optional.ofNullable(fe.getDefaultMessage()).orElse("");
            errors.merge(field, msg, (oldV, newV) -> oldV + ", " + newV);
        });

        return handleExceptionInternalArgs(
                ex,
                HttpHeaders.EMPTY,
                ErrorStatus.COMMON_BAD_REQUEST,
                request,
                errors
        );
    }

    /** 그 외 모든 예외 **/
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(
            Exception ex,
            WebRequest request) {

        log.error("Unhandled exception: ", ex);
        return handleExceptionInternalFalse(
                ex,
                ErrorStatus.COMMON_INTERNAL_SERVER_ERROR,
                HttpHeaders.EMPTY,
                ErrorStatus.COMMON_INTERNAL_SERVER_ERROR.getHttpStatus(),
                request,
                ex.getMessage()
        );
    }

    /** 우리가 던진 GeneralException **/
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Object> handleGeneralException(
            GeneralException ex,
            HttpServletRequest request) {

        ErrorReasonDTO reason = ex.getErrorReasonHttpStatus();
        return handleExceptionInternal(
                ex,
                reason,
                null,
                request
        );
    }

    // ---- 내부 헬퍼 메소드들 ----

    private ResponseEntity<Object> handleExceptionInternal(
            Exception ex,
            ErrorReasonDTO reason,
            HttpHeaders headers,
            HttpServletRequest request) {

        ApiResponse<Object> body = ApiResponse.onFailure(
                reason.getCode(),
                reason.getMessage(),
                null
        );
        return super.handleExceptionInternal(
                ex,
                body,
                headers != null ? headers : HttpHeaders.EMPTY,
                reason.getHttpStatus(),
                new ServletWebRequest(request)
        );
    }

    private ResponseEntity<Object> handleExceptionInternalFalse(
            Exception ex,
            ErrorStatus status,
            HttpHeaders headers,
            org.springframework.http.HttpStatus httpStatus,
            WebRequest request,
            String errorPoint) {

        ApiResponse<Object> body = ApiResponse.onFailure(
                status.getCode(),
                status.getMessage(),
                errorPoint
        );
        return super.handleExceptionInternal(
                ex,
                body,
                headers,
                httpStatus,
                request
        );
    }

    private ResponseEntity<Object> handleExceptionInternalArgs(
            Exception ex,
            HttpHeaders headers,
            ErrorStatus status,
            WebRequest request,
            Map<String, String> errorArgs) {

        ApiResponse<Object> body = ApiResponse.onFailure(
                status.getCode(),
                status.getMessage(),
                errorArgs
        );
        return super.handleExceptionInternal(
                ex,
                body,
                headers,
                status.getHttpStatus(),
                request
        );
    }

    private ResponseEntity<Object> handleExceptionInternalConstraint(
            Exception ex,
            ErrorStatus status,
            HttpHeaders headers,
            WebRequest request) {

        ApiResponse<Object> body = ApiResponse.onFailure(
                status.getCode(),
                status.getMessage(),
                null
        );
        return super.handleExceptionInternal(
                ex,
                body,
                headers,
                status.getHttpStatus(),
                request
        );
    }
}
