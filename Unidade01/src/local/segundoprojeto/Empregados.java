package local.segundoprojeto;



public class Empregados {
    private int codigo;
    private String nome;
    private String cargo;
    private double salario;

    public Empregados() {
        this.codigo = -1;
        this.nome = "";
        this.cargo = "";
        this.salario = 0.0;
    }

    public Empregados(int codigo, String nome, String cargo, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empregados [codigo=" + codigo + ", nome=" + nome + ", cargo=" + cargo + ", salario=" + salario + "]";
    }
}

