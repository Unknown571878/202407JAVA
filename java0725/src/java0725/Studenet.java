package java0725;

public class Studenet {
	private String name;
	private int score;

	public Studenet(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Studenet [name=" + name + ", score=" + score + "]";
	}

}
