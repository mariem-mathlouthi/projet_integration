package com.backendSpring.BackendSpring.Repository;

import com.backendSpring.BackendSpring.entity.Admin;
import com.backendSpring.BackendSpring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsByEmail(String email);

    @Query(value="select * from admins where user_id=:id",nativeQuery=true)
    Admin getAdminByIdUser(Long id);
}
