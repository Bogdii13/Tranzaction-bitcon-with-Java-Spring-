package ro.zynk.futureup.controllers.responses;

import java.util.List;

public class ListWalletResponse extends BaseResponse {
    private List<WalletResponse> walletResponses;

    public ListWalletResponse(List<WalletResponse> coinTransactionResponses) {
        this.walletResponses = coinTransactionResponses;
    }

    public List<WalletResponse> getWalletResponses() {
        return walletResponses;
    }

    public void setWalletResponses(List<WalletResponse> walletResponses) {
        this.walletResponses = walletResponses;
    }
}
