package game;

public class StageCreator {

	public StageCreator() {

	}

	public Map createStage001() {
		String stageSize = "10,10";
		String charaInfo = "8,1,1";
		String stageData = "1,1,1,1,1,1,1,1,1,1" + "\n" +
						   "1,0,0,0,4,0,0,0,0,1" + "\n" +
						   "1,1,3,1,0,1,0,1,0,1" + "\n" + 
						   "1,1,0,1,0,1,0,1,0,1" + "\n" + 
						   "1,1,0,1,0,1,0,1,0,1" + "\n" + 
						   "1,1,0,1,0,1,0,1,0,1" + "\n" + 
						   "1,1,0,1,0,1,0,1,0,1" + "\n" + 
						   "1,1,0,1,0,1,0,1,2,1" + "\n" + 
						   "1,0,0,1,0,0,0,0,0,1" + "\n" + 
						   "1,1,1,1,1,1,1,1,1,1";

		return new Map(stageSize, charaInfo, stageData);
	}

	public Map createStage002() {
		String stageSize = "10,10";
		String charaInfo = "8,1,1";
		String stageData = "1,1,1,1,1,1,1,1,1,1" + "\n" +
						   "1,0,0,0,1,2,0,0,0,1" + "\n" +
						   "1,0,1,0,1,1,0,1,0,1" + "\n" +
						   "1,0,3,0,1,1,0,1,0,1" + "\n" +
						   "1,0,1,0,1,0,1,0,0,1" + "\n" +
						   "1,0,1,0,1,0,1,1,0,1" + "\n" +
						   "1,0,0,0,1,0,0,0,0,1" + "\n" +
						   "1,1,1,0,1,1,4,1,0,1" + "\n" +
						   "1,0,0,0,1,0,0,0,0,1" + "\n" +
						   "1,1,1,1,1,1,1,1,1,1";

		return new Map(stageSize, charaInfo, stageData);
	}
}
