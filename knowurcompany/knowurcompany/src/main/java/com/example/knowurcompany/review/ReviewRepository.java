package com.example.knowurcompany.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews,Long> {

    List<Reviews> findByCompanyId(Long companyId);


}
