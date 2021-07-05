package Caluate2;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	private boolean isOperator(char c) {
		if(c=='+' || c=='-' || c=='*' || c=='/') {
			return true;
	}
	return false;
	}
	
	public Integer getResult(String postfix) {
		int a =0;
		int b =0;
		int operatorCount =0;
		int operandCount = 0;
		
		if(postfix.equals("")) {
			System.out.println("식에 아무 내용도 없습니다.");
			return null;
		}
		
		Scanner scan = new Scanner(postfix);
		
		Stack<Integer> result = new Stack<>();
		
		while(scan.hasNext()) {
			if(scan.hasNextInt()) {
				result.push(scan.nextInt());
				operandCount++;
				continue;
			}
			char operator = scan.next().charAt(0);
			
			if(!isOperator(operator)) {
				return null;
			}
			else {
				try {
					b=result.pop();
					a= result.pop();
				}
				catch(EmptyStackException e) {
					System.out.println("피연산자의 개수가 부족합니다.");
					return null;
				}
				
				if(operator == '+') {
					result.push(a+b);
				}
				else if(operator =='-') {
					result.push(a-b);
				}
				else if(operator =='*') {
					result.push(a*b);
				}else if(operator =='/') {
					result.push(a/b);
				}
				operatorCount++;
			}
		}
		scan.close();
		if(operatorCount!=operandCount+1) {
			System.out.println("연산자의 개수가 부족합니다.");
			return null;
		}
		return result.pop();
			
			
			
		}
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		Scanner sc =new Scanner(System.in);
		System.out.println("후위 표기식 입력 : ");
		String postfix = sc.nextLine();
		System.out.println(cal.getResult(postfix));
	}
	

}
