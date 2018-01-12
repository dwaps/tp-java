package fr.dwaps.main;

public class Drawer {
	private String fill = "O ";
	private String border = "# ";
	private boolean animated = false;
	private boolean bordered = false;
	
	public void rect(int width, int height) {
		for (int i = 0; i < height; i++) {
			sleep(30);
			for (int j = 0; j < width; j++) {
				boolean b = bordered ?
					(i== 0 || i == height-1 || j == 0 || j == width-1) : false;
				
				System.out.print(b ? border : fill);
				sleep(30);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void sleep(int millis) {
		if (animated) {
			try { Thread.sleep(millis); }
			catch (Exception e) {}
		}
	}
	
	public void setAnimated(boolean animated) {
		this.animated = animated;
	}
	
	public void setBordered(boolean bordered) {
		this.bordered = bordered;
	}
}
