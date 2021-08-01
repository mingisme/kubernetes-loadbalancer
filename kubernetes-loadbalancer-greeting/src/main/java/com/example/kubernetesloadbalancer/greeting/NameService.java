package com.example.kubernetesloadbalancer.greeting;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NameService {

    private final WebClient webClient;


    public NameService(WebClient.Builder webClientBuilder) {
        webClient = webClientBuilder.build();
    }

    public Mono<String> getName(int delay) {
        return webClient.get().uri(String.format("http://name-service/name?delay=%d", delay)).retrieve()
                .bodyToMono(String.class);
    }

}
