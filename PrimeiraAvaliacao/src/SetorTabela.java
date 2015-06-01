public class SetorTabela {	

		public int numero, tamanho;
		public Setor[] setor;
		
	    public SetorTabela(int t) {
	    	tamanho = t;
	    	numero = 0;
	    	criarTabela();
	    }
	    public void setNumero(int n){ numero = n; }
	    public void setTamaho(int t){ tamanho = t; }
	    public int getNumero(){ return numero; }
	    public int getTamanho(){ return tamanho; }
	    public String getSetor(int i){ //i: indice
	    	return ("" + setor[i].getCodigo() + "\t" + setor[i].getNome() ); 
	   	}
	    
	    public void criarTabela(){
	    	setor = new Setor[getTamanho()];    	
	    	for(int i=0; i<getTamanho(); i++){    	
	    		DataNasc dNasc = new DataNasc(0,0,0);	
	    		setor[i] = new Setor(0,"",dNasc,'0');	
	    	}    	
	    }
	    
	    public char add(int codigo, String nome){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero() < getTamanho()){    	  
		    	int indice = getNumero();
		    	setor[indice].setCodigo(codigo);
		    	setor[indice].setNome(nome);		    	
		    	setNumero(indice + 1);
		    	resp = '1';	    	
		    }
		    return resp;
	    }
	    
	    public char rem(int codigo){
	    	char resp = '0'; //0: insucesso; 1: sucesso
	    	if(getNumero()>0){
		    	for(int i=0; i<getNumero(); i++){ 
		    	   if(setor[i].getCodigo()==codigo){
		    	   	  DataNasc dNasc = new DataNasc(0,0,0);
		    	   	  setor[i].setSetor(0,"",dNasc,'0');
		    	   	  setNumero(getNumero() - 1);
		    	   	  resp = '1';
		    	   }
		    	}
	    	}
	    		
	     	return resp;
	    }
	    
	     public void add(int indice, int codigo, String nome){
	    	setor[indice].setCodigo(codigo);
		    setor[indice].setNome(nome);
		    setNumero(getNumero() + 1);
	    }
	    
	    
	    
	}

