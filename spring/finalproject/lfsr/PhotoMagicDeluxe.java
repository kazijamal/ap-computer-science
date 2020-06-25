import java.awt.Color;

public class PhotoMagicDeluxe {

	public static String alphaToBin(String alpha) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		String bin = "";
		for (int i = 0; i < alpha.length(); i++) {
			int x = chars.indexOf(chars.substring(i,i+1));
			bin += Integer.toBinaryString(x);
		}
		return bin;
	}

	public static void main(String[] args) {
		String filename = args[0];
		Picture pic = new Picture(filename);
		String alphaPass = args[1];
		String binPass = alphaToBin(alphaPass);
		int tap = Integer.parseInt(args[2]);
		Picture newPic = PhotoMagic.encrypt(pic, binPass, tap);
		newPic.show();
		newPic.save("X" + filename);
	}

}