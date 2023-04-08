package ro.zynk.futureup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.zynk.futureup.controllers.responses.ListTransactionResponse;
import ro.zynk.futureup.controllers.responses.TransactionResponse;
import ro.zynk.futureup.domain.dtos.Coin;
import ro.zynk.futureup.domain.dtos.Transaction;
import ro.zynk.futureup.domain.repositories.CoinRepository;
import ro.zynk.futureup.domain.repositories.TransactionRepository;
import ro.zynk.futureup.exceptions.NotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CoinRepository coinRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository,
                              CoinRepository coinRepository) {
        this.transactionRepository = transactionRepository;
        this.coinRepository = coinRepository;
    }


    public void saveTransaction(TransactionResponse transactionResponse) {
        Optional<Coin> optionalCoin = coinRepository
                .findById(transactionResponse.getCoin().getId());
        if (optionalCoin.isEmpty())
            throw new NotFoundException("Coin not found");
        Coin coin = optionalCoin.get();
        transactionResponse.setTotalValue
                (coin.getValue() * transactionResponse.getAmount());
        Transaction transaction = new Transaction(transactionResponse);
        transactionRepository.save(transaction);
    }


    public ListTransactionResponse findAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionResponse> transactionResponses = new ArrayList<>();

        for (Transaction t : transactions)
            transactionResponses.add(new TransactionResponse(t));

        return new ListTransactionResponse(transactionResponses);

    }

    /**
     * finds a list of TransactionResponse greater than amountOfUsd
     *
     * @param amountOfUsd the ammount of US dollars
     * @return the list of TransactionResponse
     */
    public ListTransactionResponse findAllByTotalValueGreaterThan(Double amountOfUsd) {
        List<Transaction> transactions = transactionRepository.findAllByTotalValueGreaterThan(amountOfUsd);
        List<TransactionResponse> transactionResponses = new ArrayList<>();

        for (Transaction t : transactions)
            transactionResponses.add(new TransactionResponse(t));

        return new ListTransactionResponse(transactionResponses);
    }
}