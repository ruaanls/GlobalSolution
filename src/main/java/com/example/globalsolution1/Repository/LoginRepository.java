package com.example.globalsolution1.Repository;

import com.example.globalsolution1.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long>
{
}
