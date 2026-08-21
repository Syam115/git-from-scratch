import java.io.*;
import java.security.MessageDigest;

public class Main {

    static String hashBlob(byte[] content) throws Exception {
        byte[] header = String.format("blob %d\0", content.length)
                .getBytes();

        // TODO: byte[] combined = ...
        // TODO: MessageDigest sha1 = ...
        // TODO: return ...

        byte[] blob = new byte[header.length + content.length];
        System.arraycopy(header, 0, blob, 0, header.length);
        System.arraycopy(content, 0, blob, header.length, content.length);

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

        byte[] hashBytes = messageDigest.digest(blob);
        StringBuilder hexString = new StringBuilder();
        for (byte b: hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
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
