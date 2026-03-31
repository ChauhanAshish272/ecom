package com.ecommerce.backend.product.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Response Object of API response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto<T> {

    @Schema(description = "Success status of API", required = true)
    Boolean status = true;

    @Schema(description = "CallBack status of API", required = false)
    Boolean callBackStatus = false;

    @Schema(description = "Message received from API", required = true)
    String message;

    @Schema(description = "Data received from API. Its an generic object can return data of any type", required = true)
    T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Count of Objects received from API")
    Long count;


    public ResponseDto() {
    }

    public ResponseDto(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseDto(Boolean status, String message, T data, Object error) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseDto(Boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseDto(Boolean status, Boolean callBackStatus, String message, T data) {
        this.status = status;
        this.callBackStatus = callBackStatus;
        this.message = message;
        this.data = data;
    }


    void setErrorResponse(Throwable e, String message) {
        this.message = message == null || message.isEmpty() ? e.getMessage() : message;
        this.status = false;
    }

    public void setFailureResponse(String message) {
        this.message = message;
        this.status = false;
    }

    void setSuccessResponse(T data, String message) {
        this.message = message;
        this.data = data;
        this.status = true;
    }
}
