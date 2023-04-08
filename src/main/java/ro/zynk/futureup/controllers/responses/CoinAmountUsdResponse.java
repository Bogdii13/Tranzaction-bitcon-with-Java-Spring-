package ro.zynk.futureup.controllers.responses;

public class CoinAmountUsdResponse extends BaseResponse {

    public Double value;

    public CoinAmountUsdResponse(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}
