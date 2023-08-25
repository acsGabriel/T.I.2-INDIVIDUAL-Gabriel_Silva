public class DAO 
{
	private Connection conexao;
	
	public DAO() 
	{
		conexao = null;
	}
	
	public boolean conectar() 
	{
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "2005";
		String password = "2005";
		boolean status = false;

		try 
		{
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} 
		catch (ClassNotFoundException e) 
		{ 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} 
		catch (SQLException e) 
		{
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() 
	{
		boolean status = false;
		
		try 
		{
			conexao.close();
			status = true;
		} 
		catch (SQLException e) 
		{
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean insertFilme(Filmes filme) 
	{
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO filme (nome , genero , nota , ano) "
					       + "VALUES ("+filme.getNome()+ ", '" + filme.getGenero() + "', '"  
					       + filme.getNota() + "', '" + filme.getAno() + "');");
			st.close();
			status = true;
		} 
		catch (SQLException u) 
		{  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean changeFilme(Filmes filme) 
	{
		boolean status = false;
		try 
		{  
			Statement st = conexao.createStatement();
			String sql = "UPDATE filme SET nome = '" + filme.getNome() + "', genero = '"  
				       + filme.getGenero() + "', ano = '" +filme.getAno() + "'"
					   + " WHERE nota = " +filme.getNota();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} 
		catch (SQLException u) 
		{  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean removeFilme(String nome) 
	{
		boolean status = false;
		try 
		{  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM filme WHERE nome = " + nome);
			st.close();
			status = true;
		}
		catch (SQLException u) 
		{  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Filmes[] getFilmes() 
	{
		Filmes[] filmes = null;
		
		try 
		{
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM filmes");		
	         if(rs.next())
	         {
	             rs.last();
	             filmes = new Filmes[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	                filmes[i] = new Filmes(rs.getString("nome"), rs.getString("genero"), rs.getInt("ano"), rs.getInt("nota"));
	             }
	          }
	          st.close();
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		return filmes;
	}

}
