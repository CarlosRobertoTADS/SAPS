

	import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.ImageIcon;

	public class SNEO extends JFrame implements ActionListener{
		//Declaração globa
		public JLabel lTitulo, lHabilitar, lDesabilitar, lServidor, lSetor, lObjeto, lSair;
		public Acesso fAcesso;
		public ServidorTela fServidor;
		public SetorTela fSetor;
	    public ObjetoTela fObjeto;
		public JButton bHabilitar, bServidor, bSetor, bObjeto, bSair;
		public ObjetoTabela oTabela;
		public SetorTabela sTabela;
		public ServidorTabela ssTabela;
	
		
		public SNEO(){
		  	setTitle("SNEO: SISTEMA NACIONAL DE EMPRÉSTIMOS DE OBJETOS");
	    	setExtendedState(MAXIMIZED_BOTH);
	    	
	       	//Cria o container (box, caixa) para a  
	    	//agrupamento dos objetos
	    	Container areaTrabalho = getContentPane();
	    	areaTrabalho.setLayout(null);	
			
			lTitulo = new JLabel("SISTEMA NACIONAL DE EMPRÉSTIMOS DE OBJETOS");
			
			lTitulo.setFont(new Font("TimesRoman", Font.BOLD, 30));
			lTitulo.setBounds(20, 20, 2000, 100);				
			//lHabilitar.addActionListener(this);    	
	    	areaTrabalho.add(lTitulo);
			
			
			
			ImageIcon iHabilitar = new ImageIcon("imagem/habilitar.png");
	    	bHabilitar = new JButton(iHabilitar);
	    	bHabilitar.addActionListener(this);    	   
	    	areaTrabalho.add(bHabilitar);
	    	bHabilitar.setBounds(20, 200, 50, 50);
	    	
			
			lHabilitar = new JLabel("Habilitar...");
			lHabilitar.setFont(new Font("TimesRoman", Font.ITALIC, 30));
			lHabilitar.setBounds(100, 200, 400, 50);
	    	areaTrabalho.add(lHabilitar);
	    	
	    	ImageIcon iServidor = new ImageIcon("imagem/cliente.png");
	    	bServidor = new JButton(iServidor);
	    	bServidor.addActionListener(this);    	   
	    	areaTrabalho.add(bServidor);
	    	bServidor.setBounds(20, 270, 50, 50);
	    	bServidor.setEnabled(false);
			
			lServidor = new JLabel("Servidor");
			lServidor.setFont(new Font("TimesRoman", Font.ITALIC, 30));
			lServidor.setBounds(100, 270, 400, 50);
	    	areaTrabalho.add(lServidor);
	    	
	    	ImageIcon iSetor = new ImageIcon("imagem/setor.png");
	    	bSetor = new JButton(iSetor);
	    	bSetor.addActionListener(this);    	   
	    	areaTrabalho.add(bSetor);
	    	bSetor.setBounds(20, 340, 50, 50);
	    	bSetor.setEnabled(false);
			
			lSetor = new JLabel("Setor");
			lSetor.setFont(new Font("TimesRoman", Font.ITALIC, 30));
			lSetor.setBounds(100, 340, 400, 50);
	    	areaTrabalho.add(lSetor);
	    	

	    	ImageIcon iObjeto = new ImageIcon("imagem/objeto.png");
	    	bObjeto = new JButton(iObjeto);
	    	bObjeto.addActionListener(this);    	   
	    	areaTrabalho.add(bObjeto);
	    	bObjeto.setBounds(20, 410, 50, 50);
	    	bObjeto.setEnabled(false);
			
			lObjeto = new JLabel("Objeto");
			lObjeto.setFont(new Font("TimesRoman", Font.ITALIC, 30));
			lObjeto.setBounds(100, 410, 400, 50);
	    	areaTrabalho.add(lObjeto);
	    	
	    	ImageIcon iSair = new ImageIcon("imagem/sair.png");
	    	bSair = new JButton(iSair);
	    	bSair.addActionListener(this);    	   
	    	areaTrabalho.add(bSair);
	    	bSair.setBounds(20, 480, 50, 50);
	    	bSair.setEnabled(true);
			
			lSair = new JLabel("Sair do Sistema");
			lSair.setFont(new Font("TimesRoman", Font.ITALIC, 30));
			lSair.setBounds(100, 480, 400, 50);
	    	areaTrabalho.add(lSair);
	    	
	    	//Criação da Tabela de clientes com espaço para 20 registros
	    	sTabela = new SetorTabela(20);
	    	ssTabela = new ServidorTabela(20);
	    	oTabela = new ObjetoTabela (20);		
			setVisible(true);
		}
		
		public void contectar(){
			 bServidor.setEnabled(true);
			 bSetor.setEnabled(true);
			 bObjeto.setEnabled(true);
			 bSair.setEnabled(true);
			 fAcesso.setVisible(false);
			 bHabilitar.setEnabled(false);
		}
		
		public void actionPerformed(ActionEvent e){
	    	int temp = 0;
		    if (e.getSource()==bHabilitar){	
		    	fAcesso = new Acesso(null, "SNEO: Habilitação de usuário.", true, this );
		    	fAcesso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	fAcesso.setVisible(true);
		    	
		    }else if(e.getSource()==bSair)	
		    	System.exit(0);	
		    else if(e.getSource()==bServidor){	
		    	fServidor = new ServidorTela(null, "SNEO: Servidor.", true, this, ssTabela );
		    	fServidor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	fServidor.setVisible(true);
		    }else if (e.getSource()==bSetor){
		    		fSetor = new SetorTela (null, "SNEO: Setor.", true, this, sTabela);
		    		fSetor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    	fSetor.setVisible(true);
		    	}else if (e.getSource()==bObjeto){
		    		fObjeto = new ObjetoTela (null, "SNEO: Setor.", true, this, oTabela);
		    		fObjeto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    	fObjeto.setVisible(true);
		    	}
		    else
		    	temp = 0;		    
		}  
		
		public void msg(String usuario, String senha){
			if(usuario.equals("carlos") && senha.equals("123")){
			  contectar();
			  JOptionPane.showMessageDialog(null, "Acesso Autorizado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		      
			}
			else
			  JOptionPane.showMessageDialog(null, "Acesso Não Autorizado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		
		}  
		
		public static void  main(String args[]){
	    	SNEO sneo = new SNEO();
	    	sneo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	}

