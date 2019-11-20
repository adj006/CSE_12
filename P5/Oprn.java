/**
* @author Adrian Jimenez login name: cs12scx PID: A10748304
* @version 5/30/13
*
* Assignment #: 5
**/

/**
* This assignment extends the ASTNode class in order to use
* the methods it contains
**/
public class Oprn extends ASTNode
{
	String opr;	// Stores the operator symbol
	/**
	* Private Oprn constructor that takes in a ASTNode child as an argument
	*
	* @param n
	**/
	private Oprn(ASTNode n)
	{
		super(n);
	}
	/**
	* private Oprn constructor that takes in 2 ASTNode children and a string
	* that store the operator symbol as an argument
	*
	* @param n
	* @param m
	* @param operator
	**/
	private Oprn(ASTNode n, ASTNode m, String operator)
	{
		super(n, m);
		opr = operator;
	}
	/**
	* This is the static parse method that takes in a string and checks if the
	* syntax is valid. If valid it returns an instance of the constructor, if
	* not it returns null
	*
	* @param s
	* @return Oprn
	**/
	public static Oprn parse(java.lang.String s)
	{
		if(s == null)
			return null;
		s = s.trim();
		if(s.length() == 0)
			return null;
		ASTNode term = Term.parse(s);
		if(term != null)
			return new Oprn(term);
		else if((s.indexOf("+") != -1) || (s.indexOf("-") != -1))
			for(int i = 0; i < s.length(); i++)
			{
				if((s.charAt(i) == '+') && (Oprn.parse(s.substring(0, i)) != null))
					if(Term.parse(s.substring(i + 1, s.length())) != null)
						return new Oprn(Oprn.parse(s.substring(0, i)), Term.parse
														(s.substring(i + 1, s.length())), "+");

				if((s.charAt(i) == '-') && (Oprn.parse(s.substring(0, i)) != null))
					if(Term.parse(s.substring(i + 1, s.length())) != null)
						return new Oprn(Oprn.parse(s.substring(0, i)), Term.parse
														(s.substring(i + 1, s.length())), "-");
			}
		return null;
	}
	/**
	* This is the eval() method that evaluates the node
	*
	* @param symtab
	* @return double
	**/
	public double eval(java.util.Map<java.lang.String, java.lang.Double> symtab)
	{
		if (opr == "+")
			return getChild(0).eval(symtab) + getChild(1).eval(symtab);
		else if(opr == "-")
			return getChild(0).eval(symtab) - getChild(1).eval(symtab);
		else
			return getChild(0).eval(symtab);
	}
}
