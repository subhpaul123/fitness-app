package com.fitness.aiservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class GeminiService {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public GeminiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

//    public String getAnswer(String question) {
//        Map<String, Object> requestBody = Map.of(
//                "contents", new Object[] {
//                        Map.of("parts", new Object[]{
//                                Map.of("text", question)
//                        })
//                }
//        );
//
//        return webClient.post()
//                .uri(geminiApiUrl + geminiApiKey)
//                .header("Content-Type", "application/json")
//                .bodyValue(requestBody)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//    }
public String getAnswer(String question) {
    Map<String, Object> requestBody = Map.of(
            "contents", new Object[] {
                    Map.of("parts", new Object[]{
                            Map.of("text", question)
                    })
            }
    );

    // Log the request body for debugging
    System.out.println("Request Body: " + requestBody);
//    System.out.println("API Key: " + geminiApiKey);
//    System.out.println("URL: " + geminiApiUrl);

    return webClient.post()
            .uri(geminiApiUrl + geminiApiKey)
            .header("Content-Type", "application/json")
            .bodyValue(requestBody)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError, clientResponse ->
                    clientResponse.bodyToMono(String.class)
                            .flatMap(errorBody -> {
                                System.err.println("Error response: " + errorBody); // Log error response
                                return Mono.error(new RuntimeException("API call failed: " + errorBody));
                            })
            )
            .bodyToMono(String.class)
            .block();
}

}