package step13;

public class GenericDemo4 {

	@SuppressWarnings("unchecked")
	public static <T extends Number> T add(T a, T b) {
		Class<T> c = (Class<T>) a.getClass();

		System.out.println(c.getSimpleName() + " type will be returned");
		
		if (a instanceof Double) {
			/*
			Double result = (Double)a + (Double)b;
			return (T)result;
			*/
			return (T)(new Double(a.doubleValue() + b.doubleValue()));
		} else if (a instanceof Float) {
			return (T)(new Float(a.floatValue() + b.floatValue()));
		} else if (a instanceof Long) {
			return (T)(new Long(a.longValue() + b.longValue()));
		} else if (a instanceof Integer) {
			return (T)(new Integer(a.intValue() + b.intValue()));
		} else if (a instanceof Short) {
			return (T)(new Short((short)(a.shortValue() + b.shortValue())));
		} else {
			throw new IllegalArgumentException("Type " + a.getClass() + " is not supported by this class");
		}
		
	}
	
	public static void main(String[] args) {
		double val = GenericDemo4.<Integer>add(1, 2);
		System.out.println(val);
	}
}
