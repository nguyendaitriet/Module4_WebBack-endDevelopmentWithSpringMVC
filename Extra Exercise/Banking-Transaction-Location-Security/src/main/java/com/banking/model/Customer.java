package com.banking.model;

import com.banking.model.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(precision = 12, columnDefinition = "decimal default 0")
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    public CustomerDTO toCustomerDTO () {
        return new CustomerDTO()
                .setId(this.id)
                .setFullName(this.fullName)
                .setEmail(this.email)
                .setPhone(this.phone)
                .setBalance(this.balance)
                .setLocation(this.location.toLocationDTO());
    }

}

