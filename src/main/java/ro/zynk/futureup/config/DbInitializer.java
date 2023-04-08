package ro.zynk.futureup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.zynk.futureup.domain.dtos.Coin;
import ro.zynk.futureup.domain.dtos.CoinAmount;
import ro.zynk.futureup.domain.dtos.Wallet;
import ro.zynk.futureup.domain.repositories.CoinAmountRepository;
import ro.zynk.futureup.domain.repositories.CoinRepository;
import ro.zynk.futureup.domain.repositories.WalletRepository;

import javax.annotation.PostConstruct;

@Component
public class DbInitializer {
    private final CoinRepository coinRepository;
    private final WalletRepository walletRepository;

    @Autowired
    public DbInitializer(CoinRepository coinRepository, WalletRepository walletRepository, CoinAmountRepository coinAmountRepository) {
        this.coinRepository = coinRepository;
        this.walletRepository = walletRepository;
    }

    @PostConstruct
    public void initializer() {
        Wallet wallet = new Wallet("Wallet Andrei");
        walletRepository.save(wallet);
        Coin coinBTC = new Coin("Bitcoin", 41657.58);
        coinRepository.save(coinBTC);
        Coin coinETH = new Coin("Ethereum", 2894.94);
        coinRepository.save(coinETH);
        Coin coinBNB = new Coin("BNB", 393.32);
        coinRepository.save(coinBNB);
        CoinAmount coinAmountBTC = new CoinAmount(wallet, coinBTC, 2d);
        CoinAmount coinAmountETH = new CoinAmount(wallet, coinETH, 3d);
        CoinAmount coinAmountBNB = new CoinAmount(wallet, coinBNB, 100.2d);
        wallet.getCoinAmounts().add(coinAmountBNB);
        wallet.getCoinAmounts().add(coinAmountBTC);
        wallet.getCoinAmounts().add(coinAmountETH);
        walletRepository.save(wallet);

    }
}
