package com.echappeebelle.vehicle.web.controller;

import com.echappeebelle.vehicle.web.model.finalPrice.FinalPrice;
import com.echappeebelle.vehicle.web.service.finalPrice.FinalPriceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FinalPriceController {

    private FinalPriceService finalPriceService;

    public FinalPriceController(FinalPriceService finalPriceService) {
        this.finalPriceService = finalPriceService;
    }

    @PostMapping("/final-price-in-cents-calculation")
    public int calculateFinalPrice(@RequestBody FinalPrice finalPrice) {
        return finalPriceService.calculateFinalPrice(finalPrice);
    }


}