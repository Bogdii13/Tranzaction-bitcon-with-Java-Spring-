package ro.zynk.futureup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.zynk.futureup.controllers.requests.CoinExchangeRequest;
import ro.zynk.futureup.controllers.requests.CoinTransactionRequest;
import ro.zynk.futureup.controllers.responses.*;
import ro.zynk.futureup.domain.dtos.Coin;
import ro.zynk.futureup.domain.dtos.Transaction;
import ro.zynk.futureup.exceptions.NotFoundException;
import ro.zynk.futureup.services.TransactionService;
import ro.zynk.futureup.services.WalletService;

import java.util.Date;


@RestController
@RequestMapping("/wallets")
public class WalletController {
    private final WalletService walletService;
    private final TransactionService transactionService;

    @Autowired
    public WalletController(WalletService walletService, TransactionService transactionService) {
        this.walletService = walletService;
        this.transactionService = transactionService;
    }

    @PostMapping(value = "")
    public ResponseEntity<BaseResponse> saveWallet(@RequestBody WalletResponse walletResponse) {
        return new ResponseEntity<>(walletService.saveNewWallet(walletResponse), HttpStatus.OK);
    }


    @GetMapping(value = "")
    public ResponseEntity<BaseResponse> getWallets() {
        try {
            return new ResponseEntity<>(walletService.getWallets(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BaseResponse> getWalletById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(walletService.getWallet(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/buy_coin")
    public ResponseEntity<BaseResponse> buyCoin(@RequestBody CoinTransactionRequest buyCoinRequest) {
        try {
            transactionService.saveTransaction(new TransactionResponse(
                    new Date(),
                    new CoinResponse(buyCoinRequest.getCoinId()),
                    Double.valueOf(buyCoinRequest.getAmount())
            ));
            return new ResponseEntity<>(walletService.buyCoin(buyCoinRequest), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/exchange_coin")
    public ResponseEntity<BaseResponse> exchangeCoin(@RequestBody CoinExchangeRequest coinExchangeRequest) {
        try {
            return new ResponseEntity<>(walletService.exchangeCoin(coinExchangeRequest), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get_all_owned_coins/{walletId}")
    public ResponseEntity<BaseResponse> getAllOwnedCoinsFromWallet(@PathVariable("walletId") Long walletId) {
        try {
            return new ResponseEntity<>(walletService.getAllCoinsFromWallet(walletId), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_all_coins_usd")
    public ResponseEntity<BaseResponse> getAllCoinsFromWalletInUsd(@RequestParam Long walletId) {
//        try {
//            return new ResponseEntity<>(walletService.getAllCoinsFromWalletInUsd(walletId), HttpStatus.OK);
//        }
//        catch (NotFoundException e) {
//            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
//        }
        return ResponseEntity.ok(walletService.getAllCoinsFromWalletInUsd(walletId));
    }
}
