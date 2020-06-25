import java.util.ArrayList;

public class GuitarHero {

	public static void main(String[] args) {

		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; 
		ArrayList<GuitarString> strings = new ArrayList<GuitarString>();

		for (int i = 0; i < keyboard.length(); i++) {
			strings.add(new GuitarString(440 * Math.pow(1.05956, i - 24)));
		}

		// the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                int index = keyboard.indexOf(key);
                if (index != -1)
                	strings.get(index).pluck();
            }

            // compute the superposition of the samples
            double sample = 0.0;
            for (GuitarString s : strings) {
            	sample += s.sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (GuitarString s : strings) {
            	s.tic();
            }
        }
    }

}