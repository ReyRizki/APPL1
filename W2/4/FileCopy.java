
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class FileCopy {
    public static void copyFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        File file = new File(fileName);
        try {
            sc = new Scanner(file, StandardCharsets.UTF_8.name());
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " not found\n");
            copyFile();
        }
    }

    public static void main(String[] args) {
        copyFile();
    }
}
