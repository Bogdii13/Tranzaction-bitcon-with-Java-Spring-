package ro.zynk.futureup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.zynk.futureup.controllers.responses.BaseResponse;
import ro.zynk.futureup.controllers.responses.CoinResponse;
import ro.zynk.futureup.controllers.responses.ErrorResponse;
import ro.zynk.futureup.exceptions.DuplicateEntityException;
import ro.zynk.futureup.services.CoinService;
import ro.zynk.futureup.services.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/coins")
public class CoinController {
    private final CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping(value = "/all_coins")
    public List<CoinResponse> getAllCoins() {
        return coinService.getAllCoins();
    }

    @PostMapping(value = "")
    public ResponseEntity<BaseResponse> saveNewCoin(@RequestBody CoinResponse coinResponse) {
        try {
            return new ResponseEntity<>(coinService.saveNewCoin(coinResponse), HttpStatus.OK);
        } catch (DuplicateEntityException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
