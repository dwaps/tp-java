package fr.dwaps.main;

public class Drawer {
	public static final int SPEED_LOW = 100;
	public static final int SPEED_NORMAL = 50;
	public static final int SPEED_FAST = 10;
	
	private static final String FILL = "O ";
	private static final String SPACE = "  ";
	private static final String BORDER = "# ";
	
	private static final String ERROR_DRAW_HOUSE = "La maison ne peut pas être dessinée";
	
	private boolean animated = false;
	private boolean bordered = false;
	private int speed = SPEED_NORMAL;

	// Setters
	public void setAnimated(boolean animated) { this.animated = animated; }
	public void setBordered(boolean bordered) { this.bordered = bordered; }
	public void setSpeed(int speed) { this.speed = speed; }
	
	// Getters
	public boolean getAnimated() { return animated; }
	public boolean getBordered() { return bordered; }
	public int getSpeed() { return speed; }
	
	// Methods
	public void rect(int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				boolean b = bordered ?
					(i== 0 || i == height-1 || j == 0 || j == width-1) : false;
				
				System.out.print(b ? BORDER : FILL);
				sleep(speed);
			}
			System.out.println();
		}
	}
	
	public void house(int width, int height) {
		boolean minWidthAuthorized = width > 3;
		boolean isOddWidth = width%2 != 0;
		boolean homeBaseIsValid = height > width/2+1;
		
		if (minWidthAuthorized && isOddWidth && homeBaseIsValid) {
			final int nbIgnoredLines = width/2;
			int cptSpaces = width/2;
			
			for (int i = nbIgnoredLines+1; i <= width; i++) {
				draw(false, cptSpaces); // Drawing spaces
				draw(true, i-cptSpaces); // Drawing fills
				
				System.out.println();
				cptSpaces--;
			}
			
			rect(width, height-nbIgnoredLines-1);
		} else {
			System.out.println(ERROR_DRAW_HOUSE);
		}
	}
	
	private void draw(boolean isFillElement, int cpt) {
		for (int i = 0; i < cpt; i++) {
			if (isFillElement) {
				System.out.print(FILL);
				sleep(speed);
			} else {
				System.out.print(SPACE);
			}
		}
	}
	
	private void sleep(int millis) {
		if (animated) {
			try { Thread.sleep(millis); }
			catch (Exception e) {}
		}
	}
	
}
