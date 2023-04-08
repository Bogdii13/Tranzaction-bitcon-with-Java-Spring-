package ro.zynk.futureup.controllers.responses;

import ro.zynk.futureup.domain.dtos.Transaction;

import java.util.Date;

public class TransactionResponse extends BaseResponse {

    private Long id;
    private Date transactionDate;
    private CoinResponse coin;
    private Double amount;
    private Double totalValue;

    public TransactionResponse(Date transactionDate, CoinResponse coin, Double amount) {
        this.transactionDate = transactionDate;
        this.coin = coin;
        this.amount = amount;
    }

    public TransactionResponse(Transaction transaction) {
        this.transactionDate = transaction.getTransactionDate();
        this.coin = new CoinResponse(transaction.getCoin());
        this.amount = transaction.getAmount();
        this.totalValue = transaction.getTotalValue();
        this.id = transaction.getId();
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public CoinResponse getCoin() {
        return coin;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public void setCoin(CoinResponse coin) {
        this.coin = coin;
    }

}
