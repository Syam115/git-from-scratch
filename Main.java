import java.io.*;

public class Main {

    static void hashBlob(String line) {
        int nul = line.indexOf("\\0");
        if (nul == -1) {
            System.out.println("ERR no NUL separator");
            return;
        }

        String header = line.substring(0, nul);
        String body = line.substring(nul + 2);

        String[] headerParts = header.split(" ");
        if (headerParts.length != 2) {
            System.out.println("ERR header doesn't have 2 parts");
            return;
        }

        String type = headerParts[0];
        int size = Integer.parseInt(headerParts[1]);

        if (!type.equals("blob") && !type.equals("tree") && !type.equals("commit") && !type.equals("tag")) {
            System.out.println("ERR unknown type branch");
            return;
        }

        if (size != body.length()) {
            System.out.println("ERR body length is not equal to size");
            return;
        }

        System.out.println("type " + type);
        System.out.println("size " + size);
        System.out.println("body " + body.length());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String line;
        while ((line = sc.readLine()) != null) {
            hashBlob(line);
        }
    }
}
