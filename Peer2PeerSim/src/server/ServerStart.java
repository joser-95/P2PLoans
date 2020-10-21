package server;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerStart {
	final static Path dirPath = Paths.get("C:\\Users\\Casa\\Desktop\\JavaXML\\PeerTree");
	public static void main(String[] args) {
		System.out.println("Server started");
		fileStructureBuilder();
		CreateXMLLoans loans = new CreateXMLLoans();
	}
	
	private static final void fileStructureBuilder() {
		
		if(Files.exists(dirPath))
			return;
		System.out.println("Structure does not exist, attempting to create directory structure");
		try {
			Files.createDirectories(dirPath);
			File dir = new File(dirPath.toString());
			dir.setWritable(true);
		} catch (Exception e) {
			System.out.println("Server wasn't able to create file structure" + e);
			return;
		}
		System.out.println("file structure created");
	}
	
}
