package ro.zynk.futureup.domain.dtos;

import ro.zynk.futureup.controllers.requests.CoinTransactionRequest;
import ro.zynk.futureup.controllers.responses.CoinResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coins")
public class Coin extends BaseEntity {

    @Column
    private String name;

    @Column
    private Double value;

    public Coin() {
    }

    public Coin(CoinResponse coin) {
        this.name = coin.getName();
        this.value = coin.getValue();
    }

    public Coin(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public Coin(Long id) {
        this.setId(id);
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
