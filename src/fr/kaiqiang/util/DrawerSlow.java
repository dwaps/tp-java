package fr.kaiqiang.util;

public class DrawerSlow {
	private String symbol = "0 ";

	public void rect(int width, int height) {
		while (height > 0) {
			for (int i = 0; i < width; i++) {
				System.out.print(symbol);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
			height--;
		}
	}
	
	public void setSymbol(String p) {
		if (p.length() > 4) return;
		symbol = p;
	}
}

