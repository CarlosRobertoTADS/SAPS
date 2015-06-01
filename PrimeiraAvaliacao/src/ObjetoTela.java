import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;



	public class ObjetoTela extends JDialog implements ActionListener {
		public SNEO sneo;
		public JLabel 	lCodigo, lNome;
		public JTextField tfCodigo, tfNome;
		public int distBotoes = 20;
		public ToolBar toolBar;
		public char operacao; //[0]Nenhuma opera��o; [1]Incluir; [2]Atualizar; [3]Excluir;
		public ObjetoTabela oTabela;
		
		
		

	    public ObjetoTela(Frame owner, String title, boolean modal, SNEO sneo, ObjetoTabela oTabela) {
	      	super(owner, title, modal);
	      	this.sneo = sneo;
	      	setResizable(false);
	      	setBounds(280, 300, 630, 420);
	      	
	      	//Vinculando a refer�ncia com a Tabela de Clientes
	      	this.oTabela = oTabela;
	      	
	    	
	    	//Cria o container (box, caixa) para a  
	    	//agrupamento dos objetos
	    	Container areaTrabalho = getContentPane();
	    	areaTrabalho.setLayout(null);
	    	
	    	
	    	lCodigo = new JLabel("Codigo");
	    	lCodigo.setBounds(20, 110, 100, 40);
	    	lCodigo.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lCodigo);
	    	
	    	tfCodigo = new JTextField("");
	    	tfCodigo.setBounds(120, 110, 200, 40);
	    	tfCodigo.addActionListener(this); 
	    	tfCodigo.setHorizontalAlignment(JTextField.LEFT);
	    	tfCodigo.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	    	tfCodigo.setEditable(true);
	    	areaTrabalho.add(tfCodigo);
	    	
	    	lNome = new JLabel("Nome");
	    	lNome.setBounds(20, 180, 150, 40);
	    	lNome.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lNome);
	    	
	    	tfNome = new JTextField("");
	    	tfNome.setBounds(120, 180, 450, 40);
	    	tfNome.setHorizontalAlignment(JTextField.LEFT);
	    	tfCodigo.addActionListener(this); 
	    	tfNome.setFont(new Font("TimesRoman",Font.ITALIC, 25));
	    	tfNome.setEditable(true);
	    	areaTrabalho.add(tfNome);
	    	
	   
	    
	    	
	    	toolBar = new ToolBar();
	    	toolBar.setBounds(1, 1, 700, 70); 	
	    	toolBar.bIncluir.addActionListener(this);    	  	
	    	toolBar.bAtualizar.addActionListener(this);
	    	toolBar.bExcluir.addActionListener(this);
	    	toolBar.bConfirmar.addActionListener(this);    	
	    	toolBar.bLimpar.addActionListener(this);    	
	    	toolBar.bPesquisar.addActionListener(this);
	    	
	    	areaTrabalho.add(toolBar);
	    	toolBar.desbloquearBotoes();
	    	toolBar.bIncluir.requestFocus();
	    	
	    	operacao = '0';
	    	limpar();
	    	bloquearCampos();
	    }
	    
	    
	    public void actionPerformed(ActionEvent e){ 
	    	int temp = 0;
		      if (e.getSource()==toolBar.bIncluir)	
		    	incluir();
		      else if(e.getSource()==toolBar.bAtualizar)
		        atualizar();
		      else if(e.getSource()==toolBar.bExcluir)
		        excluir();
		      else if(e.getSource()==toolBar.bConfirmar)
		        confirmar();
		      else if(e.getSource()==toolBar.bLimpar)
		        limpar();
		      else if(e.getSource()==toolBar.bPesquisar)
		      	visualizar();
		      else if(e.getSource()==tfCodigo)
		        tfNome.requestFocus();
		      else if(e.getSource()==tfNome)
		      tfCodigo.requestFocus();
		    	  else
		 
		      	temp = 0;
		    
	  	}
	  	
	  	
	  	public void incluir(){
	  		tfCodigo.requestFocus();
			toolBar.bloquearBotoes();
			desbloquearCampos();
			operacao = '1';		 		 
		}
	  	
	  	public void atualizar(){
	  		tfCodigo.requestFocus();
			toolBar.bloquearBotoes();
			
			desbloquearCampos();
		
			
			operacao = '2';		 		 
		}
		
		public void excluir(){
			tfCodigo.requestFocus();
			toolBar.bloquearBotoes();
			desbloquearCampos();
			operacao = '3';		 		 
		}
		public void confirmar(){
			toolBar.desbloquearBotoes();
			
			bloquearCampos();
		
		
				
			
					
				if(oTabela.add(Integer.parseInt(tfCodigo.getText()), tfNome.getText())=='1')
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!","Aviso", JOptionPane.INFORMATION_MESSAGE);			
				else
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel cadastrar o cliente!","Aviso", JOptionPane.INFORMATION_MESSAGE);							
					
			/*else{
				if(operacao == '2'){
				
				}			
		 		else{
		 			if(operacao == '3'){
		 				
		 			}
		 			else
		 		
			}	
			*/		 
				
		    limpar();
		}
		
	  	public void limpar(){
			 tfCodigo.setText("");
			 tfNome.setText("");
			 		 		 
		}
	  	
	  	public void bloquearCampos(){
	  	 	tfCodigo.setEnabled(false);
			tfNome.setEnabled(false);
		
	  	}
	  	
	  	public void desbloquearCampos(){
	  	 	tfCodigo.setEnabled(true);
			tfNome.setEnabled(true);
				
	  	}
	  	
	  	public void visualizar(){
	  		if(oTabela.getNumero()==0)
	  			JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
	  		else{
	  		  for(int i=0; i<oTabela.getNumero(); i++)
		    	JOptionPane.showMessageDialog(null, ""+oTabela.getObjeto(i)+"\n","Aviso", JOptionPane.INFORMATION_MESSAGE);	      
	  		}
	  	}
	    
	}

