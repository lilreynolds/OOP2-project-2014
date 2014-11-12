import javax.swing.*;
import java.awt.event.*;

public class MyMenu_1 extends JFrame{

	
//declare
	private JMenuBar menubar;
	
	//constuctor
	public MyMenu_1(){
		setTitle("MyGui");
		setSize(300,300);
		setLocation(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 menubar = new JMenuBar();
		setJMenuBar(menubar);
			
		createFileMenu();
		
		createCharacterMenu();		
	}
	
	//methods
	
	public void createFileMenu(){
		
		JMenu filemenu = new JMenu("File");
		menubar.add(filemenu);
		
		MyHandler handler = new MyHandler();
				
		JMenuItem openItem = new JMenuItem("Open"); 
			filemenu.add(openItem);
			openItem.addActionListener(handler);
			
		JMenuItem closeItem = new JMenuItem("Close"); 
			filemenu.add(closeItem);
			closeItem.addActionListener(handler);
			
		JMenuItem saveasItem = new JMenuItem("Save As"); 
			filemenu.add(saveasItem);
			saveasItem.addActionListener(handler);
			filemenu.addSeparator();
			
		JMenuItem quitItem = new JMenuItem("Quit"); 
			filemenu.add(quitItem);
			quitItem.addActionListener(handler);
		
	}
	
	public void createCharacterMenu(){
	
	JMenu  charactermenu = new JMenu("Character");
		menubar.add(charactermenu);
		
		MyHandler handler2 = new MyHandler();
		
		JMenuItem addItem = new JMenuItem("Add"); 
			charactermenu.add(addItem);
			addItem.addActionListener(handler2);
		
		JMenuItem subtractItem = new JMenuItem("Subtract"); 
			charactermenu.add(subtractItem); 
			subtractItem.addActionListener(handler2);
			
	} 
	
	public static void main(String[] args){
		MyMenu menu = new MyMenu();
		
		menu.setVisible(true);
	}
	
/*	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Open")){
			JOptionPane.showMessageDialog(null,"you clicked open","",JOptionPane.INFORMATION_MESSAGE);
		}

	
		else if(e.getActionCommand().equals("Close")){
			JOptionPane.showMessageDialog(null,"you clicked close","",JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(e.getActionCommand().equals("Save As")){
			JOptionPane.showMessageDialog(null,"you clicked save as","",JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(e.getActionCommand().equals("Quit")){
			JOptionPane.showMessageDialog(null,"you clicked Quit","",JOptionPane.INFORMATION_MESSAGE);
			
			System.exit(0);
		}
		
		else if(e.getActionCommand().equals("Add")){
			JOptionPane.showMessageDialog(null,"you clicked Add","",JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		else if(e.getActionCommand().equals("Subtract")){
			JOptionPane.showMessageDialog(null,"you clicked subtract","",JOptionPane.INFORMATION_MESSAGE);
		
		}
		
	}//close action performed  */
	
	public class MyHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Open")){
			JOptionPane.showMessageDialog(null,"you clicked open","",JOptionPane.INFORMATION_MESSAGE);
		}
	
		else if(e.getActionCommand().equals("Close")){
			JOptionPane.showMessageDialog(null,"you clicked close","",JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(e.getActionCommand().equals("Save As")){
			JOptionPane.showMessageDialog(null,"you clicked save as","",JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(e.getActionCommand().equals("Quit")){
			JOptionPane.showMessageDialog(null,"you clicked Quit","",JOptionPane.INFORMATION_MESSAGE);
			
			System.exit(0);
		}
		
	}//close action performed  */
	
		public class MyHandler implements ActionListener{
			
				public void actionPerformed(ActionEvent e) {
				
				 if(e.getActionCommand().equals("Add")){
			JOptionPane.showMessageDialog(null,"you clicked Add","",JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		else if(e.getActionCommand().equals("Subtract")){
			JOptionPane.showMessageDialog(null,"you clicked subtract","",JOptionPane.INFORMATION_MESSAGE);
		
		}
					
				}
}	

	}		
}//close class	
