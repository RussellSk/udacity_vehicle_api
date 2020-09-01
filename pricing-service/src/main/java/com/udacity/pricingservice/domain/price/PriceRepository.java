package com.udacity.pricingservice.domain.price;

import com.udacity.pricingservice.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

}
