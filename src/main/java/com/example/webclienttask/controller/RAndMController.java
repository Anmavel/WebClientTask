package com.example.webclienttask.controller;

import com.example.webclienttask.model.RAndMCharacter;
import com.example.webclienttask.service.RAndMApiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RAndMController {

    private RAndMApiService rickAndMortyApiService;

    @GetMapping("allCharacters")
    public List<RAndMCharacter> getAllCharacters(){
        return rickAndMortyApiService.getAllCharacters();

    }

    @GetMapping("aliveCharacters")
    public List<RAndMCharacter> aliveCharacters(){
        return rickAndMortyApiService.getLivingCharacters();
    }

}
