package fr.dwaps.main;

public class MainClass {

	public static void main(String[] args) {
		AnimationManager am = new AnimationManager();
		am.numberOfRepetition(3);
		am.startAnimation(FramesProvider.CAT_AND_MOUSE);
	}

}