package com.KrishiG.repositories;

import com.KrishiG.enitites.CustomerCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CustomerCart, Long> {
}
