import java.io.*;
import java.util.zip.*;
import java.util.Enumeration;
public class ReadAndWriteIO {
	public ReadAndWriteIO() {
		
	}
	
	public void readFile(String name) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(name));
			String inputLine = br.readLine();
			while(inputLine != null) {
				System.out.println(inputLine);
				inputLine = br.readLine();
			}
			br.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public void readAndWrite(String input, String output) {
		try {
			BufferedReader inputText = new BufferedReader(new FileReader(input));
			BufferedWriter outputText = new BufferedWriter(new FileWriter(output));
			String inputLine = inputText.readLine();
			while(inputLine != null){
				outputText.write(inputLine);
				outputText.newLine();
				inputLine = inputText.readLine();
			}
			inputText.close();
			outputText.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public void underThirty(String input, String output, int length, String word) {
		try {
			BufferedReader inputText = new BufferedReader(new FileReader(input));
			BufferedWriter outputText = new BufferedWriter(new FileWriter(output));
			String inputLine = inputText.readLine();
			while(inputLine != null){
				if(!inputLine.trim().equals("") && inputLine.trim().length() <= length && inputLine.contains(word)) {
					outputText.write(inputLine);
					outputText.newLine();
					inputLine = inputText.readLine();
				}else {
					inputLine = inputText.readLine();
				}
			}
			inputText.close();
			outputText.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public void readZip(String zipFile) {
		try {
			ZipFile zip = new ZipFile(zipFile);
			Enumeration<? extends ZipEntry> entries = zip.entries();
			while(entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				String fileName = entry.getName();
				if(fileName.contains("txt")) {
					BufferedReader input = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));
					String inputLine = input.readLine();
					while(inputLine != null) {
						System.out.println(inputLine);
						inputLine = input.readLine();
					}
					input.close();
				}
			}
			zip.close();
		}catch(IOException i) {
			i.getStackTrace();
		}
	}
}
