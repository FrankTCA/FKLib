import java.io.BufferedReader;
import java.io.FileReader;
import mem.Node;

public class FileReader {
  private File file;
  private BufferedReader reader;

  public FileReader(File file1) {
    file = file1;
    reader = new BufferedReader(new FileReader(file));
  }

  public Node getLineNode() {
    String line;
    Node node = new Node();
    while ((line = reader.readLine()) != null) {
      node.addValue(line);
    }
    return node;
  }

  public String getAllAsString() {
    Node lines = getLineNode();
    String theLines = "";
    String line;
    for (int i = 0; i < lines.getLength(); i++) {
      line = lines.get(i);
      theLines = theLines + line;
    }
    return theLines;
  }

  public String getSpecificLine(int line) {
    Node lines = getLineNode();
    return lines.get(line);
  }

  public String getLineWithKeyword(String keyword) {
    Node lines;
    String line;
    for (int i = 0; i < lines.getLength(); i++) {
      line = lines.get(i);
      if (line.contains(keyword)) {
        return line;
      }
    }
    return null;
  }
}
