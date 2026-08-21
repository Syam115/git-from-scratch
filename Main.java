import java.io.*;
import java.security.MessageDigest;

public class Main {

    static String hashBlob(byte[] content) {
        byte[] header = String.format("blob %d\0", content.length)
                .getBytes();

        // TODO: byte[] combined = ...
        // TODO: MessageDigest sha1 = ...
        // TODO: return ...

        return "";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String line;
        while ((line = sc.readLine()) != null) {
            System.out.println(hashBlob(line.getBytes()));
        }
    }
}
