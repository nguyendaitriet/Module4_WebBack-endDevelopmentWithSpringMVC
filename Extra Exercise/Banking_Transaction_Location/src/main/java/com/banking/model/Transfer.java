package com.banking.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "transfers")
public class Transfer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 12)
    private BigDecimal transferAmount;

    @Column(nullable = false, precision = 12)
    private BigDecimal transactionAmount;

    @Column(nullable = false)
    private int fees;

    @Column(precision = 12)
    private BigDecimal feesAmount;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private  Customer sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private  Customer recipient;

    public Transfer(Long id, BigDecimal transferAmount, int fees, BigDecimal feesAmount, Customer sender, Customer recipient, Date createdAt) {
        super(createdAt);
        this.id = id;
        this.transferAmount = transferAmount;
        this.fees = fees;
        this.feesAmount = feesAmount;
        this.sender = sender;
        this.recipient = recipient;
    }

}
