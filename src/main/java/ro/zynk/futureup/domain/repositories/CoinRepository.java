package ro.zynk.futureup.domain.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.zynk.futureup.domain.dtos.Coin;

import java.util.Optional;

@Repository
public interface CoinRepository extends PagingAndSortingRepository<Coin, Long> {
    Optional<Coin> findByName(String name);

}
