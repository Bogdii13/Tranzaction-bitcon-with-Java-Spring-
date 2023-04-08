package ro.zynk.futureup.domain.dtos;

import ro.zynk.futureup.controllers.responses.TransactionResponse;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {

    private Date transactionDate;

    @ManyToOne
    private Coin coin;
    private Double amount;
    private Double totalValue;

    public Transaction() {}

    public Transaction(TransactionResponse transactionResponse) {
        this.transactionDate = transactionResponse.getTransactionDate();
        this.amount = transactionResponse.getAmount();
        this.totalValue = transactionResponse.getTotalValue();
        this.coin = new Coin(transactionResponse.getCoin().getId());
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
