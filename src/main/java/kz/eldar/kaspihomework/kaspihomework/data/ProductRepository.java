package kz.eldar.kaspihomework.kaspihomework.data;

import kz.eldar.kaspihomework.kaspihomework.business.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
