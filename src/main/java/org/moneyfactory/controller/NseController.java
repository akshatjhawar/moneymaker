package org.moneyfactory.controller;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.moneyfactory.model.Alert;
import org.moneyfactory.service.CronService;
import org.moneyfactory.service.NseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/nse")
@RestController
@CrossOrigin(maxAge = 9600)
@Log4j2
public class NseController {

    @Autowired
    NseRestService nseRestService;
    @Autowired
    CronService cronService;
    @RequestMapping(value = "/v1/add/alert/", method = RequestMethod.POST)
    @ResponseStatus
    public String searchApartment(@RequestBody String body) throws Exception {
        Gson gson = new Gson();
        cronService.updateAlerts(gson.fromJson(body, Alert.class));
        return "Alert Added";
    }
}
