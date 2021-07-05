import java.util.Stack;

public class Check_matching {
	public boolean checking(String in) {
		Stack<Character> checkStack = new Stack<>();
		char ch,open_ch;
		int n = in.length();
		for(int i=0;i<n;i++) {
			ch = in.charAt(i);
			switch(ch) {
			case '(' : case'[':case'{' :
				checkStack.push(ch);
				break;
			
			
				
			case')' : case']' : case'}' :
				if(checkStack.isEmpty()) {
					return false;
				}
				else {
					open_ch = checkStack.pop();
					if((open_ch=='('&&ch!=')') || (open_ch=='['&&ch!=']') || (open_ch=='{'&&ch!='}')) {
						return false;
					}
					break;
				}
			}
		}
			if(!checkStack.isEmpty()) return false;
			return true;
		}		
	public static void main(String[] args) {
		String test = "(3+2)*5-3]";
		Check_matching a = new Check_matching();
		System.out.println(a.checking(test));
	}
			
	}
