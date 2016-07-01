package com.proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		String commands = "java -cp aiml/lib/Ab.jar Main bot=test action=chat trace=false";
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec(commands);
		PrintWriter stdin = new PrintWriter(proc.getOutputStream());
		InputStream stdout = proc.getInputStream();
		InputStream stderr = proc.getErrorStream();
		
		//wpisz do bota
		String komenda = "HELLO ALICE";
		//stdin.println(komenda);
		stdin.flush();
		
		stdin.close();
		
		String line;
	    BufferedReader brCleanUp = new BufferedReader (new InputStreamReader (stdout));
	    while ((line = brCleanUp.readLine ()) != null) {
	    System.out.println ("[Stdout] " + line);
	    }
	    brCleanUp.close();
		
	      // clean up if any output in stderr
	      brCleanUp =
	        new BufferedReader (new InputStreamReader (stderr));
	      while ((line = brCleanUp.readLine ()) != null) {
	        //System.out.println ("[Stderr] " + line);
	      }
	      brCleanUp.close();
	      proc.destroy();
	      rt.exit(0);
		
	}

}
