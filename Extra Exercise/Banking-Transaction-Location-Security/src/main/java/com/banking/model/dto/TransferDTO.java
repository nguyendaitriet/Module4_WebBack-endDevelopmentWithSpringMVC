package com.banking.model.dto;

import com.banking.model.Customer;
import com.banking.model.Transfer;
import com.banking.service.TransferService;
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
public class TransferDTO implements Validator {

    private String senderId;
    private String recipientId;
    private String transferAmount;

    @Override
    public boolean supports(Class<?> clazz) {
        return TransferDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        TransferDTO transferDTO = (TransferDTO) target;
        String senderId = transferDTO.getSenderId();
        String recipientId = transferDTO.getRecipientId();
        String transferAmount = transferDTO.getTransferAmount();

        if (recipientId == null || recipientId.equals("")) {
            errors.rejectValue("recipientId","400", ErrorMessage.RECIPIENT_NOT_EMPTY);
        }
        else {
            boolean isRecipientId = java.util.regex.Pattern.matches("\\d+", recipientId);
            if (!isRecipientId) {
                errors.rejectValue("recipientId","400", ErrorMessage.RECIPIENT_NOT_EXIST);
            }
        }

        if (senderId == null || senderId.equals("")) {
            errors.rejectValue("senderId", "400",ErrorMessage.SENDER_NOT_EMPTY);
        }
        else {
            boolean isSenderId = java.util.regex.Pattern.matches("\\d+", recipientId);
            if (!isSenderId) {
                errors.rejectValue("senderId", "400", ErrorMessage.SENDER_NOT_EXIST);
            }
        }

        if (transferAmount == null || transferAmount.equals("")) {
            errors.rejectValue("transferAmount", "400", ErrorMessage.EMPTY_TRANSFER_AMOUNT);
            return;
        }

        boolean isTransferAmountValid = java.util.regex.Pattern.matches("\\d+", transferAmount);
        if (!isTransferAmountValid) {
            errors.rejectValue("transferAmount", "400",ErrorMessage.INVALID_AMOUNT_FORMAT);
            return;
        }

        if (transferAmount.length() > 12) {
            errors.rejectValue("transferAmount","400", ErrorMessage.MAX_AMOUNT_LENGTH);
            return;
        }

        long validTransferAmount = Long.parseLong(transferAmount);
        if (validTransferAmount < 100) {
            errors.rejectValue("transferAmount", "400", ErrorMessage.MINIMUM_TRANSACTION_AMOUNT);
            return;
        }

        if (validTransferAmount > 50000000) {
            errors.rejectValue("transferAmount", "400",ErrorMessage.MAXIMUM_TRANSACTION_AMOUNT);
        }

    }

    public Transfer toTransfer(TransferDTO transferDTO, Customer sender, Customer recipient) {
        return new Transfer()
                .setSender(sender)
                .setRecipient(recipient)
                .setFees(TransferService.fees)
                .setTransferAmount(new BigDecimal(transferDTO.getTransferAmount()));
    }
}
