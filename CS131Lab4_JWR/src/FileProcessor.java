import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;
	
	public FileProcessor(String fileName, int stringLength) {
		this.stringList = new ArrayList<>();
        setFileName(fileName);
        setStringLength(stringLength);
	}	
        // This is the getter for fileName
        public String getFileName() {
            return fileName;
        }

        // This is the getter for stringLength
        public int getStringLength() {
            return stringLength;
        }

        // This is the setter for fileName
        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        // This is the setter for stringLength with bounds checking
        public void setStringLength(int stringLength) {
            if (stringLength < 5) {
                this.stringLength = 5;
            } else {
                this.stringLength = stringLength;
            }
        }

        // The method will return the size of the ArrayList
        public int getArrayListSize() {
            return stringList.size();
        }

        // The method will process the file
        public void processFile() {
            try {
                input = new Scanner(new File(fileName));
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    if (line.length() > stringLength) {
                        throw new StringTooLongException();
                    }
                    stringList.add(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (StringTooLongException e) {
                System.out.println(e.getMessage());
            } finally {
                if (input != null) {
                    input.close();
                }
            }
        }

        // This is the main method 
        public static void main(String[] args) {
            FileProcessor fp = new FileProcessor("BadString.txt", 7);
            fp.processFile();
            System.out.println("Processed strings: " + fp.getArrayListSize());
		
	}//end processFile
}//end class
