<template>
   <div>
     <div class="Campos">

        <div>

          <h4>Mostrar todos os funcionario</h4>
          <button @click="fetchUsers()">Buscar Funcionarios</button><br /><br />

          <ul>
            <li v-for="funcionario in funcionarios " :key="funcionario.id">
                <div class="infor">
                <p> Id: {{ funcionario.id }}</p>
                <p>Nome: {{ funcionario.nome }}</p>
                <p>Cargo: {{ funcionario.cargo }}</p>
                <p>DataNascimento: {{ funcionario.dataNascimento }}</p>
                <p>DataEntradaEmpresa: {{ funcionario.dataEntradaEmpresa }}</p>
                </div>
            </li>
        </ul>

        </div>

        <div>
          <h4>Filtrar por id de funcionario</h4>
          <p> Id: <input type="text" v-model="id" /><br /></p> 
          <button @click="buscarFuncionarioId()">Buscar Funcionarios By Id</button><br /><br />

            <ul>  
                     <li >
                        <div class="infor">
                        <p>Id: {{ funcionariosid.id }}</p>
                        <p>Nome: {{ funcionariosid.nome }}</p>
                        <p>Cargo: {{ funcionariosid.cargo }}</p>
                        <p>DataNascimento: {{ funcionariosid.dataNascimento }}</p>
                        <p>DataEntradaEmpresa: {{ funcionariosid.dataEntradaEmpresa }}</p>
                         </div>
                     </li>

               </ul>

        </div>
         
       <div>
             <h4>Filtrar por cargo de funcionario</h4>
             <p> Cargo: <input type="text" v-model="cargo" /><br /></p>
             <button @click="buscarFuncionarioCargo()">Buscar Funcionarios pelo cargo</button><br /><br />

              <ul>  
                     <li  v-for="funcionario in funcionariosC " :key="funcionario.id" >
                        <div class="infor">
                        <p>Id:{{ funcionario.id }}</p>
                        <p>Nome: {{ funcionario.nome }}</p>
                        <p>Cargo: {{ funcionario.cargo }}</p>
                        <p>DataNascimento: {{ funcionario.dataNascimento }}</p>
                        <p>DataEntradaEmpresa: {{ funcionario.dataEntradaEmpresa }}</p>
                         </div>
                     </li>

               </ul>
       </div>

       <div>
            <h4>Filtrar por quantidade de funcionario</h4>
            Quantidade: <input type="number" name="quantidade" id="" v-model="quantidade" /><br /><br /><br>
             <button @click="buscarFuncionarioQuant()">Buscar Funcionarios por quant.</button><br /><br />

              <ul>  

                     <li  v-for="funcionarioQ in funcionariosQuan " :key="funcionarioQ.id">
                        <div class="infor">
                        <p>Id:{{ funcionarioQ.id }}</p>
                        <p>Nome: {{ funcionarioQ.nome }}</p>
                        <p>Cargo: {{ funcionarioQ.cargo }}</p>
                        <p>DataNascimento: {{ funcionarioQ.dataNascimento }}</p>
                        <p>DataEntradaEmpresa: {{ funcionarioQ.dataEntradaEmpresa }}</p>
                         </div>
                     </li>
               </ul>
        </div>

    </div>
      
   </div>


</template>

<script>
export default {
     name: "Funcionario",
  data() {
    return {
        id: 0,
      nome: "",
      cargo: "",
      dataNascimento: "",
      dataEntrada: "",
      quantidade: 0,
      funcionarios: [],
      funcionariosid:[],
      funcionariosC:[],
      funcionariosQuan:[],
      baseURI:"http://localhost:8080/api/funcionarios",
    };
  },
  methods: {

     fetchUsers(){
      this.$http.get(this.baseURI ).then((result) => {
         this.funcionarios = result.data;
      });
    },

    buscarFuncionarioId(){
      this.$http
        .get(this.baseURI + "/" + this.id)
        .then((result) => {
          this.funcionariosid = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },

      buscarFuncionarioCargo() {
      this.$http
        .get(this.baseURI + "/searchCargo?cargo=" + this.cargo)
        .then((result) => {
          this.funcionariosC = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },

      buscarFuncionarioQuant() {
      this.$http
        .get(this.baseURI + "/searchQuantidade?quantidade=" + this.quantidade)
        .then((result) => {
          this.funcionariosQuan = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },



  },

}
</script>

<style  scoped>

.Campos {
    margin: auto;
    width: 80%;
        
}


button{
    background-color: rgb(20, 20, 20);
    color: white;
    margin: 0 20px;
    height: 30px;
    cursor: pointer;
}

.infor {

    display: flex;
   
}

.infor p {
    margin: 10px 10px;
    
    
}



</style>>
