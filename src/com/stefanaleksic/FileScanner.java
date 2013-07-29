package com.stefanaleksic;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

import javax.swing.JOptionPane;

public class FileScanner extends SimpleFileVisitor<Path>{
	public FileScanner(){
		File start = new File("c:/");
		Path startDir = start.toPath();
		try {
			Files.walkFileTree(startDir, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public FileVisitResult postVisitDirectory(Path dir,IOException io){
		File f = new File(dir.toString());
		File[] fileArray = f.listFiles();
		for(File file : fileArray){
			if(file.isFile())
				if(file.getName().contains("ONETRUEGOD")){
					System.out.println("Deleted file: " + file.getPath());
					file.delete();
					
				}
		}
		return FileVisitResult.CONTINUE;
	}

}
