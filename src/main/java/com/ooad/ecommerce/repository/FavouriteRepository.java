package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.Favourite;
import com.ooad.ecommerce.model.FavouriteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteRepository extends JpaRepository<Favourite, FavouriteId> {}
