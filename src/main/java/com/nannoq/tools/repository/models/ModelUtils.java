package com.nannoq.tools.repository.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class defines helpers for Model operations.
 *
 * @author Anders Mikkelsen
 * @version 17.11.2017
 */
public class ModelUtils {
    public static String hashString(String stringToHash) throws NoSuchAlgorithmException {
        MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
        digest.update(stringToHash.getBytes());
        byte messageDigest[] = digest.digest();

        StringBuilder hexString = new StringBuilder();

        for (byte aMessageDigest : messageDigest) {
            hexString.append(Integer.toHexString(0xFF & aMessageDigest));
        }

        return hexString.toString();
    }

    public static String returnNewEtag(long tag) {
        try {
            return ModelUtils.hashString(String.valueOf(tag));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

            return String.valueOf(tag);
        }
    }
}
