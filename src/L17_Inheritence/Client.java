package L17_Inheritence;

public class Client {

	public static void main(String[] args) {

		// case 1: Both reference(LHS,obj1) and instance(RHS) are of type P
		P obj1 = new P();
		System.out.println(obj1.d);
		System.out.println(obj1.d1);
//		System.out.println(obj1.d2); WRONG,error bcoz d2 is not in P
		obj1.fun();
		obj1.fun1();
//		obj1.fun2(); WRONG,error

		// case 2:
		P obj2 = new C(); // while writing the obj2 will be a reference of P
							// While running the jvm will take obj2 as a type of C
		System.out.println(obj2.d); // P ka d....d is a variable in P and obj is a reference of P while writing
		System.out.println(((C) obj2).d); // C ka d
		System.out.println(obj2.d1);
//		System.out.println(obj2.d2); error bcoz, d2 is not present in P
		System.out.println(((C) obj2).d2);

		obj2.fun();// C fun....overiding
		((P) obj2).fun();// problem not resolved,C fun
		obj2.fun1();// P fun1
		((C) obj2).fun2();// C fun2
		((C) obj2).fun();// C fun

		// case 3
//		C obj3 = new P(); // This statement is NOT allowed
//		System.out.println(obj3.d);
//		System.out.println(obj3.d1);
//		System.out.println(obj3.d2); d2 is visible to obj3, but we are oint new P() but blueprint of p doesn't contains d2

		// case 4
		C obj4 = new C();
		System.out.println(obj4.d);		//	C ka d
		System.out.println(((P)obj4).d);//	P ka d
		System.out.println(obj4.d1);
		System.out.println(obj4.d2);
		obj4.fun();						//overiding
		obj4.fun1();
		obj4.fun2();

	}

}
