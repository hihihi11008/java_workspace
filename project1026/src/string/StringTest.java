package string;
class StringTest{
	public static void main(String[] args){
		/*
		String은 클래스다!! 
		하지만 우리 인간은 스트링을 너무 압도적으로 많이 사용하기 때문에 
		new연산자에 의해 스트링을 생성하는 것은 너무 불편하다 
		따라서 String 한해서는 마치 일반 데이터타입처럼 new 쓰지 않는 표현식을 지원해준다 
		이러한 String 생성방법을 암시적,묵시적(implicit) 생성법
		묵시적 생성법에 의한 String은 상수풀에 의해 관리되어 지는데 
		*/
		String s1="apple";
		String s2="apple";
		System.out.println(s1==s2);

		//String 은 시작문자인 'S'가 대문자로보아 분명 객체형이다 
		//우리의 개발환경에서 String.class가 어딘가에있..을깎?
		//java se의 모든 api가 모여잇는 압축된 파일 
		//c:\Program Files\Java\jdk1.8.0_261\jre\lib\re.jar

		String s3 = new String("korea");
		String s4 = new String("korea");
		System.out.println(s3==s4);

		//주소비교가 아닌, 객체 동일성비교하는법 
		String k1="orange";
		String k2="orange";
		System.out.println(k1==k2);//주소
		System.out.println(k1.equals(k2));//내용비교 
	}

}

