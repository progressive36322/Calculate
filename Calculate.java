import java.io.FileReader;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

class Calculate {
    public static void main(String[] args) throws Exception {
        String a;
        String b;
        String znak = "";
        String stroka;
        String ogr;
        String str;
        FileReader fileReader = new FileReader("C:\\Users\\79189\\OneDrive\\Документы\\test\\input.txt");
        FileWriter fileWriter = new FileWriter("C:\\Users\\79189\\OneDrive\\Документы\\test\\output.txt");
        Scanner sc = new Scanner(fileReader);
        while (sc.hasNextLine()) {
            try {
                stroka = sc.nextLine();
                ogr = stroka.substring(0, stroka.indexOf(" "));
                a = ogr;
                stroka = stroka.replace(ogr, "").trim();
                ogr = stroka.substring(0, stroka.indexOf(" "));
                znak = ogr;
                stroka = stroka.replace(ogr, "").trim();
                str = stroka;
                fileWriter.write(a + " " + znak + " " + str + " = ");
                b = stroka;
                if (znak.equals("+")) {
                    Double res = Double.valueOf(a) + Double.valueOf(b);
                    fileWriter.write(String.valueOf(res) + "\n");
                } else if (znak.equals("-")) {
                    Double res = Double.valueOf(a) - Double.valueOf(b);
                    fileWriter.write(String.valueOf(res) + "\n");
                } else if (znak.equals("*")) {
                    Double res = Double.valueOf(a) * Double.valueOf(b);
                    fileWriter.write(String.valueOf(res) + "\n");
                } else if (znak.equals("/")) {
                    if (Double.valueOf(b) != 0) {
                        Double res = Double.valueOf(a) / Double.valueOf(b);
                        fileWriter.write(String.valueOf(res) + "\n");
                    }
                    else throw new Exception("Error! Division by zero");
                } else throw new Exception("Operation Error!");
            } catch (InputMismatchException e) {
                fileWriter.write("Error! Not number" + "\n");
            } catch (NumberFormatException e) {
                fileWriter.write("Error! Not number" + "\n");
            } catch (Exception e) {
                fileWriter.write(e.getMessage() + "\n");
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}