package Caluate3;

import java.util.Scanner;
import java.util.Stack;



public class Calculator  {

static Stack st = new Stack(); //������ ������ ����
static Stack stResult = new Stack(); //�������� ����� ����

// Infix�� Postfix�� ��ȯ�ϴ� �޼���
public String convert(String expression) {

String postfix = ""; //�������� ���������� ��ȯ�Ͽ� ������ ����

for (int i = 0; i < expression.length(); i++) {

char ch = expression.charAt(i); //�Է¹��� ���� �� ���ھ� �����

if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/')) { //'+, -, *, /' �� ��쿡��

do {
if (st.isEmpty()) { //������ ������ ��� ������

st.push(ch); //�����ڸ� ���ÿ� ���� �͵� ���� ����ִ´�.

break; //�ݺ��� �ߴ�

} else { //������ ������ ��� ���� ���� ���

char stfix = (char) st.peek(); //stfix�� ���� �ֻ����� �ִ� �����ڸ� ������

//�켱������ ���Ѵ�.
if (priority(ch) <= priority(stfix)) { //�Է¹��� �����ڰ� ���� �ֻ����� ����� �����ں��� �켱������ ���ų� ������
postfix += st.pop(); //postfix�� ����ϰ�
} else if (priority(ch) > priority(stfix)) { //�켱������ ���� ��쿡��
st.push(ch); //������ ���� �ֻ����� �����ϰ�
break; //�ݺ����� �������� ���� �Է¹��� ���� �Ǵ��Ѵ�.
}
}
} while (true);

} else if (ch == '(') { //���� ��ȣ�� �ԷµǸ�
st.push(ch); //������ ���ÿ� �����ϰ�
} else if (ch == ')') { //������ ��ȣ�� �ԷµǸ�

while (((Character) st.peek()).charValue() != '(') { //while���� ���� ���� ��ȣ�� ������ ������ �����ڸ� postfix�� ����Ѵ�.
postfix += st.pop();
}
st.pop(); //�����ڸ� �� ����ϰ� �������� �ִ� ')' ��ȣ�� �����Ѵ�.

} else {
postfix += ch; //������, ��ȣ �̿��� �Է��� postfix�� ���� �����Ѵ�.
}
}

//�Է¹��� ���� ��� �񱳸� ������ ���ÿ� �����ִ� ���θ� postfix�� ���� �����Ѵ�.
while (!st.isEmpty()) {
postfix += st.pop();
}

return postfix;
}

// ������ �켱���� �޼���
static int priority(Character ch) {

int prior = 0; //������ �켱 ���� ����

if ((ch == '+') || (ch == '-')) {
prior = 1;
} else if ((ch == '*') || (ch == '/')) {
prior = 2;
}

return prior;
}

// ���� �Է� �޼���
public String expression() {
Scanner s = new Scanner(System.in);
System.out.println("���ϴ� ����� �Է��ϼ���");
String expression = s.nextLine().trim();
s.close();
return expression;
}

//�������� ����Ͽ� ����� ����ϴ� �޼���
public Double result(String str) {

Double result = 0.0d;

for (int i = 0; i < str.length(); i++) {

char ch = str.charAt(i);
double pre=0.0d; //�������� ���� ������ �� �� ���� ����
double post=0.0d; //�������� ���� ������ �� �Ʒ����� ����

//�����ڰ� �ƴ� ��쿡�� �Ǽ� ���·� ���ÿ� �����Ѵ�.
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


