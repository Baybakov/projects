package task1;

class Arithmetic {

	public static void main(String[] args) {
		System.out.println("Тип byte принимает значения от " +
				Byte.MIN_VALUE + " до " + Byte.MAX_VALUE);
		System.out.println("Тип short принимает значения от " +
				Short.MIN_VALUE + " до " + Short.MAX_VALUE);
		System.out.println("Тип int принимает значения от " +
				Integer.MIN_VALUE + " до " + Integer.MAX_VALUE);
		System.out.println("Тип long принимает значения от " +
				Long.MIN_VALUE + " до " + Long.MAX_VALUE);
		System.out.println("Тип char принимает значения от " +
				(int)Character.MIN_VALUE + " до " + (int)Character.MAX_VALUE);
		System.out.println("Тип float принимает значения от " +
				Float.MIN_VALUE + " до " + Float.MAX_VALUE);
		System.out.println("Тип double принимает значения от " +
				Double.MIN_VALUE + " до " + Double.MAX_VALUE);
		System.out.println("Тип boolean принимает значения true или false");
		
		int a = 10, b = 5;
		int ab = a + b;
		System.out.println(ab);
	}

}
