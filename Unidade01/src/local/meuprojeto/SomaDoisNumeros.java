package local.meuprojeto;
import local.meuprojeto.MyIO;

public class SomaDoisNumeros {
	public static void main (String[] args) {
		int num1 = MyIO.readInt("Digite o primeiro numero ");
		int num2 = MyIO.readInt("Digite o segundo numero ");
		int soma = num1 + num2;
		MyIO.println(soma);
	}
}
