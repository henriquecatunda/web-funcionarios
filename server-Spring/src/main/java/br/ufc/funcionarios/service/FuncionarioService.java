package br.ufc.funcionarios.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.funcionarios.model.Funcionario;
import br.ufc.funcionarios.repository.FuncionarioRepository;
 

@Service
public class FuncionarioService {
 
    @Autowired
    FuncionarioRepository funcionarioRepo;
    
    public Funcionario addFuncionario(String nome, String cargo, String dataNascimento, String dataEntradaEmpresa) {
    	Funcionario funcionario = new Funcionario(nome, cargo, dataNascimento, dataEntradaEmpresa );
        return funcionarioRepo.save(funcionario);
    }
    
    public boolean removeFuncionario(Integer id) {
        if(funcionarioRepo.existsById(id)) {
        	funcionarioRepo.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Funcionario> getFuncionarios() {
        return funcionarioRepo.findAll();
    }
    
    public Funcionario getFuncionario(Integer id) {
        return funcionarioRepo.findById(id).get();
    }
    
    public List<Funcionario> getFuncionarioByCargo(String cargo) {
        return funcionarioRepo.findFirstByCargo(cargo);
    }
    
    public List<Funcionario> getFuncionarioByQuantidade(Integer quantidade) {
        return funcionarioRepo.findFirstByQuantidade(quantidade);
    }
    
    public Funcionario updateFuncionario(Integer id, String nome, String cargo, String dataNascimento, String dataEntradaEmpresa) {
    	Funcionario funcionarioAux = funcionarioRepo.findById(id).get();
        
        if(funcionarioAux != null) {
        	funcionarioAux.setNome(nome);
        	funcionarioAux.setCargo(cargo);
        	funcionarioAux.setDataNascimento(dataNascimento);
        	funcionarioAux.setDataEntradaEmpresa(dataEntradaEmpresa);       
        	
        	funcionarioRepo.save(funcionarioAux);         
        }
        
        return funcionarioAux;
    }
}