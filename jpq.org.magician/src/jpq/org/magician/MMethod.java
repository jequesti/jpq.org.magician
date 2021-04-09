package jpq.org.magician;

import java.util.Arrays;

/**
 * 
 * @author jean questiaux
 * see https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
 * see https://docs.microsoft.com/en-us/dotnet/csharp/methods
 */
public class MMethod {

	public MMethod(String accessModifier, String[] optionalModifiers, boolean isStatic, String returned, String name, String[] parameter,
			String[] exceptionList, String body) {
		super();
		this.accessModifier = accessModifier;
		this.optionalModifiers = optionalModifiers;
		this.isStatic = isStatic;
		this.returned = returned;
		this.name = name;
		this.parameterList = parameter;
		this.exceptionList = exceptionList;
		this.body = body;
	}
	
	
	/**
	 * MMethod constructor using MMethodBuilder
	 *
	 * @param mBuilder
	 *            : a MMethodBuilder with everything we want
	 */
	public MMethod(MMethodBuilder mBuilder) {
		this.name = mBuilder.name;
		this.accessModifier = mBuilder.accessModifier;
		this.optionalModifiers = mBuilder.optionalModifiers;
		this.isStatic = mBuilder.isStatic;
		this.isAbstract = mBuilder.isAbstract;
		this.isFinal  = mBuilder.isFinal;
		this.returned = mBuilder.returned;
		this.name = mBuilder.name;
		this.parameterList = mBuilder.parameterList;
		this.exceptionList = mBuilder.exceptionList;
		this.body = mBuilder.body;
	}
	
	
	
	
	public String getAccessModifier() {
		return accessModifier;
	}
	public void setAccessModifier(String accessModifier) {
		this.accessModifier = accessModifier;
	}
	public String[] getOptionalModifiers() {
		return optionalModifiers;
	}


	public void setOptionalModifiers(String[] optionalModifiers) {
		this.optionalModifiers = optionalModifiers;
	}
	public boolean isStatic() {
		return isStatic;
	}
	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}
	public String getReturned() {
		return returned;
	}
	public void setReturned(String returned) {
		this.returned = returned;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getParameter() {
		return parameterList;
	}
	public void setParameter(String[] parameter) {
		this.parameterList = parameter;
	}
	public String[] getException() {
		return exceptionList;
	}
	public void setException(String[] exceptionList) {
		this.exceptionList = exceptionList;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		if (isAbstract)
		{
			System.err.println("No body for abstract method");
			this.body = "();";
		}
		else this.body = body;
	}
	
	public String toJava() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n// Java code");
		builder.append("\r\n");
		builder.append(accessModifier).append(" ");
		
		if (isStatic)
			builder.append("static ");
		if (isFinal)
			builder.append("final ");
		if (isAbstract)
			builder.append("abstract ");
		builder.append(this.returned).append(" ");
		builder.append(name).append("(");
		if (parameterList != null && parameterList.length > 0) {

			int i = 0;
			for (String currentParameter : parameterList) {
				if (i != 0) {
					builder.append(", ");
				}
				builder.append(currentParameter);
				i++;
			}
		}
		builder.append(")");
//		if (isAbstract)
//			builder.append( "()" );
		if (exceptionList != null && exceptionList.length > 0) {

			int i = 0;
			builder.append(" throws ");
			for (String currentException : exceptionList) {
				if (i != 0) {
					builder.append(", ");
				}
				builder.append(currentException);
				i++;
			}
		}
		if (isAbstract)
			builder.append(";\r\n"); 
		else
			builder.append("\r\n{\r\n").append(body).append("\r\n}\r\n");


		
		return builder.toString();
	}

	public String toCsharp() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n// C# code");
		builder.append("\r\n");
		builder.append(accessModifier).append(" ");
		
		if (isStatic)
			builder.append("static ");
		if (isFinal)
			builder.append("sealed override ");
		if (isAbstract)
			builder.append("abstract ");
		builder.append(this.returned).append(" ");
		builder.append(name).append("(");
		if (parameterList != null && parameterList.length > 0) {

			int i = 0;
			for (String currentParameter : parameterList) {
				if (i != 0) {
					builder.append(", ");
				}
				builder.append(currentParameter);
				i++;
			}
		}
		builder.append(")");
