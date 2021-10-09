package org.moneyfactory.controller;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.moneyfactory.model.Alert;
import org.moneyfactory.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/app")
@RestController
@CrossOrigin(maxAge = 9600)
@Log4j2
public class AppController {
    @Autowired
    AppService appService;

    @PostMapping(value = "/v1/add/symbol/")
    @ResponseBody
    @ResponseStatus
    public String searchApartment(@RequestParam(name = "symbol") String symbol) throws Exception {
        appService.addSymbol(symbol);
        return "symbol Added";
    }
    @PostMapping(value = "/v1/delete/symbol/")
    @ResponseBody
    @ResponseStatus
    public String searchApartment(@RequestParam(name = "symbol") String symbol) throws Exception {
        appService.delete(symbol);
        return "symbol Added";
    }

}
