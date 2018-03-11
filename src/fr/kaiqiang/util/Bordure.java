package fr.kaiqiang.util;

public class Bordure {
	private String symbol = "0 ";
	
	public void bord(int premcol, int premlig,int derncol, int dernlig, int height, int width) {
			while (premlig < width) {
				System.out.print("N ");
				premlig++;
			}
			while (premcol < height) {
				System.out.println("N ");
				premcol++;
			}
				while (height > 0) {
					for (int i = 0; i < width; i++) {
						System.out.print(symbol);
						
					}
					System.out.println();
					height--;
				}
				
			Drawer d = new Drawer();
			d.rect(width, height);
			
			derncol = height++;
			dernlig = width++;
			
			while ( derncol > height ) {
				System.out.println("N ");
				derncol--;
			}
			while (dernlig < width) {
				System.out.print("N ");
				dernlig--;
			}
			
	}
}
