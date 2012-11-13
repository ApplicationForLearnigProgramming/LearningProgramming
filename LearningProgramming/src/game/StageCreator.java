package game;

public class StageCreator {

	public StageCreator() {

	}

	public Map createStage001() {
		String filename = "Stage001.map";
		String stageSize = "10,10";
		String charaInfo = "8,1,1";
		String stageData = "1,1,1,1,1,1,1,1,1,1" + "\n" + "1,0,0,0,4,0,0,0,0,1"
				+ "\n" + "1,1,3,1,0,1,0,1,0,1" + "\n" + "1,1,0,1,0,1,0,1,0,1"
				+ "\n" + "1,1,0,1,0,1,0,1,0,1" + "\n" + "1,1,0,1,0,1,0,1,0,1"
				+ "\n" + "1,1,0,1,0,1,0,1,0,1" + "\n" + "1,1,0,1,0,1,0,1,0,1"
				+ "\n" + "1,0,0,1,0,0,0,0,0,1" + "\n" + "1,1,1,1,1,1,1,1,1,1";

		return new Map(filename, stageSize, charaInfo, stageData);
	}

	public void createStage002() {
		//
	}
}
