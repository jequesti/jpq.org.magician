package jpq.org.magician;

public abstract class Methodtester {

	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
MMethod test0 = new MMethod.MMethodBuilder("myMethod").build();
System.out.println(test0.toJava());
System.out.println("----------------------------------------------------------------------------");

System.out.println(test0.toCsharp());
System.out.println("----------------------------------------------------------------------------");

MMethod test1 = new MMethod.MMethodBuilder("myMethod")
.setStatic(true)
.setAccessModifier("private")
.setFinal(true)
//.setAbstract(true)
.setReturned("String")
.setOptionalModifiers(new String[] { "abstract"})
.setParameter(new String[] { "int param1", "String param2"})
.setException(new String[] { "IOException", "IndexOutOfBoundsException"})
.setBody("return param2;")
.build();
System.out.println(test1.toJava());
System.out.println("----------------------------------------------------------------------------");

System.out.println(test1.toCsharp());
System.out.println("----------------------------------------------------------------------------");
MMethod test2 = new MMethod.MMethodBuilder("myMethod")
.setStatic(true)
.setAbstract(true)
.setReturned("String")
.setOptionalModifiers(new String[] { "abstract"})
.setParameter(new String[] { "int param1", "String param2"})
.setException(new String[] { "IOException", "IndexOutOfBoundsException"})
.setBody("return param2;")
.build();
System.out.println(test2.toJava());
System.out.println("----------------------------------------------------------------------------");

System.out.println(test2.toCsharp());
System.out.println("----------------------------------------------------------------------------");


	}

}
