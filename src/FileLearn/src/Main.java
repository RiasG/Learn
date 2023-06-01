import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(Path.of("FileLearn\\file.txt"), StandardCharsets.UTF_8);
        PrintWriter out = new PrintWriter("FileLearn\\file.txt", StandardCharsets.UTF_8);
        out.println("1234");
        out.close();

    }
}
