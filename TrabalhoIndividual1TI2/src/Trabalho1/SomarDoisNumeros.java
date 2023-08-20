package Trabalho1;

import java.util.*;
class SomarDoisNumeros 
{

	public static void main(String[] args) 
	{
		//declaração de variáveis
		int num1 , num2 , soma;
		
		//leitura
		Scanner sc = new Scanner(System.in);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		//somar
		soma = num1 + num2;
		
		//mostrar na tela
		System.out.println("Soma:" + soma);

	}

}
