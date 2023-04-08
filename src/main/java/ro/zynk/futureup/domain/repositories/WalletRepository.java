package ro.zynk.futureup.domain.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.zynk.futureup.domain.dtos.Wallet;

import java.util.List;

@Repository
public interface WalletRepository extends PagingAndSortingRepository<Wallet, Long> {
    List<Wallet> findAll();
}
