package com.example.spring01.test;

import javax.inject.Inject;

// 의존관계 : MemberUse는 Member에 의존한다.
// 강한 결합관계
class Member{
	String userid;
	String passwd;
	String name;
	// public Member() {} 
	private Member() {} //외부에서 new로 인스턴스를 만들 수 없음
//	private static Member instance;
//	public static Member getInstance() {
//		if(instance==null) {
//			instance=new Member();
//		}
//		return instance;
//	}
}
public class MemberUse {
	// 느슨한 결합 관계
	// 의존관계 주입(Dependency Injection, DI)
	// 객체 생성, 소멸(라이프사이클 관리)
	// IoC(Inversion of Control, 제어의 역전) 
	//	- 객체에 대한 제어권이 개발자=>스프링으로 이동
	@Inject
	Member m;
	public MemberUse(Member m) {
		
	}
//	public MemberUse() {
//		Member m=new Member();
//		//Member m=Member.getInstance();
//	}
}
