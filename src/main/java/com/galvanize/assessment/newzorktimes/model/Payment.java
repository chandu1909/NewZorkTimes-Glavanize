package com.galvanize.assessment.newzorktimes.model;

public class Payment {

    private String amount;
    private String currency;
    private String source;
    private String desciption;

    public Payment() {

    }

    public Payment(String amount, String currency, String source, String desciption) {
        this.amount = amount;
        this.currency = currency;
        this.source = source;
        this.desciption = desciption;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
