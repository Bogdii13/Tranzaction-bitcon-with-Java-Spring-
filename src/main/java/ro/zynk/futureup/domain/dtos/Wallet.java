package ro.zynk.futureup.domain.dtos;

import ro.zynk.futureup.controllers.responses.WalletResponse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wallets")
public class Wallet extends BaseEntity {

    @Column
    private String name;


    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CoinAmount> coinAmounts = new ArrayList<>();

    public Wallet(String name) {
        this.name = name;
    }

    public Wallet() {
    }

    public Wallet(WalletResponse walletResponse) {
        this.name = walletResponse.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CoinAmount> getCoinAmounts() {
        return coinAmounts;
    }

    public void setCoinAmounts(List<CoinAmount> coinAmounts) {
        this.coinAmounts = coinAmounts;
    }
}
