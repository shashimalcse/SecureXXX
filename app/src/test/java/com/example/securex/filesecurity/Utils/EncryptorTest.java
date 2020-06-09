package com.example.securex.filesecurity.Utils;


import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import static org.junit.Assert.*;

public class EncryptorTest {

    @Test
    public void encryptToFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","test.mp3");
        InputStream is=new FileInputStream(f);
        File out=new File("src/test/resources");
        File outputFileEnc=new File(out,"EncryptedFile");
        Encryptor.encryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }

    @Test
    public void decryptToFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","EncryptedFile");
        InputStream is=new FileInputStream(f);
        File outputFileEnc=new File("src/test/resources","test2.mp3");
        Encryptor.decryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }
}