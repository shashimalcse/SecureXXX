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
import ir.mahdi.mzip.zip.ZipArchive;
import javax.crypto.NoSuchPaddingException;

import static org.junit.Assert.*;

public class EncryptorTest {
    //test for audio encryption
    @Test
    public void encryptToAudioFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","test.mp3");
        InputStream is=new FileInputStream(f);
        File out=new File("src/test/resources");
        File outputFileEnc=new File(out,"EncryptedAudioFile");
        Encryptor.encryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }

    @Test
    public void decryptToAudioFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","EncryptedAudioFile");
        InputStream is=new FileInputStream(f);
        File outputFileEnc=new File("src/test/resources","Decrypted.mp3");
        Encryptor.decryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }
    //test for image encryption
    @Test
    public void encryptToImageFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","test.png");
        InputStream is=new FileInputStream(f);
        File out=new File("src/test/resources");
        File outputFileEnc=new File(out,"EncryptedImageFile");
        Encryptor.encryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }

    @Test
    public void decryptToImageFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","EncryptedImageFile");
        InputStream is=new FileInputStream(f);
        File outputFileEnc=new File("src/test/resources","Decrypted.png");
        Encryptor.decryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }
    //test for video encryption
    @Test
    public void encryptToVideoFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","test.mp4");
        InputStream is=new FileInputStream(f);
        File out=new File("src/test/resources");
        File outputFileEnc=new File(out,"EncryptedVideoFile");
        Encryptor.encryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }

    @Test
    public void decryptToVideoFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","EncryptedVideoFile");
        InputStream is=new FileInputStream(f);
        File outputFileEnc=new File("src/test/resources","Decrypted.mp4");
        Encryptor.decryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }

    //test for text encryption
    @Test
    public void encryptToTextFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","test.txt");
        InputStream is=new FileInputStream(f);
        File out=new File("src/test/resources");
        File outputFileEnc=new File(out,"EncryptedTextFile");
        Encryptor.encryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }

    @Test
    public void decryptToTextFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","EncryptedTextFile");
        InputStream is=new FileInputStream(f);
        File outputFileEnc=new File("src/test/resources","Decrypted.txt");
        Encryptor.decryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }

    //test for folder encryption
    @Test
    public void encryptToFolder() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        ZipArchive zipArchive = new ZipArchive();
        zipArchive.zip("src/test/resources/Folder","src/test/resources"+"/FolderZip.zip","");
        File fileZip = new File("src/test/resources","FolderZip.zip");
        InputStream is=new FileInputStream(fileZip);
        File outputFileEnc=new File("src/test/resources","FolderEncrypted");
        Encryptor.encryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }
    @Test
    public void decryptToFolder() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","FolderEncrypted");
        ZipArchive zipArchive = new ZipArchive();
        InputStream is=new FileInputStream(f);
        File outputFileEnc=new File("src/test/resources/Folder","DecryptedFolder.zip");
        Encryptor.decryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
        zipArchive.unzip("src/test/resources/Folder/DecryptedFolder.zip","src/test/resources/Folder","");
    }

    @Test
    //Test for anyfile encryption
    public void encryptToAnyFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","test.aep");
        InputStream is=new FileInputStream(f);
        File out=new File("src/test/resources");
        File outputFileEnc=new File(out,"EncryptedAdobeFile");
        Encryptor.encryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }

    @Test
    public void decryptToAnyFile() throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
        File f=new File("src/test/resources","EncryptedAdobeFile");
        InputStream is=new FileInputStream(f);
        File outputFileEnc=new File("src/test/resources","DecryptedAdobeFile.aep");
        Encryptor.decryptToFile("1111111111111111","1111111111111111",is,new FileOutputStream(outputFileEnc));
    }


}