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
public class Assmt extends ASTNode
{
	/**
	* Private constructor that takes in 2 ASTNode children as an argument
	*
	* @param n
	* @param m
	**/
	private Assmt(Ident n, Expr m)
	{
		super(n, m);
	}
	/**
	* This is the static parse method that takes in a string and checks if the
	* syntax is valid. If valid it returns an instance of the constructor, if
	* not it returns null
	*
	* @param s
	* @return Assmt
	**/
	public static Assmt parse(java.lang.String s)
	{
		if(s == null)
			return null;
		s = s.trim();
		if(s.length() == 0)
			return null;
		if(s.indexOf("=") == -1) 
			return null;
		if(Ident.parse(s.substring(0, s.indexOf("="))) != null)
			if(Expr.parse(s.substring(s.indexOf("=") + 1, s.length())) != null)
				return new Assmt(Ident.parse(s.substring(0, s.indexOf("="))), 
					Expr.parse(s.substring(s.indexOf("=") + 1, s.length())));
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
		// Stores the double value to prevent it from being called twice
		double val = getChild(1).eval(symtab);
	  symtab.put(getChild(0).toString(), val);
		return val;
	}
}
