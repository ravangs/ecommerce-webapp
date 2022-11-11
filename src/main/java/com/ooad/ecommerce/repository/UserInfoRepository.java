package com.ooad.ecommerce.repository;

import com.ooad.ecommerce.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
}