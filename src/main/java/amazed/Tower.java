package amazed;

import java.util.Stack;

public class Tower {
	private Stack<Integer> disks;
	private int index;
	
	public Tower(int i){
		disks = new Stack<Integer>();
		index = i;
	}

	public static void main(String[] args) {
	}
	
	public int index(){
		return index;
	}

}
