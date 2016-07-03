package com.proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main 
{
	private static final String cmd = "cmd";
	private static final String cd = "cd .\\bot\\";
	private static final String commands = "java -cp lib/Ab.jar Main bot=test action=chat trace=false";	
	
	public static void main(String[] args) throws IOException 
	{
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec(cmd);
		PrintWriter stdin = new PrintWriter(proc.getOutputStream());
		InputStream stdout = proc.getInputStream();

		stdin.println(cd);
		stdin.flush();
		stdin.println(commands);
		stdin.flush();

		BufferedReader brCleanUp = new BufferedReader (new InputStreamReader (stdout));
		ChatWindow chatWindow = new ChatWindow();
		
		int x = 0;
	    while(x < 37)
	    {
	    	brCleanUp.readLine();
	    	x++;
	    }
	    
	    chatWindow.setConsole("Hello I'm robot ... just ask me about sth and I will try to answer :)");
	    
	    while(!chatWindow.getAnswer().equals("Koniec"))
	    {
			if(!chatWindow.getAnswer().equals(""))
			{
				stdin.println(chatWindow.getAnswer());
				stdin.flush();
				String console = brCleanUp.readLine();
		    	chatWindow.setConsole(console.substring(0, 6)+" "+chatWindow.getAnswer()+"\n"+console.substring(7));
		    	chatWindow.setAnswer("");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
		stdin.close();
		brCleanUp.close();
		proc.destroy();
	    rt.exit(0);
	   
	}

}
