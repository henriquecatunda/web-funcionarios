<template>
   <div>
         <div class="Campos">
          <h4>Cadastrar funcionarios</h4>

           <p> Id: <input type="text" v-model="id" /><br /></p> 
           <p> Nome: <input type="text" v-model="nome" /><br /></p> 
           <p> Cargo: <input type="text" v-model="cargo" /><br /></p>
           <p> Data de nascimento: <input type="text" v-model="dataNascimento" /><br /></p>
           <p> Data de entrada na empresa: <input type="text" v-model="dataEntrada" /><br /><br></p>
         </div>

      
          <div class="butaos">
          <button @click="postFuncionario()">Post Funcionario</button><br /><br />
          <button @click="putFuncionario()">Put Funcionario</button><br /><br />
          <button @click="deleteFuncionario()">Delete Funcionario</button><br /><br /> 
          </div>

        <ul>
            <li>
                <div class="infor">
                <p> Id: {{ funcionarios.id }}</p>
                <p>Nome: {{ funcionarios.nome }}</p>
                <p>Cargo: {{ funcionarios.cargo }}</p>
                <p>DataNascimento: {{ funcionarios.dataNascimento }}</p>
                <p>DataEntradaEmpresa: {{ funcionarios.dataEntradaEmpresa }}</p>
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
      quantidade:"",
      funcionarios: [],
      baseURI:"http://localhost:8080/atv4-back-and/api/funcionarios",
    };
  },
  methods: {

     postFuncionario() {
      let obj = {
        nome: this.nome,
        cargo: this.cargo,
        dataNascimento: this.dataNascimento,
        dataEntradaEmpresa: this.dataEntrada,
      };

      this.$http.post(this.baseURI, obj).then((result) => {
        console.log(result);
         this.funcionarios  = result.data;
        //this.handleFileUpload(this.user.id);
      });
    },

    putFuncionario() {
      let obj = {
        nome: this.nome,
        cargo: this.cargo,
        dataNascimento: this.dataNascimento,
        dataEntradaEmpresa: this.dataEntrada,
      };

      this.$http.put(this.baseURI + "/" + this.id, obj).then((result) => {
        console.log(result);
        this.funcionarios = result.data;
        //this.handleFileUpload(this.user.id);
      });
    },

    deleteFuncionario() {
      this.$http.delete(this.baseURI + "/" + this.id).then((result) => {
        console.log(result.status);
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


.butaos{
    display: flex;
    width: 70%;
    justify-content: center;
    margin: 10px auto;
  
}
.butaos button{
    background-color: rgb(20, 20, 20);
    color: white;
    margin: 0 20px;
    cursor: pointer;
}

.infor {

    display: flex;
}

.infor p {
    margin: 10px 10px;
    
}

</style>>
