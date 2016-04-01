package net.dynamo.utility;
import java.security.MessageDigest;
import org.apache.log4j.Logger;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TripleDESTest {
	final static Logger logger = Logger.getLogger(TripleDESTest.class);

    public static void main(String[] args) throws Exception {
    	

    	String text = "kyle boon";

    	byte[] codedtext = new TripleDESTest().encrypt(text);
    	//codedtext=[B@1293dc10;
    	String decodedtext = new TripleDESTest().decrypt(codedtext);

    	System.out.println(codedtext); // this is a byte array, you'll just see a reference to an array
    	System.out.println(decodedtext); // This correctly shows "kyle boon"
    	logger.debug(" main method in TripleDESTest : ");
    }

    public static byte[] encrypt(String message) throws Exception {
    	final MessageDigest md = MessageDigest.getInstance("md5");
    	final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
    			.getBytes("utf-8"));
    	final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
    	for (int j = 0, k = 16; j < 8;) {
    		keyBytes[k++] = keyBytes[j++];
    	}

    	final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
    	final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
    	final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    	cipher.init(Cipher.ENCRYPT_MODE, key, iv);

    	final byte[] plainTextBytes = message.getBytes("utf-8");
    	final byte[] cipherText = cipher.doFinal(plainTextBytes);
    	logger.debug(" encrypt method in TripleDESTest : ");
    	// final String encodedCipherText = new sun.misc.BASE64Encoder()
    	// .encode(cipherText);

    	return cipherText;
    }

    public static String decrypt(byte[] message) throws Exception {
    	final MessageDigest md = MessageDigest.getInstance("md5");
    	final byte[] digestOfPassword = md.digest("HG58YZ3CR9"
    			.getBytes("utf-8"));
    	final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
    	for (int j = 0, k = 16; j < 8;) {
    		keyBytes[k++] = keyBytes[j++];
    	}

    	final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
    	final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
    	final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    	decipher.init(Cipher.DECRYPT_MODE, key, iv);

    	// final byte[] encData = new
    	// sun.misc.BASE64Decoder().decodeBuffer(message);
    	final byte[] plainText = decipher.doFinal(message);
    	logger.debug(" decrypt method in TripleDESTest : ");

    	return new String(plainText, "UTF-8");
    }
}