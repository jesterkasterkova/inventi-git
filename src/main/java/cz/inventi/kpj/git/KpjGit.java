package cz.inventi.kpj.git;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class KpjGit {

  public static void main(String[] args) {
    System.out.println("Hello KPJ");
    File folder = new File(".");
    Arrays.stream(folder.listFiles())
        .filter(File::isFile)
        .filter(f -> f.getName().endsWith(".name"))
        .forEach(f -> {
          try {
            System.out.println(f.getName().substring(0, f.getName().length() - 5) + ": "
                + Files.lines(Paths.get(f.getPath())).findFirst().orElse(""));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        });
  }

}
