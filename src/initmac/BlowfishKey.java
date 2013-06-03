/*
 * Copyright 1997-2001 by Oracle and/or its affiliates.,
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Oracle and/or its affiliates. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Sun.
 */

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * This program generates a Blowfish key, retrieves its raw bytes, and 
 * then reinstantiates a Blowfish key from the key bytes.
 * The reinstantiated key is used to initialize a Blowfish cipher for
 * encryption.
 */

public class BlowfishKey {

    public static void main(String[] args) throws Exception {

        KeyGenerator kgen = KeyGenerator.getInstance("Blowfish");
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "Blowfish");

        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = 
            cipher.doFinal("This is just an example".getBytes());
                System.out.println(encrypted.toString());
    }
}