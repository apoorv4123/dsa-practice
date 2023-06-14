package L16_StackQueue;

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception {

		// Works only if your stack is full
		if (isFull()) {

			// create a new array of double size
			int[] na = new int[2 * data.length];

			// copy previous elements to new array
			for (int i = 0; i <= tos; i++) {
				na[i] = data[i];
			}

			// change the reference
			data = na;

		}
		
		//this must be out of if(){}
		super.push(item);

	}

}
