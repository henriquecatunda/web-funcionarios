package br.ufc.funcionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import br.ufc.funcionarios.model.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	@Query(value = "SELECT * FROM funcionarios WHERE cargo = ?1", nativeQuery=true)
	List<Funcionario> findFirstByCargo(String cargo);
	
	@Query(value = "SELECT * FROM funcionarios limit ?1", nativeQuery=true)
	List<Funcionario> findFirstByQuantidade(Integer quantidade);
	

}
