/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package initmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;


/**
 * This program demonstrates how to generate a secret-key object for
 * HMAC-MD5, and initialize an HMAC-MD5 object with it.
 * 
 * 
 * My Saurce lab Account Name: Kyuubi009
 * My Saurce lab Access Key: 982b0265-3ac1-4849-9fe2-3297d8afffac
 * Required login link:
 * https://saucelabs.com/tests/23fbd48153034ad8bbecd45741681def
 * 
 * hmac.new("Kyuubi009:982b0265-3ac1-4849-9fe2-3297d8afffac", "23fbd48153034ad8bbecd45741681def", md5).hexdigest()
 * 
 * 
 */

public class InitMac {

    public static void main(String[] args) throws Exception {

        // Generate secret key for HMAC-MD5
        KeyGenerator kg = KeyGenerator.getInstance("HmacMD5");
        SecretKey sk = kg.generateKey();

        // Get instance of Mac object implementing HMAC-MD5, and 
        // initialize it with the above secret key
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(sk);
        String payload ="\"Kyuubi009:982b0265-3ac1-4849-9fe2-3297d8afffac\", \"23fbd48153034ad8bbecd45741681def\"";
        byte[] result = mac.doFinal(payload.getBytes());
        System.out.println(result);
    }
}