//		if (isAbstract)
//			builder.append( "()" );
		
//		if (exceptionList != null && exceptionList.length > 0) {
//
//			int i = 0;
//			
//			builder.append("\r\n// throws ");
//			for (String currentException : exceptionList) {
//				if (i != 0) {
//					builder.append(", ");
//				}
//				builder.append(currentException);
//				i++;
//			}
//			builder.append("\r\n");
//		} 
		if (isAbstract)
			builder.append(";\r\n"); 
		else
			builder.append("\r\n{\r\n").append(body).append("\r\n}\r\n");
		
		
		return builder.toString();
	}
	
	
	
	private String accessModifier; 
	private String[] optionalModifiers;



	private boolean isAbstract;

	private boolean isStatic;
	private boolean isFinal;
	
	public void setAbstract(boolean isAbstract) {
		if (this.accessModifier.equalsIgnoreCase("private"))
		{
			System.err.println("An abstract method can never be private");
		}
		else if (this.isStatic)
		{
			System.err.println("An abstract method can never be static ");
		} else this.isAbstract = isAbstract;
	}


	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}




	private String returned;
	private String name;	
	private String[] parameterList = null;
	private String[] exceptionList = null;
	private String  body;
	
	
	///////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	
	public static class MMethodBuilder {
		private String accessModifier; 
		private String[] optionalModifiers;

		private boolean isStatic;
		private boolean isFinal;
		private boolean isAbstract;
		
		private String returned;
		private String name;	
		private String[] parameterList = null;
		private String[] exceptionList = null;
		private String  body;

		public MMethodBuilder setName(String name) {
			this.name = name;
			return this;
		}
		/**
		 * 
		 * @param accessModifier
		 * can be public, private then package for java, protected internal for C#, ...
		 * see https://en.wikipedia.org/wiki/Access_modifiers
		 */

		public MMethodBuilder setAccessModifier(String accessModifier) {
			this.accessModifier = accessModifier;
			return this;
		}
		/**
		 * Optional modifiers language specific such as sealed, virtual, async, 
		 * @param modifiers
		 * @return
		 */
		public MMethodBuilder setOptionalModifiers(String[] modifiers) {
			this.optionalModifiers = modifiers;
			return this;
		}
		
/**
 * Prevent overriding of a virtual method. (sealed override C#)
 * @param isFinal
 * using both abstract and final modifier with a class is illegal
 * @return
 */
		public MMethodBuilder setFinal(boolean isFinal) {
			this.isFinal = isFinal;
			return this;
		}
		/**
		 * 
		 * @param isAbstract
		 * using both abstract and final modifier with a class is illegal
		 * @return
		 */
		public MMethodBuilder setAbstract(boolean isAbstract) {
			if (this.accessModifier.equalsIgnoreCase("private"))
			{
				System.err.println("An abstract method can never be private");
			}
			else if (this.isStatic)
			{
				System.err.println("An abstract method can never be static ");
			} else this.isAbstract = isAbstract;

			return this;
		}

		public MMethodBuilder setStatic(boolean isStatic) {
			this.isStatic = isStatic;
			return this;
		}
		public MMethodBuilder setReturned(String returned) {
			this.returned = returned;
			return this;
		}
		public MMethodBuilder setParameter(String[] parameter) {
			this.parameterList = parameter;
			return this;
		}
		public MMethodBuilder setException(String[] exceptionList) {
			this.exceptionList = exceptionList;
			return this;
		}
		public MMethodBuilder setBody(String body) {
			if (isAbstract)
			{
				System.err.println("No body for abstract method");
				this.body = "();";
			}
			else this.body = body;
			return this;
		}
		/**
         * see https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
		 * see https://docs.microsoft.com/en-us/dotnet/csharp/methods
		 * @param name
		 */
		public MMethodBuilder(String name) {
			this.name = name;
			this.returned = "void";
			this.body = "";
			this.accessModifier = "public"; // by default
			// no return this
		}

		// return the finally MMethod built by the call the MMethod constructor
		// using MMethodBuilder
		public MMethod build() {
			if (this.isFinal && this.isAbstract)
				System.err.println("using bocth abstract and final modifier with a method is illegal");
			return new MMethod(this);
		}

	}
}
	
