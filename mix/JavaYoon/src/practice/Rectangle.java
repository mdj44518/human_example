package practice;

import java.lang.reflect.Method;
import java.util.Arrays;

//import static java.lang.Math.*;

class Rectangle {
	
	int x,y,width,height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	int square() {
		return width * height;
	}
	
	void show() {
		System.out.println("("+x+","+y+")에서 크기가 "+width+"x"+height+"인 사각형");
	}
	
//	boolean contains(Rectangle rect) {
//		int[] mainSquare = {x+width, y+height};
//		int[] subSquare = {rect.x + rect.width, rect.y + rect.height};
//		if (mainSquare[0] > subSquare[0] && mainSquare[1] > subSquare[1]) return true;
//		return false;
//	}
	
//	boolean contains(Rectangle r) {
		//4가지 경우
//		double mLeft = x - (width / 2d);
//		double mRight = x + (width / 2d);
//		double mBottom = y - (height / 2d);
//		double mTop = y + (height / 2d);;
//		
//		double sLeft = rect.x - (rect.width / 2d);
//		double sRight = rect.x + (rect.width / 2d);
//		double sBottom = rect.y - (rect.height / 2d);
//		double sTop = rect.y + (rect.height / 2d);
//		
//		if (mLeft <= sLeft && mRight >= sRight && mBottom <= sBottom && mTop >= sTop) return true;
//		return false;
		
		//그럼 컴퍼레이터로는? 가장 많은 도형을 포함한녀석은?
		
//		int thisWidth = this.width - abs(this.x - r.x) *2; //좌표 차이 적용?
//		int thisHeight = this.height - abs(this.y - r.y) *2;
//		if (r.width <= thisWidth && r.height <= thisHeight) return true;
//		return false;
		
//	}
	
}
