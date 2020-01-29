import java.util.Scanner;
public class Mainclass {
	public static void main(String[] args) {
		ReadAndWriteIO io = new ReadAndWriteIO();
		Scanner scan = new Scanner(System.in);
		String inputFile;
		String outputFile;
		String contains_words;
		int wanted_length;
		int choice;
		while(true) {
			System.out.println("");
			System.out.println("1. Read text file.");
			System.out.println("2. Transfer file info to different file.");
			System.out.println("3. Transfer file lines that contain certain word and certain length to different file.");
			System.out.println("4. Read text file in zip-file.");
			System.out.println("0. Exit.");
			System.out.print("Your choice: ");
			choice = scan.nextInt();
			if(choice == 1) {
				System.out.print("File name: ");
				inputFile = scan.next();
				io.readFile(inputFile);
			}else if(choice == 2) {
				System.out.print("Input file name: ");
				inputFile = scan.next();
				System.out.print("Output file name: ");
				outputFile = scan.next();
				io.readAndWrite(inputFile, outputFile);
			}else if(choice == 3) {
				System.out.print("Input file name: ");
				inputFile = scan.next();
				System.out.print("Output file name: ");
				outputFile = scan.next();
				System.out.print("Contains: ");
				contains_words = scan.next();
				System.out.print("Maximum length: ");
				wanted_length = scan.nextInt();
				io.underThirty(inputFile, outputFile, wanted_length, contains_words);
			}else if(choice == 4) {
				System.out.print("Zip-file name: ");
				inputFile = scan.next();
				io.readZip(inputFile);
			}else if(choice == 0) {
				scan.close();
				break;
			}else {
				System.out.println("Unknown input.");
			}
		}
	}
}
