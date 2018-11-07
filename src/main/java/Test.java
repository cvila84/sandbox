import java.io.IOException;
import java.io.InputStream;

public class Test {
	private String toHexString(byte[] b) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < b.length; i++) {
			sb.append(Character.forDigit((b[i] >> 4) & 0x0f, 16));
			sb.append(Character.forDigit(b[i] & 0x0f, 16));
			sb.append(' ');
		}
		return sb.toString();
	}
	private void run() throws IOException {
		InputStream is = getClass().getResourceAsStream("UpdateMSPL.bin");
		byte[] b1 = new byte[1024];
		int nRead = is.read(b1, 0, b1.length);
//		System.out.println(nRead);
//		for(int i = 0; i < nRead; i++) {
//			System.out.println("b1[" + i + "]=" + b1[i]);
//		}
		byte[] b2 = new byte[nRead];
		System.arraycopy(b1, 0, b2, 0, nRead);
		System.out.println(toHexString(b2));
	}
	public static void main(String[] args) {
		try {
			new Test().run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
