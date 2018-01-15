package fr.dwaps.main;

import static fr.dwaps.main.FramesProvider.*;

public class AnimationManager {
	private int nbOfRepetition = 1;
	
	public void numberOfRepetition(int nb) { nbOfRepetition = Math.abs(nb); }
	
	public void startAnimation(String[][] strFrames) {
		startAnimation(strFrames, false);
	}
	
	public void startAnimation(String[][] strFrames, boolean reverseAnim) {
		if (!reverseAnim) {
			for (int i = 0; i < strFrames.length; i++) display(strFrames[i]);
		}
		else {
			for (int i = strFrames.length-1; i >= 0; i--) display(strFrames[i]);
		}
		
		
		nbOfRepetition--;
		if (nbOfRepetition > 0) {
			reverseAnim = !reverseAnim;
			if (strFrames == CAT_AND_MOUSE) changeCatDirection(strFrames, reverseAnim);
			startAnimation(strFrames, reverseAnim);
		}
	}
	
	private void display(String[] frameParts) {
		clearConsole(50);
		for (String f : frameParts) System.out.println(f);
		sleep();
	}
	
	private void sleep() {
		try { Thread.sleep(100); Runtime.getRuntime().exec("clear"); }
		catch (Exception e) { e.printStackTrace(); }
	}
	
	private void clearConsole(int br) {
		for (int i = 0; i < br; i++) System.out.println();
	}
	
	private void changeCatDirection(String[][] strFrames, boolean reversing) {
		String[] tab = { "-oM", "Mo-" };
		String oldStr = reversing ? tab[0] : tab[1];
		String newStr = reversing ? tab[1] : tab[0];
		
		for (int i = 0; i < strFrames.length; i++) {
			for (int j = 0; j < strFrames[i].length; j++) {
				strFrames[i][j] = strFrames[i][j].replace(oldStr, newStr);
			}
		}
	}
}
