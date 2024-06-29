package itmo.java.basics.Lab10;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Files {
    public static void main(String[] args) {
        System.out.println("На моем компьютере используются следующие файловые системы:");
        getFsType();

        String fileName = getFileName();
        if (fileName == null) {
            System.out.println("Вы не ввели имени файла, поэтому ничего не делаем.");
        } else {
            List<String> content = readFromFile(fileName);
            System.out.println("Читаем из файла [" + fileName + "]");
            for (String line : content) {
                System.out.println(line);
            }
        }

        fileName = getFileName();
        if (fileName == null) {
            System.out.println("Вы не ввели имени файла, поэтому ничего не делаем.");
        } else {
            System.out.println("Записываем в файл [" + fileName + "]");
            String str = "Hello world !";
            writeToFile(fileName, str, false);
        }

        System.out.println("============================================");
        System.out.println("п.3 Объединяем файлы");

        concatFiles(getFileName(),getFileName(),getFileName());


        System.out.println("============================================");
        System.out.println("п.4 Заменяем символы");
        replaceSomeLetters(getFileName(), "[^A-z0-9А-я]", "\\$");
    }

    public static void getFsType() {
        FileSystem fsType = FileSystems.getDefault();
        System.out.println("Примонтировано");
        for(FileStore store: fsType.getFileStores()) {
            System.out.println("Файловая система : [" + store.name() +"] тип [" + store.type() +"]");
        }
    }

    public static List<String> readFromFile(String fileName) {
        List<String> contentFile = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
            Scanner getFile = new Scanner(fr);

            while (getFile.hasNextLine()) {
                contentFile.add(getFile.nextLine());
            }
        } catch (IOException msg) {
            System.err.println("Возникли ошибки при чтении из файла.");
            System.err.println(msg.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch(IOException msg) {
                System.err.println(msg.getMessage());
            }
        }

        return contentFile;
    }

    public static void writeToFile(String fileName, String string, boolean append) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName, append);
            fw.write(string);
        } catch (IOException msg) {
            System.err.println("Возникли ошибки при записи в файл.");
            System.err.println(msg.getMessage());
        } finally {
            try {
                if(fw!=null) {
                    fw.close();
                }
            } catch (IOException msg) {
                System.err.println(msg.getMessage());
            }
        }
    }

    public static void concatFiles(String theFirstFile, String theSecondFile, String concatFile) {
        List<String> tmp = readFromFile(theFirstFile);

        for (String line : tmp) {
            writeToFile(concatFile, line+"\n", true);
        }

        tmp = readFromFile(theSecondFile);
        for (String line : tmp) {
            writeToFile(concatFile, line+"\n", true);
        }
    }

    public static void replaceSomeLetters(String fileName, String regex, String charToReplace) {
        List<String> tmp = readFromFile(fileName);

        // Очищаем содержимое файла
        writeToFile(fileName, "", false);

        for (String line : tmp) {
            writeToFile(fileName, line.replaceAll(regex, charToReplace) +"\n", true);
        }
    }

    public static String getFileName() {
        String fileName;
        int len;
        Scanner getHuman = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите имя файла, или Enter для завершения ввода:");
        fileName = getHuman.nextLine();
        fileName = fileName.trim();
        if(fileName.length()==0) {
            fileName = null;
        }

        return fileName;
    }
}
