package br.com.cod3r.composite.folders;

import br.com.cod3r.composite.folders.model.Component;
import br.com.cod3r.composite.folders.model.File;
import br.com.cod3r.composite.folders.model.Folder;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
		Component firstFile = new File("file1.txt");
		Component secondFile = new File("file2.txt");
		Component thirdFile = new File("certificate.png");
		Component fourthFile = new File("document.pdf");
		Component firstFolder = new Folder("Udemy", Arrays.asList(firstFile, secondFile));
		Component secondFolder = new Folder("Courses", Arrays.asList(firstFolder, thirdFile));
		Component folderDir = new Folder("Documents", Arrays.asList(secondFolder, fourthFile));

		folderDir.print("");
		folderDir.delete(fourthFile);
		folderDir.print("");
		thirdFile.delete(thirdFile);
		thirdFile.delete(fourthFile);
		folderDir.delete(folderDir);
		folderDir.delete(thirdFile);
		folderDir.print("");
		firstFile.add(new File("file5.txt"));
		folderDir.add(new File("file5.txt"));
		folderDir.print("");

	}
}
