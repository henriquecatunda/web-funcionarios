package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Funcionario;

public class FuncionarioDAO {
	
	private static final Map<Integer, Funcionario> funcionarioMap = new HashMap<Integer, Funcionario>();
    private static int i = 4;
 
    static {
        initFuncionarios();
    }
    
    private static void initFuncionarios() {
    	Funcionario funcionario1 = new Funcionario(1, "almada", "designUI", "01/05/98", "01/05/18");
    	Funcionario funcionario2 = new Funcionario(2, "anderson", "web", "01/05/98", "01/05/18");
    	Funcionario funcionario3 = new Funcionario(3, "alex", "teste", "01/05/98","01/05/18");
 
    	funcionarioMap.put(funcionario1 .getId(), funcionario1 );
    	funcionarioMap.put(funcionario2.getId(), funcionario2);
    	funcionarioMap.put(funcionario3.getId(), funcionario3);
    }
    
    public static Funcionario getFuncionario(int id) {
        return funcionarioMap.get(id);
    }
    
    
    
    public static List<Funcionario> getFuncionarioByCargo(String cargo) {
        List<Funcionario> list = getAllFuncionarios();
        List<Funcionario> usuarios = new ArrayList<>();
        for (Funcionario funcionario : list) {
            if(funcionario.getCargo().equals(cargo)) {  
            	
              
              usuarios.add(funcionario);
                             	   
            } 
        }
 
        return usuarios;
    }
    
    
    
    public static  List<Funcionario> getFuncionarioByQuantidade(int quantidade) {
        List<Funcionario> list = getAllFuncionarios();
        List<Funcionario> usuarios = new ArrayList<>();
        
        for (Funcionario funcionario : list) {
        	 if(quantidade != 0 ) {       	      
            	
        		 usuarios.add(funcionario);
        		 quantidade--;
        	 }
        }
 
        return usuarios;
    }
    
    public static Funcionario addFuncionario(String nome, String cargo, String dataNascimento, String dataEntradaEmpresa) {
    	Funcionario funcionario = new Funcionario(i, nome, cargo, dataNascimento, dataEntradaEmpresa);
    	funcionarioMap.put(funcionario.getId(), funcionario);
        i++;
        return funcionario;
    }
    
    public static Funcionario updateFuncionario(int id,String nome, String cargo, String dataNascimento, String dataEntradaEmpresa) {
    	Funcionario funcionario = new Funcionario(id, nome, cargo, dataNascimento, dataEntradaEmpresa);
    	funcionarioMap.put(funcionario.getId(), funcionario);
        return funcionario;
    }
    
    public static void deleteFuncionario(int id) {
        if (funcionarioMap.containsKey(id)) {
        	funcionarioMap.remove(id);
        }
    }
    
    public static List<Funcionario> getAllFuncionarios() {
        return new ArrayList<Funcionario>(funcionarioMap.values());
    }

}
