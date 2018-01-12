package fr.dwaps.main;

public class Drawer {
	private String fill = "O ";
	private String space = "  ";
	
	public void rect(int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(fill);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void house(int width, int height) {
		if (width > 3 && width%2 != 0) {
			
			int ignoredLines = width/2;
			int spaces = ignoredLines;
			boolean canDraw = false;
			
			for (int i = 1; i <= width; i++) {
				if (i > ignoredLines) {
					for (int k = 0; k < spaces; k++) {
						System.out.print(space);
					}
					
					draw(i-spaces);
					
					canDraw = true;
					spaces--;
				}
				if (canDraw) System.out.println();
			}
			rect(width, height);
		}
		else {
			System.out.println("La largeur renseignée doit être impaire et supérieure à 3.");
		}
	}
	
	private void draw(int cpt) {
		for (int i = 0; i < cpt; i++) {
			System.out.print(fill);
		}
	}
}
