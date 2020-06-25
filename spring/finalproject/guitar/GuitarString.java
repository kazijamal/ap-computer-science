public class GuitarString {

	private RingBuffer string;
	private int tics;
	private final int N;

	// create a guitar string of the given frequency, using a sampling rate of 44,100
	public GuitarString(double frequency) {
		N = (int) Math.ceil(44100.0 / frequency);
		string = new RingBuffer(N);
		for (int i = 0; i < N; i++) {
			string.enqueue(0.0);
		}
	}

	// create a guitar string whose size and initial values are given by the array
	public GuitarString(double[] init) {
		N = init.length;
		string = new RingBuffer(N);
		for (double x : init) {
			string.enqueue(x);
		}
	}

	// set the buffer to white noise
	public void pluck() {
		for (int i = 0; i < N; i++) {
			string.dequeue();
		}
		for (int i = 0; i < N; i++) {
			double r = Math.random() - 0.5; // random number between -0.5 and 0.5 inclusive
			string.enqueue(r);
		}
	}

	// advance the simulation one time step
	public void tic() {
		double x = string.dequeue();
		double y = string.peek();
		string.enqueue((x + y) / 2 * 0.994);
		tics++;
	}

	// return the current sample
	public double sample() {
		return string.peek();
	}

	// return number of tics
	public int time() {
		return tics;
	}

}