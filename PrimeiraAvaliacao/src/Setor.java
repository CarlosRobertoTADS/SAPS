public class Setor {
	

		public int codigo;
		public String nome;

		
	    public Setor(int c, String n, DataNasc d, char s) {
	       codigo = c;
	       nome = n;
	
	    }
	    
	    public void setCodigo(int c){ codigo = c; }
	    public void setNome(String n){ nome = n; }
	    public void setSetor(int c, String n, DataNasc d, char s) {
	       setCodigo(c);
	       setNome(n);
	       	
	    }
	   
	    public int getCodigo(){ return codigo; }
	    public String getNome(){ return nome; }	       
	
}




