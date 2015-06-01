public class Servidor {

	public int codigo;
	public String nome;
	public DataNasc dataNasc; // = new DataNasc();
	public char sexo;  //M: masculino; F: feminino
	
    public Servidor(int c, String n, DataNasc d, char s) {
       codigo = c;
       nome = n;
       dataNasc = new DataNasc(d.getDia(), d.getMes(), d.getAno());
       sexo = s;
    }
    
    public void setCodigo(int c){ codigo = c; }
    public void setNome(String n){ nome = n; }
    public void setDataNasc(DataNasc d){ dataNasc = d; }
    public void setServidor(int c, String n, DataNasc d, char s) {
       setCodigo(c);
       setNome(n);
       setDataNasc(d);
       setSexo(s);	
    }
    public void setSexo(char s){ sexo = s; }
    public int getCodigo(){ return codigo; }
    public String getNome(){ return nome; }
    public DataNasc getDataNasc(){ return dataNasc; }
    public String getData(){ return dataNasc.getData(); }
    public char getSexo(){ return sexo; }
        
}

