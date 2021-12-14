import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import com.google.gson.*;

public class Programa {

	public static void main(String[] args) {

	    Funcionario funcionario = new Funcionario();
	    Gson gson = new Gson();

	    Scanner leitor = new Scanner(System.in);

	    System.out.println("Digite o CPF do Funcionário:");
	    funcionario.cpf = leitor.nextLine();

	    System.out.println("Digite o nome do Funcionário:");
	    funcionario.nome = leitor.nextLine();

	    System.out.println("Digite a idade do Funcionário:");
	    funcionario.idade = leitor.nextInt();
	    leitor.nextLine();

	    System.out.println("Digite o salario do Funcionário:");
	    funcionario.salario = leitor.nextDouble();
	    leitor.nextLine();

	    System.out.println("Digite o cargo do Funcionário:");
	    funcionario.cargo = leitor.nextLine();

	    System.out.println("Digite as habilidades do Funcionário:");
	    String habilidade = leitor.nextLine();
	    while (!habilidade.equals("-1")) {
	      funcionario.habilidades.add(habilidade);
	      habilidade = leitor.nextLine();
	    }
	
	    leitor.close();
	    
	    String json = gson.toJson(funcionario);
	    System.out.println(json);

	    String nomeArquivo = funcionario.cpf.concat(".json");
	    
	    try {
			FileWriter arquivo = new FileWriter(nomeArquivo);
			PrintWriter gravarArquivo = new PrintWriter(arquivo);
			gravarArquivo.printf(json);
			arquivo.close();
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("Tudo certo!");
		
	}

}
