package kz.eldar.kaspihomework.kaspihomework.feign;

import kz.eldar.kaspihomework.kaspihomework.models.payload.delivery.CreateDeliveryRequestDto;
import kz.eldar.kaspihomework.kaspihomework.models.payload.delivery.DeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "delivery-service", url = "http://localhost:8081")
public interface DeliveryClient {

    @PostMapping("/api/v1/delivery")
    DeliveryResponse createDelivery(CreateDeliveryRequestDto request);
}
