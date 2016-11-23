package practice.maths.bits;

public class BitsManipulationRunner {

	public static void main(String[] args) {

		ClassLoader loader = ClassLoader.getSystemClassLoader();
		loader.setDefaultAssertionStatus(true);

		BitManipuations bm = new BitManipuations();

		bm.itoBits_builtIn();

		bm.itoBits_2sComplement_builtIn();

		bm.bitsToI_builtIn_with_2sComplement();

		System.out.println("DONE");

	}

}
