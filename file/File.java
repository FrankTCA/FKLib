import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class File {
  private String path;
  private String name;
  private java.io.File file;
  
  public File(String path1) {
    path = path1;
    String splitPath = path.split("/");
    name = splitPath[splitPath.length - 1];
    file = new java.io.File(path);
  }

  public String getExtension() {
    String splitName = name.split(".");
    return splitName[splitName.length - 1];
  }

  public String getPath() {
    return path;
  }

  public String getName() {
    return name;
  }

  public java.io.File getAsStandardJavaFile() {
    return file;
  }

  public boolean hasReadPermission() {
    return file.canRead();
  }

  public boolean hasWritePermission() {
    return file.canWrite();
  }

  public File copyFile(String newPath) {
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String theText = "";
    String line;
    while ((line = reader.readLine()) != null) {
      theText = theText + line + System.getProperty("line.seperator");
    }
    File f = new File(newPath);
    f.createNewFile();
    BufferedWriter writer = new BufferedWriter(new FileWriter(f));
    writer.write(theText);
    writer.flush();
    writer.close();
    return f;
  }

  public boolean create() {
    if (file.createNewFile()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean delete() {
    if (file.delete()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean exists() {
    if (file.exists()) {
      return true;
    } else {
      return false;
    }
  }
}
