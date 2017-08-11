/**
 * @author João Silva, no.48782
 */

import java.io.IOException;

public class RunArvores {

	public static void main(String[] args) throws IOException {
		// TREE 1
		LabPImage im = new LabPImage(600, 500);
		im.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore1 = new Arvores(im, 300, 500);
		arvore1.arvore1(200);
		im.writeImageToPNG("arvore1.png");
		// TREE 2
		LabPImage im2 = new LabPImage(600, 500);
		im2.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore2 = new Arvores(im2, 300, 500);
		arvore2.arvore2(200);
		im2.writeImageToPNG("arvore2.png");
		// TREE 3
		LabPImage im3 = new LabPImage(600, 500);
		im3.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore3 = new Arvores(im3, 300, 500);
		arvore3.arvore3(200);
		im3.writeImageToPNG("arvore3.png");
		// TREE 4 - A
		LabPImage im4 = new LabPImage(600, 500);
		im4.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore4 = new Arvores(im4, 300, 500);
		arvore4.arvore4(200);
		im4.writeImageToPNG("arvore4a.png");
		// TREE 4 - B
		LabPImage im4b = new LabPImage(600, 500);
		im4b.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore4b = new Arvores(im4b, 300, 500);
		arvore4b.arvore4(200);
		im4b.writeImageToPNG("arvore4b.png");
		// TREE 5 - A
		LabPImage im5 = new LabPImage(600, 500);
		im5.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore5 = new Arvores(im5, 300, 500);
		arvore5.arvore5(200);
		im5.writeImageToPNG("arvore5a.png");
		// TREE 5 - B
		LabPImage im5b = new LabPImage(600, 500);
		im5b.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore5b = new Arvores(im5b, 300, 500);
		arvore5b.arvore5(200);
		im5b.writeImageToPNG("arvore5b.png");
		// TREE 6 - A
		LabPImage im6 = new LabPImage(600, 500);
		im6.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore6 = new Arvores(im6, 300, 500);
		arvore6.arvore6(200);
		im6.writeImageToPNG("arvore6a.png");
		// TREE 6 - B
		LabPImage im6b = new LabPImage(600, 500);
		im6b.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore6b = new Arvores(im6b, 300, 500);
		arvore6b.arvore6(200);
		im6b.writeImageToPNG("arvore6b.png");
		// TREE 7 - A
		LabPImage im7 = new LabPImage(600, 500);
		im7.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore7 = new Arvores(im7, 300, 500);
		arvore7.arvore7(200);
		im7.writeImageToPNG("arvore7a.png");
		// TREE 7 - B
		LabPImage im7b = new LabPImage(600, 500);
		im7b.filledRectangle(0, 0, 600, 500, 0, 0, 0, 255);
		Arvores arvore7b = new Arvores(im7b, 300, 500);
		arvore7b.arvore7(200);
		im7b.writeImageToPNG("arvore7b.png");
	}
}
