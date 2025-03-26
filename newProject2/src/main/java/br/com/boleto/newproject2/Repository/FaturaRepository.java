package br.com.boleto.newproject2.Repository;

import br.com.boleto.newproject2.Model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long> {
}
