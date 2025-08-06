import java.util.Date;

//criando uma classe abstrata para ser implementada pela sub classes 

public abstract class Pessoa {
            // Atributos comuns a atores e diretores
            //coloquei como protegido para as sub classes, terem acessos, e o modo protegido fica no nível intermediário do público e privado

                protected boolean genero;
    protected Date idade;    
    protected String nacionalidade;

        
    // definindo o construtor quando a classe abstrata é criada
    public Pessoa (boolean genero, Date idade, String nacionalidade) {
        this.genero = genero;
        this.idade = idade;
        this.nacionalidade = nacionalidade;   
                
    }
    //criando os métodos que vam ler, e modificar os valores internos get e set 
                public boolean isMasculino() {

return genero;
        }
        public Date getIdade () {
                return idade;
        }
        public String getNacionalidade () {
                return nacionalidade;
        }

        public void setGenero (boolean genero) {
                        this.genero = genero;
        }
        public void setNacionalidade (String nacionalidade) {
         this.nacionalidade = nacionalidade;
        }
        
        public void setIdade (Date idade) {
                this.idade = idade;

        }


//definindo um método abstrato, siguinifica que toda vez que for declarar uma nova classe deverá ser declarado também, a classe abstrata exibirInfo
            public abstract void exibirInfo();

}       