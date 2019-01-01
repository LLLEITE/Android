package thiagocury.eti.br.exlistviewarrayadaptertarde.model;

public class Pessoa {

    private String nome;
    private int idade;
    private String sexo;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int calcularIdadeMeses(){
        return idade * 12;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String verificarSexo(){
        if(sexo.equalsIgnoreCase("Masculino")){
            return "https://paralemdoagora.files.wordpress.com/2016/01/275686_papel-de-parede-uma-das-mais-lindas-paisagens_1600x900.jpg?w=500";
        }
        return "http://2.bp.blogspot.com/-eRbe7o9QJf0/TZ5Se-rPb0I/AAAAAAAAAGI/CdExbCxAYl8/s1600/-3D071.jpg";
    }

    @Override
    public String toString() {
        return "\nnome = " + nome +
               "\nidade = " + idade +
               "\nIdade em meses = " + calcularIdadeMeses();
    }
}
