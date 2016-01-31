package com.gsmayya.cups.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.stream.Stream;

/**
 * Created by gseethar on 5/4/15.
 */
public class Base64Test {

    public static void main(String[] args) throws FileNotFoundException {

	FileReader fileReader = new FileReader("/usr/share/dict/words");
	BufferedReader bufferedReader = new BufferedReader(fileReader);
	Stream<String> lines = bufferedReader.lines().limit(10);
	lines.forEach(line -> {

	    byte[] message = line.getBytes(StandardCharsets.UTF_8);
	    String encoded = Base64.getEncoder().encodeToString(message);

	    String encodedCI = encoded.toLowerCase();

	    byte[] decoded = Base64.getDecoder().decode(encoded);
	    byte[] decodedCI = Base64.getDecoder().decode(encodedCI);
	    System.out.println(new String(decoded, StandardCharsets.UTF_8));
	    System.out.println(new String(decodedCI, StandardCharsets.UTF_8));
	});
    }
}
