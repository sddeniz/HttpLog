package com.behsa.apigw;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestMessage, Long> {

}
