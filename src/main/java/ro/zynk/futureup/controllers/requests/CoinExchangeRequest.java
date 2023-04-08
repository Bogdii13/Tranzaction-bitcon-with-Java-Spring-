package ro.zynk.futureup.controllers.requests;

public class CoinExchangeRequest {
    private Long coinId;
    // coin amount entity from which you use funds to buy the coin
    private Long coinAmountId;
    private Float amount;

    public Long getCoinId() {
        return coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }

    public Long getCoinAmountId() {
        return coinAmountId;
    }

    public void setCoinAmountId(Long coinAmountId) {
        this.coinAmountId = coinAmountId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
