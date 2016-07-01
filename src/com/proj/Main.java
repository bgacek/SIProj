package com.proj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		String cmd = "cmd";
		String cd = "cd .\\bot\\";
		String commands = "java -cp lib/Ab.jar Main bot=test action=chat trace=false";
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec(cmd);
		PrintWriter stdin = new PrintWriter(proc.getOutputStream());
		InputStream stdout = proc.getInputStream();
		InputStream stderr = proc.getErrorStream();
		Scanner a = new Scanner(System.in);
		//wpisz do bota
		String komenda = "HELLO ALICE";
		stdin.println(cd);
		stdin.flush();
		stdin.println(commands);
		stdin.flush();
		stdin.println(komenda);
		stdin.println("test");
		stdin.flush();
		
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
	      stdin.close();
	      proc.destroy();
	      rt.exit(0);
		
	}

}
