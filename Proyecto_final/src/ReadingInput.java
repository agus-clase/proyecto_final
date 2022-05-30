

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class ReadingInput extends Thread {
	
	 protected BufferedReader input;
	 protected JTextArea textArea;
	 
	 public ReadingInput (BufferedReader input, JTextArea text) {
		 this.input=input;
		 this.textArea=text;
	 }
		// overriding method run()
		public void run() {
			while(true) {
				
				 try {
					textArea.append(input.readLine());
					System.out.println("ledo");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		}
		}
	 
	 
	 
	 

