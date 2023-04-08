package ro.zynk.futureup.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.zynk.futureup.domain.dtos.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByTotalValueGreaterThan(Double amountOfUsd);
}
