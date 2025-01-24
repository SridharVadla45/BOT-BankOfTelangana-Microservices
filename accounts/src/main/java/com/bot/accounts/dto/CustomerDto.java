package com.bot.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(
        name = "Customer",
        description = "Customer details "
)
public class CustomerDto {

    @NotEmpty(message = "Name cannot be empty")
    @Schema(description = "Name of the Customer",example = "sridhar")
    private String name;

    @NotEmpty(message = "Email cannot be empty ")
    @Email(message = "Invalid email address")
    @Schema(description = "Customer Email Address",example = "example@gmail.com")
    private String email;

    @NotEmpty(message = "Mobile number cannot be empty ")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
    @Schema(description = "Customer mobile number" ,example = "9988776655")
    private String mobileNumber;



}
