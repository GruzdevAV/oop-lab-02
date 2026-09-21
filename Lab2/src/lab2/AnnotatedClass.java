package lab2;


public class AnnotatedClass {
//	@MyAnnotation(parameter=2)
	public void pub_method_1() {
		System.out.println("Public method 1");
	}
	@MyAnnotation(parameter=5)
	public void pub_method_2() {
		System.out.println("Public method 2");
	}
//	@MyAnnotation(parameter=2)
	public void pub_method_3() {
		System.out.println("Public method 3");
	}
	@MyAnnotation(parameter=2)
	protected void pro_method_1() {
		System.out.println("Protected method 1");
	}
//	@MyAnnotation(parameter=2)
	protected void pro_method_2() {
		System.out.println("Protected method 2");
	}
//	@MyAnnotation(parameter=2)
	protected void pro_method_3() {
		System.out.println("Protected method 3");
	}
	@MyAnnotation(parameter=0)
	private void pri_method_1() {
		System.out.println("Private method 1");
	}
//	@MyAnnotation(parameter=2)
	private void pri_method_2() {
		System.out.println("Private method 2");
	}
	@MyAnnotation(parameter=7)
	private void pri_method_3() {
		System.out.println("Private method 3");
	}
}
