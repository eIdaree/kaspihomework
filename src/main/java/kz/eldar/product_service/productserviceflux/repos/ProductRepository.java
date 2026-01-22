package kz.eldar.product_service.productserviceflux.repos;

import kz.eldar.product_service.productserviceflux.entities.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {

}
