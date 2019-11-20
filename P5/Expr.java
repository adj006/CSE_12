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
public class Expr extends ASTNode
{
	/**
	* Private Expr constructor that takes in a ASTNode child as an argument
	*
	* @param n
	**/
	private Expr(ASTNode n)
	{
		super(n);
	}
	/**
	* This is the static parse method that takes in a string and checks if the
	* syntax is valid. If valid it returns an instance of the constructor, if
	* not it returns null
	*
	* @param s
	* @return Expr
	**/
	public static Expr parse(java.lang.String s)
	{
		if(s == null)
			return null;
		s = s.trim();
		ASTNode oprn = Oprn.parse(s);
		ASTNode assmt = Assmt.parse(s);
		if(s.length() == 0)
			return null;
		else if(oprn != null)
			return new Expr(oprn);
		else if(assmt != null)
			return new Expr(assmt);
		else
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
