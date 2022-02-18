package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.helper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHelper {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;
    private String fileName;

    public FileHelper() {
    }

    public FileHelper(String fileName) throws IOException {
        this.fileName = fileName;
        this.openFileToWrite(this.fileName);
        this.closeFileAfterWrite();
    }

    public void openFileToWrite(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        printWriter = new PrintWriter(bufferedWriter);
    }

    public void closeFileAfterWrite() throws IOException {
        printWriter.close();
        bufferedWriter.close();
        fileWriter.close();
    }

    public void openFileToRead(String file_name) throws IOException {
        this.scanner = new Scanner(Paths.get(file_name), "UTF-8");
    }

    public void closeFileAfterRead() throws Exception {
        this.scanner.close();
    }

    public ArrayList<String> getDataFromFile (String filename) throws Exception {
        this.openFileToRead(filename);
        ArrayList<String> datas = new ArrayList<>();

        while (this.scanner.hasNextLine()) {
            String line = this.scanner.nextLine();
            datas.add(line);
        }
        this.closeFileAfterRead();

        return datas;
    }

    public void writeDataToFile (String[] info, String fileName) throws IOException {
        openFileToWrite(fileName);

        StringBuilder data = new StringBuilder();
        for (int i = 0; i < info.length; i++) {
            if (i != info.length - 1) {
                data.append(info[i]).append("\\t");
            } else {
                data.append(info[i]);
            }
        }

        printWriter.println(data);

        closeFileAfterWrite();
    }
}

