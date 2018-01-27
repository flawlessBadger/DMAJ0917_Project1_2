package modellayer;

public enum Payment {
    CASH ("Cash"), CARD("Credit card"), VOUCHER("Shop voucher");

    private String name = "";
    private Payment(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
