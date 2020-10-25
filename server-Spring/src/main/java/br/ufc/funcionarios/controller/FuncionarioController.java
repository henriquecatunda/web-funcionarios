package br.ufc.funcionarios.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.funcionarios.model.Funcionario;
import br.ufc.funcionarios.service.FuncionarioService;


@RestController
@CrossOrigin
@RequestMapping(path = "/api/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Funcionario>> getFuncionarios() {
        return new ResponseEntity<List<Funcionario>>(funcionarioService.getFuncionarios(),HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Funcionario> getFuncionario(@PathVariable("id") Integer id) {
        return new ResponseEntity<Funcionario>(funcionarioService.getFuncionario(id), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchCargo")
    public ResponseEntity <List<Funcionario>> getFuncionarioByCargo(@RequestParam("cargo") String cargo) {
        return new ResponseEntity <List<Funcionario>>(funcionarioService.getFuncionarioByCargo(cargo), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchQuantidade")
    public ResponseEntity <List<Funcionario>> getFuncionarioByQuantidade(@RequestParam("quantidade") Integer quantidade) {
        return new ResponseEntity <List<Funcionario>>(funcionarioService.getFuncionarioByQuantidade(quantidade), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Funcionario> addFuncionario(@RequestBody Funcionario funcionario) {
        return new ResponseEntity<Funcionario>(funcionarioService.addFuncionario( funcionario.getNome(), funcionario.getCargo(), funcionario.getDataNascimento() , funcionario.getDataEntradaEmpresa() ), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable("id") Integer id, @RequestBody Funcionario funcionario) {
        return new ResponseEntity<Funcionario>(funcionarioService.updateFuncionario(id, funcionario.getNome(), funcionario.getCargo(), funcionario.getDataNascimento() , funcionario.getDataEntradaEmpresa()), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable("id") Integer id) {
        if (funcionarioService.removeFuncionario(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
 
}
