import java.lang.reflect.Method;
import java.util.Arrays;

class LuxuryHelloJava {
	public static void main(String[] args) {
		generic(new moon());
	}
	//a.getClass().getComponentType()
	private static <T> void generic(T t) {
		Method[] m = t.getClass().getMethods();
		System.out.println("메소드이름:" + m[0].getName());
		try {
			System.out.println(t.getClass().getDeclaredMethod(m[0].getName(), int.class, HelloJava.class)); //메서드 정보
			System.out.println(Arrays.toString(m[0].getParameters()));//해당 메서드가 요구하는 param
			System.out.println(m[0].getParameterTypes()[1].newInstance()); //그냥 두번째 param 객체생성 해보기
			m[0].invoke(t.getClass().newInstance(), 0,new HelloJava());// 메서드 실행.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
interface MoonInter {
	public void result(int i, HelloJava j);
}
class moon implements MoonInter {
	@Override
	public void result(int i, HelloJava j) {
		System.out.println("성공을 축하합니다.");
	}
}
class HelloJava {}
