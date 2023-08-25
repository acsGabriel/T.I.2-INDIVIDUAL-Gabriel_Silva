package TrabalhoIndividual2;

public class Filmes 
{
	private static int index = 0;
	private String nome;
	private String genero;
	private int nota;
	private int ano;
	
	Filmes(String nome , String genero , int nota , int ano)
	{
		this.nome = nome;
		this.genero = genero;
		this.nota = nota;
		this.ano = ano;
		index++;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getGenero() 
	{
		return genero;
	}

	public void setGenero(String genero) 
	{
		this.genero = genero;
	}

	public int getNota() 
	{
		return nota;
	}

	public void setNota(int nota) 
	{
		this.nota = nota;
	}

	public int getAno() 
	{
		return ano;
	}

	public void setAno(int ano) 
	{
		this.ano = ano;
	}
	
	
	

}
