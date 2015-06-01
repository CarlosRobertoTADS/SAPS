
public class ServidorTabela {
	
		public int numero, tamanho;
		public Servidor[] servidor;
		
	    public ServidorTabela(int t) {
	    	tamanho = t;
	    	numero = 0;
	    	criarTabela();
	    }
	    public void setNumero(int n){ numero = n; }
	    public void setTamaho(int t){ tamanho = t; }
	    public int getNumero(){ return numero; }
	    public int getTamanho(){ return tamanho; }
	    public String getServidor(int i){ //i: indice
	    	return ("" + servidor[i].getCodigo() + "\t" + servidor[i].getNome() + "\t" + servidor[i].getData()+ "\t" + servidor[i].getSexo()); 
	   	}
	    
	    public void criarTabela(){
	    	servidor = new Servidor[getTamanho()];    	
	    	for(int i=0; i<getTamanho(); i++){    	
	    		DataNasc dNasc = new DataNasc(0,0,0);	
	    		servidor[i] = new Servidor(0,"",dNasc,'0');	
	    	}    	
	    }
	    
	    public char add(int codigo, String nome, int dia, int mes, int ano, char sexo){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero() < getTamanho()){    	  
		    	int indice = getNumero();
		    	servidor[indice].setCodigo(codigo);
		    	servidor[indice].setNome(nome);
		    	DataNasc dNasc = new DataNasc(dia,mes,ano);
		    	servidor[indice].setDataNasc(dNasc);
		    	servidor[indice].setSexo(sexo);
		    	setNumero(indice + 1);
		    	resp = '1';	    	
		    }
		    return resp;
	    }
	    
	    public char rem(int codigo){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero()>0){
		    	for(int i=0; i<getNumero(); i++){ 
		    	   if(servidor[i].getCodigo()==codigo){
		    	   	  DataNasc dNasc = new DataNasc(0,0,0);
		    	   	  servidor[i].setServidor(0,"",dNasc,'0');
		    	   	  setNumero(getNumero() - 1);
		    	   	  resp = '1';
		    	   }
		    	}
	    	}
	    		
	     	return resp;
	    }
	    
	     public void add(int indice, int codigo, String nome, int dia, int mes, int ano, char sexo){
	    	servidor[indice].setCodigo(codigo);
		    servidor[indice].setNome(nome);
		    DataNasc dNasc = new DataNasc(dia,mes,ano);
		    servidor[indice].setDataNasc(dNasc);
		    servidor[indice].setSexo(sexo);
		    setNumero(getNumero() + 1);
	    }
	    
	    
	    
	}
