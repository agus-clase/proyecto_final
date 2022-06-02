

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JTextArea;

public class ReadingInput extends Thread {
	
	 protected BufferedReader input;
	 protected JTextArea textArea;
	 protected ObjectInputStream obj_input;
	 
	 public ReadingInput (BufferedReader input, JTextArea text,ObjectInputStream obj_input) {
		 this.input=input;
		 this.textArea=text;
		 this.obj_input=obj_input;
	 }
		// overriding method run()
		public void run() {
			while(true) {
				
				 try {
					 
					 Producto prod_enviado=(Producto)obj_input.readObject();
					 System.out.println("recibido");
					textArea.append(prod_enviado+"\n");
					
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		}
		}
	 // para enviar y recibir objetos por sockets

	 // ObjectInputStream obj=new ObjectInputStream( new BufferedinputStream(socket.getInputStream()));
	
	 
	 

