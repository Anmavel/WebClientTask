package com.example.webclienttask.service;

import com.example.webclienttask.model.RAndMApiResponse;
import com.example.webclienttask.model.RAndMCharacter;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class RAndMApiService {

    private WebClient webClient = WebClient.create("https://rickandmortyapi.com/api");

    public List<RAndMCharacter> getAllCharacters() {
        RAndMApiResponse rAndMApiResponse = Objects.requireNonNull(webClient
                        .get()
                        .uri("/character")
                        .retrieve()
                        .toEntity(RAndMApiResponse.class)
                        .block())
                .getBody();
        return rAndMApiResponse.results();

    }

    public List<RAndMCharacter> getLivingCharacters() {
        RAndMApiResponse rAndMApiResponse = Objects.requireNonNull(webClient
                        .get()
                        .uri(uriBuilder -> uriBuilder
                                        .path("/character")
                                        .queryParam("status", "Alive")
                                        .build())
                        .retrieve().toEntity(RAndMApiResponse.class)
                        .block())
                .getBody();
        return rAndMApiResponse.results();

    }






}
