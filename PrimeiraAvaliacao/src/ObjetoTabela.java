public class ObjetoTabela {


		public int numero, tamanho;
		public Objeto[] objeto;
		
	    public ObjetoTabela(int t) {
	    	tamanho = t;
	    	numero = 0;
	    	criarTabela();
	    }
	    public void setNumero(int n){ numero = n; }
	    public void setTamaho(int t){ tamanho = t; }
	    public int getNumero(){ return numero; }
	    public int getTamanho(){ return tamanho; }
	    public String getObjeto(int i){ //i: indice
	    	return ("" + objeto[i].getCodigo() + "\t" + objeto[i].getNome() ); 
	   	}
	    
	    public void criarTabela(){
	    	objeto = new Objeto[getTamanho()];    	
	    	for(int i=0; i<getTamanho(); i++){    	
	    		DataNasc dNasc = new DataNasc(0,0,0);	
	    		objeto[i] = new Objeto(0,"",dNasc,'0');	
	    	}    	
	    }
	    
	    public char add(int codigo, String nome){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero() < getTamanho()){    	  
		    	int indice = getNumero();
		    	objeto[indice].setCodigo(codigo);
		    	objeto[indice].setNome(nome);		    	
		    	setNumero(indice + 1);
		    	resp = '1';	    	
		    }
		    return resp;
	    }
	    
	    public char rem(int codigo){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero()>0){
		    	for(int i=0; i<getNumero(); i++){ 
		    	   if(objeto[i].getCodigo()==codigo){
		    	   	  DataNasc dNasc = new DataNasc(0,0,0);
		    	   	  objeto[i].setSetor(0,"",dNasc,'0');
		    	   	  setNumero(getNumero() - 1);
		    	   	  resp = '1';
		    	   }
		    	}
	    	}
	    		
	     	return resp;
	    }
	    
	     public void add(int indice, int codigo, String nome){
	    	objeto[indice].setCodigo(codigo);
		    objeto[indice].setNome(nome);
		    setNumero(getNumero() + 1);
	    }
	    
	    
	    
	}


