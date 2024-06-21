import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        printMessageDigest();
        printSecureRandom();


        HashSet<Player> players = new HashSet<>();
        HashSet<WrongPlayer> wrongPlayers = new HashSet<>();


        players.add(new Player("Test", 293, true));
        players.add(new Player("qenze", 1, false));
        players.add(new Player("Player123", 11923, true));
        players.add(new Player("Test", 294, true));
        players.add(new Player("Test", 294, true));

        wrongPlayers.add(new WrongPlayer("Test", 293, true));
        wrongPlayers.add(new WrongPlayer("qenze", 1, false));
        wrongPlayers.add(new WrongPlayer("12345", 11923, true));
        wrongPlayers.add(new WrongPlayer("Test", 295, true));
        wrongPlayers.add(new WrongPlayer("Test", 295, true));

        System.out.println("\nPlayers with normal equals and hashCode\n");
        players.forEach(x -> {
            System.out.println(x.hashCode());
        });

        System.out.println("\nPlayers with broken equals and hashCode\n");
        wrongPlayers.forEach(x -> {
            System.out.println(x.hashCode());
        });

    }

    public static void printMessageDigest() throws NoSuchAlgorithmException {
        System.out.println("\nMessageDigest outputs\n");
        System.out.println("MessageDigest using MD5\n"+convertByteArrayToHexString(MessageDigest.getInstance("MD5").digest("My message 123".getBytes())));
        System.out.println("MessageDigest using SHA-256\n"+convertByteArrayToHexString(MessageDigest.getInstance("SHA-256").digest("My message 123".getBytes())));
        System.out.println("MessageDigest using SHA-512\n"+ convertByteArrayToHexString(MessageDigest.getInstance("SHA-512").digest("My message 123".getBytes())));
    }

    public static void printSecureRandom() throws NoSuchAlgorithmException {
        System.out.println("\nSecureRandom outputs\n");

        byte[] message = new byte[32];

        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(1);

        sr.nextBytes(message);
        System.out.println("SecureRandom SHA1PRNG\n"+convertByteArrayToHexString(message));


        sr = SecureRandom.getInstance("DRBG");
        sr.setSeed(1);

        sr.nextBytes(message);
        System.out.println("SecureRandom DRBG\n"+convertByteArrayToHexString(message));


        sr = SecureRandom.getInstance("Windows-PRNG");
        sr.setSeed(1);

        sr.nextBytes(message);
        System.out.println("SecureRandom Windows-PRNG\n"+convertByteArrayToHexString(message));

    }

    public static String convertByteArrayToHexString(byte[] byteArray) {
        if (byteArray == null) {
            throw new IllegalArgumentException("The byte array cannot be null");
        }
        StringBuilder hexString = new StringBuilder(2 * byteArray.length);
        for (byte b : byteArray) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}