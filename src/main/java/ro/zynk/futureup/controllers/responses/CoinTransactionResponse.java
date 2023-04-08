package ro.zynk.futureup.controllers.responses;

import ro.zynk.futureup.domain.dtos.CoinAmount;

public class CoinTransactionResponse extends BaseResponse {
    private CoinResponse coinResponse;
    private WalletResponse walletResponse;
    private Double amount;

    public CoinTransactionResponse() {
    }

    public CoinTransactionResponse(CoinResponse coinResponse, WalletResponse walletResponse, Double amount) {
        this.coinResponse = coinResponse;
        this.walletResponse = walletResponse;
        this.amount = amount;
    }

    public CoinTransactionResponse(CoinAmount coinAmount) {
        this.coinResponse = new CoinResponse(coinAmount.getCoin());
        this.walletResponse = new WalletResponse(coinAmount.getWallet());
        this.amount = coinAmount.getAmount();
    }

    public CoinResponse getCoinResponse() {
        return coinResponse;
    }

    public void setCoinResponse(CoinResponse coinResponse) {
        this.coinResponse = coinResponse;
    }

    public WalletResponse getWalletResponse() {
        return walletResponse;
    }

    public void setWalletResponse(WalletResponse walletResponse) {
        this.walletResponse = walletResponse;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
