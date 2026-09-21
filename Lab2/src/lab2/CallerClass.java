package lab2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.AccessFlag;

public class CallerClass {
	public static void main() {
		var ac = new AnnotatedClass();
		var cl = ac.getClass();
		
		var methods = cl.getDeclaredMethods();
		for (int i=0; i< methods.length; ++i) {
			var m = methods[i];
			var an = m.getAnnotation(MyAnnotation.class);
			if (an != null && 
					(
					m.accessFlags().contains(AccessFlag.PROTECTED) ||
					m.accessFlags().contains(AccessFlag.PRIVATE)
					)
				) {
				m.setAccessible(true);
				System.out.print("\n-----\nMethod: ");
				System.out.println(m);
				System.out.print("Annotation: ");
				System.out.println(an);
				
				System.out.println(String.format("\nCalling the method %d times:\n", an.parameter()));
				
				for (int j=0; j<an.parameter(); ++j) {
					try {
						m.invoke(ac);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
