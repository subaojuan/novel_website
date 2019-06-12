package org.test.commons;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Test;
import org.xatu.novel.util.VerifyCode;

public class VerifyCodeTest {

	@Test
	public void getImg() throws FileNotFoundException {
		VerifyCode verifyCode = new VerifyCode();
		BufferedImage image = verifyCode.getImage();
		
		OutputStream out = new FileOutputStream("WebContent/img/verify.jpg");
		verifyCode.output(image, out);
		System.out.print(verifyCode.getText());
	}
}
