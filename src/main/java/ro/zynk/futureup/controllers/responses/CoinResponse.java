package ro.zynk.futureup.controllers.responses;

import ro.zynk.futureup.domain.dtos.Coin;

public class CoinResponse extends BaseResponse {
    private Long id;
    private String name;
    private Double value;

    public CoinResponse(Coin coin) {
        this.id = coin.getId();
        this.name = coin.getName();
        this.value = coin.getValue();
    }

    public CoinResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
