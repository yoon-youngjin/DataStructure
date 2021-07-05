package Caluate3;

import java.util.Scanner;
import java.util.Stack;



public class Calculator  {

static Stack st = new Stack(); //연산자 저장할 스택
static Stack stResult = new Stack(); //후위식을 계산할 스택

// Infix를 Postfix로 변환하는 메서드
public String convert(String expression) {

String postfix = ""; //전위식을 후위식으로 변환하여 저장할 변수

for (int i = 0; i < expression.length(); i++) {

char ch = expression.charAt(i); //입력받은 식을 한 글자씩 나누어서

if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/')) { //'+, -, *, /' 일 경우에는

do {
if (st.isEmpty()) { //연산자 스택이 비어 있으면

st.push(ch); //연산자를 스택에 비교할 것도 없이 집어넣는다.

break; //반복문 중단

} else { //연산자 스택이 비어 있지 않을 경우

char stfix = (char) st.peek(); //stfix에 스택 최상위에 있는 연산자를 꺼내서

//우선순위를 비교한다.
if (priority(ch) <= priority(stfix)) { //입력받은 연산자가 스택 최상위에 저장된 연산자보다 우선순위가 낮거나 같으면
postfix += st.pop(); //postfix에 출력하고
} else if (priority(ch) > priority(stfix)) { //우선순위가 높을 경우에는
st.push(ch); //연산자 스택 최상위에 저장하고
break; //반복문을 빠져나가 다음 입력받은 식을 판단한다.
}
}
} while (true);

} else if (ch == '(') { //왼쪽 괄호가 입력되면
st.push(ch); //연산자 스택에 저장하고
} else if (ch == ')') { //오른쪽 괄호가 입력되면

while (((Character) st.peek()).charValue() != '(') { //while문을 통해 왼쪽 괄호가 나오기 전까지 연산자를 postfix로 출력한다.
postfix += st.pop();
}
st.pop(); //연산자를 다 출력하고 마지막에 있는 ')' 괄호를 제거한다.

} else {
postfix += ch; //연산자, 괄호 이외의 입력은 postfix에 누적 저장한다.
}
}

//입력받은 식의 모든 비교를 끝내고 스택에 남아있는 전부를 postfix로 누적 저장한다.
while (!st.isEmpty()) {
postfix += st.pop();
}

return postfix;
}

// 연산자 우선순위 메서드
static int priority(Character ch) {

int prior = 0; //연산자 우선 순위 변수

if ((ch == '+') || (ch == '-')) {
prior = 1;
} else if ((ch == '*') || (ch == '/')) {
prior = 2;
}

return prior;
}

// 수식 입력 메서드
public String expression() {
Scanner s = new Scanner(System.in);
System.out.println("원하는 계산을 입력하세요");
String expression = s.nextLine().trim();
s.close();
return expression;
}

//후위식을 계산하여 결과를 출력하는 메서드
public Double result(String str) {

Double result = 0.0d;

for (int i = 0; i < str.length(); i++) {

char ch = str.charAt(i);
double pre=0.0d; //계산순서를 위해 스택의 맨 위 값을 저장
double post=0.0d; //계산순서를 위해 스택의 맨 아래값을 저장

//연산자가 아닐 경우에는 실수 형태로 스택에 저장한다.
if ((ch != '+') && (ch != '-') && (ch != '*') && (ch != '/')) {

String s = String.valueOf(ch);
stResult.push(new Double(s));

} else if ((ch == '+')) {
post=(Double) stResult.pop();
pre=(Double) stResult.pop();
stResult.push(pre+post);
} else if ((ch == '-')) {
post=(Double) stResult.pop();
pre=(Double) stResult.pop();
stResult.push(pre-post);
} else if ((ch == '*')) {
post=(Double) stResult.pop();
pre=(Double) stResult.pop();
stResult.push(pre*post);
} else if ((ch == '/')) {
post=(Double) stResult.pop();
pre=(Double) stResult.pop();
stResult.push(pre/post);
}

}

return result = (Double) stResult.peek();
}
}


