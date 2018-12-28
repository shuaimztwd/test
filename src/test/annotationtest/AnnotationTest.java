package test.annotationtest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 测试
 * 
 * @author wymd_ws
 */
@CustomAn1(key = "test", values = { "A", "B", "C" })
class Test {

}

public class AnnotationTest {
	public static void main(String[] args) {
		Test t = new Test();
		Annotation[] a = t.getClass().getAnnotations();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].annotationType().getName());
			Method[] m = a[i].annotationType().getMethods();
			for (int j = 0; j < m.length; j++) {
				System.out.print(Modifier.toString(m[j].getModifiers()) + " ");
				System.out.print(m[j].getReturnType().getTypeName() + " ");
				System.out.print(m[j].getName() + "() ");
				System.out.println(m[j].getDefaultValue());
			}
			System.out.println(a[i].getClass().getSuperclass().getName());
		}

		CustomAn1 an1 = t.getClass().getAnnotation(CustomAn1.class);
		System.out.println(an1.key());
		System.out.println(Arrays.toString(an1.values()));
	}
}
