package fr.dwaps.main;

public class Drawer {
	private String fill = "O ";
	
	public void rect(int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(fill);
			}
			System.out.println();
		}
		System.out.println();
	}
}
