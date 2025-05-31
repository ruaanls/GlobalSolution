package com.example.globalsolution1.Repository;

import com.example.globalsolution1.Model.DadosChuva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosChuvaRepository extends JpaRepository<DadosChuva, Long>
{
}
