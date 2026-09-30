package lab2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParameterFactory {

	public static Map<Class<?>, Object> defaults= Map.of(
		byte.class, (byte) 1,
		short.class, (short) 2,
		int.class, (int) 3,
		long.class, (long) 4,
		boolean.class, (boolean) true,
		float.class, (float) 0.5,
		double.class, (double) 3.14,
		char.class, '=',
		List.class, List.of(),
		String.class, "La la land"
	);
	public static Object[] make_parameters(Class<?>[] types) throws IllegalArgumentException {
		Object[] result = new Object[types.length];
		for (int i=0; i<types.length; ++i) {
			result[i] = make_parameter(types[i]);
		}
		return result;
	}
	public static Object make_parameter(Class<?> type) throws IllegalArgumentException {
		if (defaults.containsKey(type))
			return defaults.get(type);
		if (type.isArray())
			return Array.newInstance(type.getComponentType(), 0);
		if (type == Set.class || type == HashSet.class) 
			return new HashSet<>();
		if (type == ArrayList.class) 
			return new ArrayList<>();
		if (type == Map.class || type == HashMap.class) 
			return new HashMap<>();
		try {
			var constr = type.getDeclaredConstructor();
			constr.setAccessible(true);
			return constr.newInstance();
		}
		catch (Exception e) {
			throw new IllegalArgumentException(String.format("Impossible to create this type automatically: %s.", type.toString()));
		}
	}
}
