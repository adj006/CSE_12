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
public class Factor extends ASTNode
{
	/**
	* private Factor constructor that takes in a ASTNode child as an argument
	*
	* @param n
	**/
	private Factor(ASTNode n)
	{
		super(n);
	}
	/**
	* This is the static parse method that takes in a string and checks if the
	* syntax is valid. If valid it returns an instance of the constructor, if
	* not it returns null
	*
	* @param s
	* @return Factor
	**/
	public static Factor parse(java.lang.String s)
	{
		if(s == null)
			return null;
		s = s.trim();
		if(s.length() == 0)
			return null;
		ASTNode cons = Const.parse(s);
		ASTNode ident = Ident.parse(s);
		if(cons != null) 
			return new Factor(cons);
		else if(ident != null)
			return new Factor(ident);
		else if((s.indexOf("(") == -1) || (s.indexOf(")") == -1))
			return null;
		else if((s.indexOf("(") == 0) && (s.lastIndexOf(")") == s.length() - 1))
		{
			s = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
			s = s.trim();
			ASTNode expr = Expr.parse(s);
			if(expr != null)
				return new Factor(expr);
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
		return getChild(0).eval(symtab);
	}
}
