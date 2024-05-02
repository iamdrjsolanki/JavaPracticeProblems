package com.practice.java.basic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ResourceException {

	public static void main(String[] args) {
		try {
			ReadWrite rw = new ReadWrite(new File("C:\\Users\\dhiraj.solanki\\Documents\\textin.txt"), new File("C:\\Users\\dhiraj.solanki\\Documents\\textout.txt"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ReadWrite {
	public ReadWrite(File a, File b) throws Exception{
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(a);
			int i;
			while((i=fr.read()) != -1) {
				System.out.print((char)i);
			}
			fw = new FileWriter(b);
			//throwing exception here
			int c = 9/0;
			fw.write("Hi this is a test.");
		} catch(Exception e) {
			int i;
			while((i=fr.read()) != -1) {
				System.out.print((char)i);
			}
		} finally {
			fr.close();
			int i;
			while((i=fr.read()) != -1) {
				System.out.print((char)i);
			}
		}
	}
}
