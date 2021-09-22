package com.example.PMS;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PmsRepository extends JpaRepository<PmsBean, String>,PmsRepositoryCustom{

}
