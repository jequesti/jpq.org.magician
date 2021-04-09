package jpq.org.magician;

import java.util.Arrays;
/**
 * 
 * @author jean questiaux
 * see https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
 */

public class MClass {
	public MClass(String name, String accessModifier, String parentClass, String[] implemented, String[] constructors,
			String[] privateVar, String[] publicVar, String[] privateMethods, String[] publicMethods) {
		super();
		this.name = name;
		this.accessModifier = accessModifier;
		this.implemented = implemented;
		this.parentClass = parentClass;
		this.constructors = constructors;
		this.privateVar = privateVar;
		this.publicVar = publicVar;
		this.privateMethods = privateMethods;
		this.publicMethods = publicMethods;
	}

	/**
	 * MClass constructor using MClassBuilder
	 *
	 * @param mBuilder
	 *            : a MClassBuilder with everything we want
	 */
	public MClass(MClassBuilder mBuilder) {
		this.name = mBuilder.name;
		this.accessModifier = mBuilder.accessModifier;
		this.implemented = mBuilder.implemented;
		this.parentClass = mBuilder.parentClass;
		this.constructors = mBuilder.constructors;
		this.privateVar = mBuilder.privateVar;
		this.publicVar = mBuilder.publicVar;
		this.privateMethods = mBuilder.privateMethods;
		this.publicMethods = mBuilder.publicMethods;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccessModifier() {
		return accessModifier;
	}
	/**
	 * 
	 * @param accessModifier
	 * can be public, private then package for java, protected internal for C#, ...
	 * see https://en.wikipedia.org/wiki/Access_modifiers
	 * https://docs.oracle.com/javase/tutorial/reflect/class/classModifiers.html
	 */
	public void setAccessModifier(String accessModifier) {
		this.accessModifier = accessModifier;
	}

	public String[] getInterfaces() {
		return implemented;
	}

	public void setInterfaces(String[] implemented) {
		this.implemented = implemented;
	}

	public String getParentClass() {
		return parentClass;
	}

	public void setParentClass(String parentClass) {
		this.parentClass = parentClass;
	}

	public String[] getConstructors() {
		return constructors;
	}

	public void setConstructors(String[] constructors) {
		this.constructors = constructors;
	}

	public String[] getPrivateVar() {
		return privateVar;
	}

	public void setPrivateVar(String[] privateVar) {
		this.privateVar = privateVar;
	}

	public String[] getPublicVar() {
		return publicVar;
	}

	public void setPublicVar(String[] publicVar) {
		this.publicVar = publicVar;
	}

	public String[] getPrivateMethods() {
		return privateMethods;
	}

	public void setPrivateMethods(String[] privateMethods) {
		this.privateMethods = privateMethods;
	}

	public String[] getPublicMethods() {
		return publicMethods;
	}

	public void setPublicMethods(String[] publicMethods) {
		this.publicMethods = publicMethods;
	}

	private String name;
	private String accessModifier;
	private String[] implemented = null;
	private String parentClass = null;
	private String[] constructors;
	private String[] privateVar;
	private String[] publicVar;
	private String[] privateMethods;
	private String[] publicMethods;

	public String toJava() {
		StringBuilder builder = new StringBuilder();
		builder.append(accessModifier).append(" ");

		builder.append("class ");
		builder.append(name);
		if (parentClass != null && !parentClass.isEmpty()) {
			builder.append(" extends ");
			builder.append(parentClass);
		}
		if (implemented != null && implemented.length > 0) {

			int i = 0;
			builder.append(" implements ");
			for (String implementedInterface : implemented) {
				if (i != 0) {
					builder.append(", ");
				}
				builder.append(implementedInterface);
				i++;
			}
		}
		// start of class body
		builder.append("\r\n{\r\n");
		// end of class body
		builder.append("}\r\n");
		if (false) {
			builder.append(", constructors=");
			builder.append(Arrays.toString(constructors));
			builder.append(", privateVar=");
			builder.append(Arrays.toString(privateVar));
			builder.append(", publicVar=");
			builder.append(Arrays.toString(publicVar));
			builder.append(", privateMethods=");
			builder.append(Arrays.toString(privateMethods));
			builder.append(", publicMethods=");
			builder.append(Arrays.toString(publicMethods));
			builder.append("]");
		}
		return builder.toString();
	}

	public String toCsharp() {
		StringBuilder builder = new StringBuilder();
		builder.append(accessModifier).append(" ");

		builder.append("class ");
		builder.append(name);

		// C# exige que la classe parent, lorsqu'elle est indiquée, précède les
		// interfaces
		if (parentClass != null && !parentClass.isEmpty()) {
			builder.append(" : "); // extends
			builder.append(parentClass);
		}
		if (implemented != null && implemented.length > 0) {

			int i = 0;
			if (parentClass != null && !parentClass.isEmpty()) {
				builder.append(", ");
			} else {
				builder.append(" : "); // implements
			}
			for (String implementedInterface : implemented) {
				if (i != 0) {
					builder.append(", ");
				}
				// By convention, interface names begin with a capital I.
				if (implementedInterface.charAt(0) != 'I') {
					// System.err.println("By convention, interface names begin
					// with a I.");
				}
				builder.append(implementedInterface);
				i++;
			}
		}
		// start of class body
		builder.append("\r\n{\r\n");
		// end of class body
		builder.append("}\r\n");
		return builder.toString();
	}
	///////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////

	// Builder Class
	public static class MClassBuilder {

		public MClassBuilder setName(String name) {
			this.name = name;
			return this;
		}
		/**
		 * 
		 * @param accessModifier
		 * can be public, private then package for java, protected internal for C#, ...
		 * see https://en.wikipedia.org/wiki/Access_modifiers
		 */

		public MClassBuilder setAccessModifier(String accessModifier) {
			this.accessModifier = accessModifier;
			return this;
		}

		public MClassBuilder setInterfaces(String[] implemented) {
			this.implemented = implemented;
			return this;
		}

		public MClassBuilder setParentClass(String parentClass) {
			this.parentClass = parentClass;
			return this;
		}

		public MClassBuilder setConstructors(String[] constructors) {
			this.constructors = constructors;
			return this;
		}

		public MClassBuilder setPrivateVar(String[] privateVar) {
			this.privateVar = privateVar;
			return this;
		}

		public MClassBuilder setPublicVar(String[] publicVar) {
			this.publicVar = publicVar;
			return this;
		}

		public MClassBuilder setPrivateMethods(String[] privateMethods) {
			this.privateMethods = privateMethods;
			return this;
		}

		public MClassBuilder setPublicMethods(String[] publicMethods) {
			this.publicMethods = publicMethods;
			return this;
		}

		// required parameters
		private String name;

		// optional parameters
		private String accessModifier;
		private String[] implemented = null;
		private String parentClass = null;
		private String[] constructors;
		private String[] privateVar;
		private String[] publicVar;
		private String[] privateMethods;
		private String[] publicMethods;

		public MClassBuilder(String name) {
			this.name = name;
			this.parentClass = null;
			this.accessModifier = "public"; // by default
			// no return this
		}

		// return the finally MClass built by the call the MClass constructor
		// using MClassBuilder
		public MClass build() {
			return new MClass(this);
		}

	}
}