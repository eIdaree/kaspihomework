package kz.eldar.product_service.productserviceflux.client;

import kz.eldar.product_service.productserviceflux.models.payload.delivery.CreateDeliveryRequestDto;
import kz.eldar.product_service.productserviceflux.models.payload.delivery.DeliveryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class DeliveryWebClient {

    private final WebClient deliveryWebClientBean;

    public Mono<DeliveryResponse> createDelivery(CreateDeliveryRequestDto requestDto){
        return deliveryWebClientBean.post()
                .uri("/api/v2/delivery")
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(DeliveryResponse.class)
                .doOnError(ex -> log.error("Error in delivery web client", ex));
    }


}
