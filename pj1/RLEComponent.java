
public class RLEComponent {

	public int[] intensity = new int[3];
	public int length;

	RLEComponent() {
		this({0,0,0},1);
	}

	RLEComponent(int[3] intensity, int length){
		intensity[0] = r;
		intensity[1] = g;
		intensity[2] = b;
		this.length = length;
	}

	public String toString() {
		return (Integer.toString(intensity[0])
		+ "," + Integer.toString(intensity[1])
		+ "," + Integer.toString(intensity[2])
		+ ";" + Integer.toString(length));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
