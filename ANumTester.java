public class ANumTester extends junit.framework.TestCase {
	
	public ANumTester(String name){
		super(name);}
	public static void main(String args[]){
		junit.swingui.TestRunner.main(new String[] {"ANumTester"});
	}
	public void testCtor(){
		OneNum obj = new ANum();// create test fixture
		int val = obj.getNum();	// check state
		assertEquals(0, val);	// fail if not correct
	}
	public void testSetNum(){
		OneNum obj = new ANum();
		int val1 = 10;
		obj.setNum(val1);
		int val2 = obj.getNum();
		assertEquals(val1, val2);
	}
	public void testGetNum(){
		OneNum obj = new ANum();
		int val1 = 10;
		obj.setNum(val1);
		int val2 = obj.getNum();
		assertEquals(val1, val2);	
	}
	public void testSetNumException(){
		OneNum x = new ANum();
		try{
			x.setNum(-1);	//should throw
			fail();		//if not, fail the test
		} catch (IllegalArgumentException e) {}
			//if throws, catch the exception and pass the test
	}
}
