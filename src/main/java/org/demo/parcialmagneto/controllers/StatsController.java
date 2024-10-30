package org.demo.parcialmagneto.controllers;

import org.demo.parcialmagneto.dto.StatsResponse;
import org.demo.parcialmagneto.services.StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/stats")
public class StatsController {

   private final StatsService statsService;

   public StatsController(StatsService statsService){
       this.statsService = statsService;
   }

   @GetMapping
    public StatsResponse getStats(){
       return statsService.getStats();
   }

}
