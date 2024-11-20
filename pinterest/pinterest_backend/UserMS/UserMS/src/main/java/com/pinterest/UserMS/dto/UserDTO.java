package com.pinterest.UserMS.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class UserDTO {
	@NotNull
	@Pattern(regexp = "[a-zA-z]+[0-9a-zA-Z]*")
	@Length(min = 4)
	private String username;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Min(value = 1000000000L)
	@Min(value = 9999999999L)
	private Long phoneNumber;
}
