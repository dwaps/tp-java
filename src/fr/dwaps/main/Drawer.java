package fr.dwaps.main;

import java.util.Scanner;

public class Drawer {
	private static final String WHAT = "Que voulez-vous ? [Rh] ";
	private static final String DIMENSIONS = "Quelles dimensions ? [width height] ";
	private static final String ANIMATION_MODE = "Mode animation ? [On] ";
	private static final String RESTART = "Voulez-vous recommencer ? [On] ";
	private static final String DIM_CORRECTION = "Correction automatique des dimensions.";
	
	private String fill = "O ";
	private String space = "  ";
	private boolean animated = false;
	private static Scanner sc = new Scanner(System.in);

	// Getters / Setters
	public boolean isAnimated() {
		return animated;
	}

	public void setAnimated(boolean animated) {
		this.animated = animated;
	}
	
	// Methods
	public void doWhatUserWant() {
		boolean house = false;
		int width = 0, height = 0;
		
		// Récupération du choix de la forme
		System.out.print(WHAT);
		String response = sc.nextLine();
		if (response.equals("h")) house = true;
		
		// Récupération des dimensions de la forme
		System.out.print(DIMENSIONS);
		response = sc.nextLine();
		
		try {
			String tab[] = response.split(" ");
			width = Integer.parseInt(tab[0]);
			height = Integer.parseInt(tab[1]);
		}
		catch (Exception e) {
			setAnimated(false);
			doWhatUserWant();
		}
		
		// Récupération du mode choisi (animation ou simple)
		System.out.print(ANIMATION_MODE);
		response = sc.nextLine();
		if (!response.equals("n")) setAnimated(true);
		
		if (house) house(width, height);
		else rect(width, height);
	}
	
	private void sleep(boolean animated) {
		if (animated) {
			try { Thread.sleep(30); }
			catch (InterruptedException e) {}
		}
	}
	
	private void rect(int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				sleep(animated);
				System.out.print(fill);
			}
			System.out.println();
		}

		System.out.print(RESTART);
		String response = sc.nextLine();
		
		if (!response.equals("n")) {
			setAnimated(false);
			doWhatUserWant();
		}
		else {
			System.out.println("Bye bye ! 😀");
			System.exit(0);
		}
	}
	
	private void house(int width, int height) {
		boolean widthOK = width > 2 && width%2 != 0;
		boolean heightOK = height/2 >= 2 && height >= width/2;
		
		if (widthOK && heightOK) {
			
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
			rect(width, height/2-1);
		}
		else {
			System.out.println(DIM_CORRECTION);
			house(widthOK ? width : ++width, heightOK ? height : ++height);
		}
	}

	private void draw(int cpt) {
		for (int i = 0; i < cpt; i++) {
			sleep(animated);
			System.out.print(fill);
		}
	}
}
