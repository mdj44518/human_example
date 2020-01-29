package junit_tutorial;

public class MyDemo {
	private String msg;
	
	public MyDemo(String msg) {
		this.msg = msg;
	}
	
	public String reverse() {
		StringBuffer sb = new StringBuffer();
		for (int i = msg.length() - 1; i >= 0; i--) {
			sb.append(msg.charAt(i));
		}
		
		return sb.toString();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MyDemo [msg=" + msg + "]";
	}
}
