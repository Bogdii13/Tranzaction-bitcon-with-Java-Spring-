package ro.zynk.futureup.controllers.responses;

import java.util.List;

public class ListCoinTransactionResponse extends BaseResponse {
    private List<CoinTransactionResponse> coinTransactionResponses;

    public ListCoinTransactionResponse(List<CoinTransactionResponse> coinTransactionResponses) {
        this.coinTransactionResponses = coinTransactionResponses;
    }

    public List<CoinTransactionResponse> getCoinTransactionResponses() {
        return coinTransactionResponses;
    }

    public void setCoinTransactionResponses(List<CoinTransactionResponse> coinTransactionResponses) {
        this.coinTransactionResponses = coinTransactionResponses;
    }
}
