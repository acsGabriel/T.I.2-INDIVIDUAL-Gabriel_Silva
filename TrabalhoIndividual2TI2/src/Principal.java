package TrabalhoIndividual2;

import java.util.Scanner;

public class Principal 
{
	public static void main(String args[])
	{
		DAO dao = new DAO();
		dao.conectar();
        Filmes filme = new Filmes(null, null, 0, 0);
        
		Scanner s = new Scanner(System.in);
		
		int option = 0;
		
		System.out.println("BEM VINDO AO TESTE DE BANCO DE DADOS 1");
		System.out.println("GABRIEL ARAUJO CAMPOS SILVA - 727947");
		System.out.println("1 - LISTAR");
		System.out.println("2 - INSERIR");
		System.out.println("3 - RETIRAR");
		System.out.println("4 - ATUALIZAR");
		System.out.println("DIGITE '0' PARA FINALIZAR O PROGRAMA");
		
		option = s.nextInt();
		
		switch (option)
		{
			case 0:
				break;
			case 1: 
				dao.showFilme();
				break;
			case 2:
				 dao.insertFilme(filme);
				 break;
			case 3:
				 dao.removeFilme(filme);
				 break;
			case 4:
				 dao.changeFilme(filme);
				 break;
			default:
				 System.out.println("OPÇÃO INVÁLIDA!!!");
				 break;
		}
		
		
		
		
		
	}

}
