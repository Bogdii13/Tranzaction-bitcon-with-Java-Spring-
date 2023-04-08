package ro.zynk.futureup.controllers.responses;

import java.util.List;

public class ListTransactionResponse extends BaseResponse {

    private List<TransactionResponse> transactionResponses;

    public ListTransactionResponse(List<TransactionResponse> transactionResponses) {
        this.transactionResponses = transactionResponses;
    }

    public List<TransactionResponse> getTransactionResponses() {
        return transactionResponses;
    }

    public void setTransactionResponses(List<TransactionResponse> transactionResponses) {
        this.transactionResponses = transactionResponses;
    }
}
