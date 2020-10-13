package lt.ivl.components.domain;

public enum RepairStatus {
    PENDING("Laukiama", "Laukiama"),
    CONFIRMED("Patvirtinta", "Vykdoma"),
    DIAGNOSTIC_WAITING("Laukiama diagnostikos", "Vykdoma");

    private String messageForCustomer;
    private String messageForEmployee;

    RepairStatus() {
    }

    RepairStatus(String messageForEmployee, String messageForCustomer) {
        this.messageForCustomer = messageForCustomer;
        this.messageForEmployee = messageForEmployee;
    }

    public String getMessageForCustomer() {
        return messageForCustomer;
    }


    public String getMessageForEmployee() {
        return messageForEmployee;
    }
}
