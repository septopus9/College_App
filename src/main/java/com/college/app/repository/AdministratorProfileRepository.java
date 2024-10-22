package com.college.app.repository;

import com.college.app.model.AdministratorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorProfileRepository extends JpaRepository<AdministratorProfile,Long> {
}
