package ro.zynk.futureup.controllers.responses;

import ro.zynk.futureup.domain.dtos.Wallet;

public class WalletResponse extends BaseResponse {
    private Long id;

    private String name;

    public WalletResponse() {
    }

    public WalletResponse(Wallet wallet) {
        this.id = wallet.getId();
        this.name = wallet.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
