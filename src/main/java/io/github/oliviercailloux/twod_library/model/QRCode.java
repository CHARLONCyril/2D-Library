package io.github.oliviercailloux.twod_library.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCode { //https://thierry-leriche-dessirier.developpez.com/tutoriels/java/creer-qrcode-zxing-java2d-5-min/
	
	 public static void main(String[] args) throws WriterException, IOException {
		 	Author myauthor = new Author("Jean","Paul");
		 	Book mybook=new Book("titre",myauthor,1998,"Bon livre blablablabla");
		 	String data = mybook.getDescription();
	        int size = 400;
	        BitMatrix bitMatrix = generateMatrix(data, size);String imageFormat = "png";
	        String outputFileName = "C:/Users/ANTHO/Desktop/monfichier." + imageFormat; //emplacement où il stock mon image QRCode

	        writeImage(outputFileName, imageFormat, bitMatrix);
	    }

	    private static void writeImage(String outputFileName, String imageFormat, BitMatrix bitMatrix) throws IOException  {
	        FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFileName));
	        MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, fileOutputStream);
	        fileOutputStream.close();
	    
	    }

	    private static BitMatrix generateMatrix(String data, int size) throws WriterException {
	        BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
	        return bitMatrix;
	    }

	    
	public QRCode() {
		
	}

}
