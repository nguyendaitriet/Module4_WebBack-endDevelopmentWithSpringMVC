package com.banking.model.dto;

import com.banking.model.Customer;
import com.banking.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CustomerDTO {

    private Long id;

    @NotEmpty(message = "Name must NOT be empty.")
    @Length(min = 1, max = 150,
            message = "Max characters of name: 150.")
    @Pattern(regexp = "^[A-Za-z\\s]*",
            message = "Name contains only letter and whitespace.")
    private String fullName;

    @NotEmpty(message = "Email must NOT be empty.")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z\\d_-]+(\\.[A-Za-z\\d_-]+)*@[^-][A-Za-z\\d-]+(\\.[A-Za-z\\d-]+)*(\\.[A-Za-z]{2,})$",
            message = "Invalid email address. Valid email example: john_11@gmail.com")
    private String email;

    @NotEmpty(message = "Phone number must NOT be empty.")
    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$",
            message = "Incorrect phone number format. Correct format: +1 (608) 468-6527.")
    private String phone;

    private BigDecimal balance;

    @Valid
    LocationDTO location;

    public CustomerDTO(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public CustomerDTO(Long id, String fullName, String email, String phone, BigDecimal balance, Location location) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.location = location.toLocationDTO();
    }

    public Customer toCustomer() {
        return new Customer()
                .setFullName(this.fullName)
                .setEmail(this.email)
                .setPhone(this.phone)
                .setLocation(this.location.toLocation());
    }

}
