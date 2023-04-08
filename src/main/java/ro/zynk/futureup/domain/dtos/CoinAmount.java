package ro.zynk.futureup.domain.dtos;

import javax.persistence.*;

@Entity
@Table(name = "coin_amounts", uniqueConstraints = {@UniqueConstraint(columnNames = {"wallet_id", "coin_id"})})
public class CoinAmount extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "coin_id")
    private Coin coin;

    @Column
    private Double amount;

    public CoinAmount() {
    }

    public CoinAmount(Wallet wallet, Coin coin, Double amount) {
        this.wallet = wallet;
        this.coin = coin;
        this.amount = amount;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
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
}
