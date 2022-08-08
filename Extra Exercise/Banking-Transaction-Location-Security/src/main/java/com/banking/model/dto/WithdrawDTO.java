package com.banking.model.dto;

import com.banking.model.Withdraw;
import com.banking.util.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WithdrawDTO implements Validator {

    private String fullName;
    private String email;
    private BigDecimal balance;
    private String transactionAmount;

    @Override
    public boolean supports(Class<?> clazz) {
        return Withdraw.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        WithdrawDTO withdrawDTO = (WithdrawDTO) target;
        String transactionAmount = withdrawDTO.getTransactionAmount();

        if (transactionAmount == null || transactionAmount.equals("")) {
            errors.rejectValue("transactionAmount", "400", ErrorMessage.EMPTY_AMOUNT);
            return;
        }

        boolean isTransactionAmountValid = java.util.regex.Pattern.matches("\\d+", transactionAmount);
        if (!isTransactionAmountValid) {
            errors.rejectValue("transactionAmount", "400",ErrorMessage.INVALID_AMOUNT_FORMAT);
            return;
        }

        if (transactionAmount.length() > 12) {
            errors.rejectValue("transactionAmount","400", ErrorMessage.MAX_AMOUNT_LENGTH);
            return;
        }

        long validTransactionAmount = Long.parseLong(transactionAmount);
        if (validTransactionAmount < 100) {
            errors.rejectValue("transactionAmount", "400", ErrorMessage.MINIMUM_TRANSACTION_AMOUNT);
            return;
        }

        if (validTransactionAmount > 50000000) {
            errors.rejectValue("transactionAmount", "400",ErrorMessage.MAXIMUM_TRANSACTION_AMOUNT);
        }

    }
}
