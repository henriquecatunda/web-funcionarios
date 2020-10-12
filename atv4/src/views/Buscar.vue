<template>
   <div>
     <div class="Campos">

        <div>

          <h4>Mostrar todos os funcionario</h4>
          <button @click="fetchUsers()">Buscar Funcionarios</button><br /><br />

        </div>

        <div>
          <h4>Filtrar por id de funcionario</h4>
          <p> Id: <input type="text" v-model="id" /><br /></p> 
          <button @click="buscarFuncionarioId()">Buscar Funcionarios By Id</button><br /><br />


        </div>
         
       <div>
             <h4>Filtrar por cargo de funcionario</h4>
             <p> Cargo: <input type="text" v-model="cargo" /><br /></p>
             <button @click="buscarFuncionarioCargo()">Buscar Funcionarios pelo cargo</button><br /><br />


       </div>

       <div>
            <h4>Filtrar por quantidade de funcionario</h4>
            Quantidade: <input type="number" name="quantidade" id="" v-model="quantidade" /><br /><br /><br>
             <button @click="buscarFuncionarioQuant()">Buscar Funcionarios por quant.</button><br /><br />
        </div>

    </div>

    <p>{{funcionario }}</p> <br>

        <ul>
            <li v-for="funcionario in funcionarios " :key="funcionario.id">
                <div class="infor">
                <p>{{ funcionario.id }}</p>
                <p>{{ funcionario.nome }}</p>
                <p>{{ funcionario.cargo }}</p>
                <p>{{ funcionario.dataNascimento }}</p>
                <p>{{ funcionario.dataEntradaEmpresa }}</p>
                </div>
            </li>
        </ul>
        
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
      funcionario:{},
      funcionarios: [],
      baseURI:"http://localhost:8080/atv4-back-and/api/funcionarios",
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
          this.funcionario = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },

      buscarFuncionarioCargo() {
      this.$http
        .get(this.baseURI + "?cargo=" + this.cargo)
        .then((result) => {
          this.funcionario = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },

      buscarFuncionarioQuant() {
      this.$http
        .get(this.baseURI + "?quantidade=" + this.quantidade)
        .then((result) => {
          this.funcionario = result.data;
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
    font-weight: 600;
    width: 40%;
        
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
    justify-content: center;
}

.infor p {
    margin: 10px 10px;
    
}



</style>>
