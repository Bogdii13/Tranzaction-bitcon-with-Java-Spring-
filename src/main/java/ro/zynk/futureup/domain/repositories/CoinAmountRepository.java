package ro.zynk.futureup.domain.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.zynk.futureup.domain.dtos.Coin;
import ro.zynk.futureup.domain.dtos.CoinAmount;
import ro.zynk.futureup.domain.dtos.Wallet;

import java.util.List;

@Repository
public interface CoinAmountRepository extends PagingAndSortingRepository<CoinAmount, Long> {
    List<CoinAmount> findAllByWallet(Wallet wallet);

    CoinAmount findByWalletAndCoin(Wallet wallet, Coin coin);

}
