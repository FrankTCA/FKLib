import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileWriter {
  private File file;
  private BufferedWriter writer;

  public FileWriter(File file1) {
    file = file1;
    writer = new BufferedWriter(new java.io.FileWriter(file.getAsStandardJavaFile()));
  }

  public void write(String toWrite) {
    FileReader reader = new FileReader(file);
    String text = reader.getAllAsString();
    text = text + toWrite;
    writer.write(text);
    writer.flush();
    writer.close();
  }

  public void clearFile() {
    writer.write("");
    writer.flush();
    writer.close();
  }

  public File getFile() {
    return file;
  }

  public BufferedWriter getJavaNativeWriter() {
    return writer;
  }

  public void writeInMiddleFile(int after, String toWrite) {
    FileReader reader = new FileReader(file);
    Node lines = reader.getLineNode();
    lines.addValueAfter(after, toWrite);
    String fileText;
    String line;
    for (int i = 0; i < lines.getLength(); i++) {
      line = lines.get(i);
      fileText = fileText + line + System.getProperty("line.seperator");
    }
    clearFile();
    write(fileText);
  }
}
