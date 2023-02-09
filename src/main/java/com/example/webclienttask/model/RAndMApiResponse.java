package com.example.webclienttask.model;

import java.util.List;

public record RAndMApiResponse(
        List<RAndMCharacter> results
) {
}
