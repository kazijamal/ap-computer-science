import java.awt.Color;

public class PhotoMagic {

	public static Picture encrypt(Picture pic, String password, int tap) {
		LFSR lfsr = new LFSR(password, tap);
		int w = pic.width();
		int h = pic.height();
		Picture newPic = new Picture(w, h);
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				Color c = pic.get(i, j);
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();
				int newR = lfsr.generate(8) ^ r;
				int newG = lfsr.generate(8) ^ g;
				int newB = lfsr.generate(8) ^ b;
				Color newC = new Color(newR, newG, newB);
				newPic.set(i, j, newC);
			}
		}
		return newPic;
	}

	public static void main(String[] args) {
		String filename = args[0];
		Picture pic = new Picture(filename);
		String password = args[1];
		int tap = Integer.parseInt(args[2]);
		Picture newPic = encrypt(pic, password, tap);
		newPic.show();
		newPic.save("X" + filename);
	}

}