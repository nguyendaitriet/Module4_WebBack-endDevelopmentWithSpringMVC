class Customer {
    constructor(id, fullName, email, phone, address, balance, deleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
        this.deleted = deleted;
    }
}

class Deposit {
    constructor(id, transactionAmount, createdAt, createdBy, updatedAt, updatedBy, deleted, customerId) {
        this.id = id;
        this.transactionAmount = transactionAmount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.deleted = deleted;
        this.customerId = customerId;
    }
}

class Withdraw {
    constructor(id, transactionAmount, createdAt, createdBy, updatedAt, updatedBy, deleted, customerId) {
        this.id = id;
        this.transactionAmount = transactionAmount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.deleted = deleted;
        this.customerId = customerId;
    }
}

class Transfer {
    constructor(id, transactionAmount, fees, feesAmount, transferAmount, senderId, recipientId, createdAt, createdBy, updatedAt, updatedBy, deleted, customerId) {
        this.id = id;
        this.transactionAmount = transactionAmount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.deleted = deleted;
        this.customerId = customerId;
        this.fees = fees;
        this.feesAmount = feesAmount;
        this.transferAmount = transferAmount;
        this.senderId = senderId;
        this.recipientId = recipientId;
    }
}