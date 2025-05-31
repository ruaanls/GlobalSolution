package com.example.globalsolution1.Repository;

import com.example.globalsolution1.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>
{
}
