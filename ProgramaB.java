import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ProgramaB {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		Funcionario funcionario = new Funcionario();
		boolean funcionarioExiste = false;

	    System.out.println("Digite o CPF do Funcionário:");
	    String cpfDigitado = leitor.nextLine();
	    
	    try {
            FileReader arquivo = new FileReader("C:\\Users\\lsq\\eclipse-workspace\\atividadeSemana\\src\\cadastrados.json");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            
            String json = "";
            String linha = lerArquivo.readLine();
            while(linha != null){
                json = json.concat(linha);
                linha = lerArquivo.readLine();
            }

            Gson gson = new Gson();
            Type userListType = new TypeToken<ArrayList<Funcionario>>(){}.getType();			
            ArrayList<Funcionario> lista = gson.fromJson(json, userListType);			
			
            for(int i = 0; i<lista.size();i++) {
            	if(cpfDigitado.equals(lista.get(i).cpf)) {
            		funcionario = lista.get(i);
            		funcionarioExiste = true;
            	}
            }
            
            if(funcionarioExiste) {
            	System.out.println("Nome: " + funcionario.nome);
            	System.out.println("CPF: " + funcionario.cpf);
            	System.out.println("Idade: " + funcionario.idade);
            	System.out.println("Cargo: " + funcionario.cargo);
            	System.out.println("Salario: " + funcionario.salario);
            	System.out.println("Habilidades: ");
            	for(int i = 0; i<funcionario.habilidades.size();i++) {
            		System.out.println(funcionario.habilidades.get(i));
            	}
            	
            }
            else {
            	System.out.println("O funcionário nao está cadastrado.");
            }
			
            arquivo.close();
            leitor.close();
            
        }catch (IOException e){
            e.printStackTrace();
        }
		
	}
	
}
