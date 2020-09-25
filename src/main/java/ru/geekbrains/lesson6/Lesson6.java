package ru.geekbrains.lesson6;

import java.io.*;

/*
Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
* Написать метод, который проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
** Написать метод, проверяющий, есть ли указанное слово в папке
 */
public class Lesson6 {

    final static String CURRENT_DIR = "src/main/java/ru/geekbrains/lesson6/";

    public static void main(String[] args) {
        try {
            mergingFiles("file1.txt", "file2.txt", "file3.txt");
            System.out.println("Есть ли слово в указанном файле " + findWord("hello wor", "findfile.txt"));
            System.out.println("Есть ли заданное слово в указанной папке " + findWordInDirectory("hello1", CURRENT_DIR));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     ** Написать метод, проверяющий, есть ли указанное слово в папке
     *
     * @param findWord слово, которое вы хотите найти в файле с учетом регистра
     * @param fileName имя файла, в котором вы хотите искать слово. Имя файла необходимо писать без абсолютного пути
     * @return boolean true, если метод нашел слово в файле, false, если нет
     */
    private static boolean findWordInDirectory(String word, String directoryPath) throws Exception {
        File path = new File(directoryPath);
        if (!path.exists() && !path.isDirectory())
            throw new Exception("Вы указали некорректный путь к директории");
        File[] files = path.listFiles();
        for (File file : files) {
            if (findWord(word, file.getName()))
                return true;
        }
        return false;
    }

    /*
     * Написать метод, который проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
     *
     * @param findWord слово, которое вы хотите найти в файле с учетом регистра
     * @param fileName имя файла, в котором вы хотите искать слово. Имя файла необходимо писать без абсолютного пути
     * @return boolean true, если метод нашел слово в файле, false, если нет
     */
    private static boolean findWord(String findWord, String fileName) throws IOException {
        fileName = getAbsolutePathToFile(fileName);
        int currentInt, indexWord = 0;
        char currentChar;

        FileInputStream fis = new FileInputStream(fileName);

        while ((currentInt = fis.read()) != -1) {
            currentChar = (char) currentInt;
            if (findWord.charAt(indexWord) == currentChar)
                indexWord++;
            else
                indexWord = 0;

            if (indexWord == findWord.length()) {
                fis.close();
                return true;
            }
        }

        fis.close();


        return false;
    }


    /*
     * склеивание файлов
     * @param fileName1 имя файла в текущей директории
     * @param fileName2 имя файла в текущей директории
     * @return outputFile имя выходного файла. Сохраняется в текущей директории
     */

    private static void mergingFiles(String fileName1, String fileName2, String outputFile) throws IOException {
        fileName1 = getAbsolutePathToFile(fileName1);
        fileName2 = getAbsolutePathToFile(fileName2);
        outputFile = getAbsolutePathToFile(outputFile);

        FileInputStream fis1 = new FileInputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);
        FileOutputStream fos = new FileOutputStream(outputFile);

        writeFile(fis1, fos);
        writeFile(fis2, fos);

        fis1.close();
        fis2.close();
        fos.close();


    }


    /*
     * склеивание двух файлов в третий
     * @param fis входной поток
     * @param fos выходной поток
     */
    private static void writeFile(FileInputStream fis, FileOutputStream fos) throws IOException {
        int temp;
        while ((temp = fis.read()) != -1) {
            fos.write(temp);
        }
    }

    /* получение абсолютного пути до файла
    @param fileName имя файла.
    @return String возвращает абсолютный путь до текущей директории + имя файла
     */
    private static String getAbsolutePathToFile(String fileName) {
        return CURRENT_DIR + fileName;
    }
}
