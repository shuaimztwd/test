package test.dynaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
	String say(String name, int age);
}

class RealSubject implements Subject {

	@Override
	public String say(String name, int age) {
		return "name = " + name + "，age = " + age;
	}

}

class ProxySubject implements Subject {
	private Subject sub;

	public ProxySubject(Subject sub) {
		this.sub = sub;
	}

	@Override
	public String say(String name, int age) {
		return sub.say(name, age);
	}

}

class MyInvocationHandler implements InvocationHandler {

	private Object obj;

	public Object bind(Object obj) {
		this.obj = obj;
		Class<?> c = this.obj.getClass();
		return Proxy.newProxyInstance(c.getClassLoader(), c.getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = method.invoke(this.obj, args);
		return result;
	}

}

public class DynaProxyTest {

	public static void main(String[] args) {
		Subject sub = new RealSubject();
		System.out.println(new ProxySubject(sub).say("张三", 30));
		System.out.println(((Subject) new MyInvocationHandler()
				.bind(new RealSubject())).say("李四", 31));
	}
}
