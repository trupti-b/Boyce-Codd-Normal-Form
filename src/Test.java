
import java.util.*;
import junit.framework.TestCase;

public class Test extends TestCase {

	/**
	 * Performs a basic test on a simple table.
	 * gives input (a,b,c), a->c
	 * and expects output (a,c),(a,c) or any reordering
	 **/
	public void testSimpleBCNF() {
		//construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));

		//create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		dep.addAttribute(new Attribute("c"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		//run client code
		Set<AttributeSet> bcnf = BCNF.BCNF(attrs, fds);

		//verify output
		assertEquals("Incorrect number of tables", 2, bcnf.size());

		for(AttributeSet as : bcnf) {
			assertEquals("Incorrect number of attributes", 2, as.size());
			assertTrue("Incorrect table", as.contains(new Attribute("a")));
		}
		for(AttributeSet as:bcnf)
		{
			System.out.println(as.toString());
		}
	
	} 
	
	
	//test2
	public void test2SimpleBCNF() {
		//construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("d"));
		attrs.addAttribute(new Attribute("e"));

		//create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		dep.addAttribute(new Attribute("e"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);
		
		AttributeSet ind1 = new AttributeSet();
		AttributeSet dep1 = new AttributeSet();
		ind1.addAttribute(new Attribute("b"));
		ind1.addAttribute(new Attribute("c"));
		dep1.addAttribute(new Attribute("a"));
		FunctionalDependency fd1 = new FunctionalDependency(ind1, dep1);
		fds.add(fd1);
		
		AttributeSet ind2 = new AttributeSet();
		AttributeSet dep2 = new AttributeSet();
		ind2.addAttribute(new Attribute("d"));
		ind2.addAttribute(new Attribute("e"));
		dep2.addAttribute(new Attribute("b"));
		FunctionalDependency fd2 = new FunctionalDependency(ind2, dep2);
		fds.add(fd2);

		//run client code
		Set<AttributeSet> bcnf = BCNF.BCNF(attrs, fds);

		//verify output
		
		for(AttributeSet as:bcnf)
		{
			System.out.println(as.toString());
		}
	
	} 
	
	public void test3SimpleBCNF() {
		//construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("d"));

		//create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		dep.addAttribute(new Attribute("b"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);

		
		AttributeSet ind1 = new AttributeSet();
		AttributeSet dep1 = new AttributeSet();
		ind1.addAttribute(new Attribute("a"));
		ind1.addAttribute(new Attribute("b"));
		dep1.addAttribute(new Attribute("c"));
		FunctionalDependency fd1 = new FunctionalDependency(ind1, dep1);
		fds.add(fd1);
		//run client code
		Set<AttributeSet> bcnf = BCNF.BCNF(attrs, fds);

		//verify output
		
		for(AttributeSet as:bcnf)
		{
			System.out.println(as.toString());
		}
	
	} 
	
	//test4
	public void test4SimpleBCNF() {
		//construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("d"));
		attrs.addAttribute(new Attribute("e"));

		//create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		dep.addAttribute(new Attribute("b"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);
		
		AttributeSet ind1 = new AttributeSet();
		AttributeSet dep1 = new AttributeSet();
		ind1.addAttribute(new Attribute("c"));
		dep1.addAttribute(new Attribute("d"));
		FunctionalDependency fd1 = new FunctionalDependency(ind1, dep1);
		fds.add(fd1);
		
		//run client code
		Set<AttributeSet> bcnf = BCNF.BCNF(attrs, fds);

		//verify output
		
		for(AttributeSet as:bcnf)
		{
			System.out.println(as.toString());
		}
	
	} 
	// test 5
	public void test5SimpleBCNF() {
		//construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("n"));
		attrs.addAttribute(new Attribute("f"));

		//create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("n"));
		dep.addAttribute(new Attribute("f"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);
		
		//run client code
		Set<AttributeSet> bcnf = BCNF.BCNF(attrs, fds);

		//verify output
		
		for(AttributeSet as:bcnf)
		{
			System.out.println(as.toString());
		}
	
	} 
	//test 6
	public void test6SimpleBCNF() {
		//construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("f"));
		
		//create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("a"));
		ind.addAttribute(new Attribute("b"));
		dep.addAttribute(new Attribute("f"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);
		
		AttributeSet ind1 = new AttributeSet();
		AttributeSet dep1 = new AttributeSet();
		ind1.addAttribute(new Attribute("b"));
		dep1.addAttribute(new Attribute("f"));
		FunctionalDependency fd1 = new FunctionalDependency(ind1, dep1);
		fds.add(fd1);
		
		//run client code
		Set<AttributeSet> bcnf = BCNF.BCNF(attrs, fds);

		//verify output
		
		for(AttributeSet as:bcnf)
		{
			System.out.println(as.toString());
		}
	
	} 
	
	//test 7
	public void test7SimpleBCNF() {
		//construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("a"));
		attrs.addAttribute(new Attribute("b"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("d"));
		attrs.addAttribute(new Attribute("e"));

		//create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("d"));
		dep.addAttribute(new Attribute("b"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);
		
		AttributeSet ind1 = new AttributeSet();
		AttributeSet dep1 = new AttributeSet();
		ind1.addAttribute(new Attribute("c"));
		ind1.addAttribute(new Attribute("e"));
		dep1.addAttribute(new Attribute("a"));
		FunctionalDependency fd1 = new FunctionalDependency(ind1, dep1);
		fds.add(fd1);
		
		//run client code
		Set<AttributeSet> bcnf = BCNF.BCNF(attrs, fds);

		//verify output
		
		for(AttributeSet as:bcnf)
		{
			System.out.println(as.toString());
		}
	
	} 
	//test 8
	public void test8SimpleBCNF() {
		//construct table
		AttributeSet attrs = new AttributeSet();
		attrs.addAttribute(new Attribute("s"));
		attrs.addAttribute(new Attribute("t"));
		attrs.addAttribute(new Attribute("v"));
		attrs.addAttribute(new Attribute("c"));
		attrs.addAttribute(new Attribute("d"));
		attrs.addAttribute(new Attribute("p"));

		//create functional dependencies
		Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();
		AttributeSet ind = new AttributeSet();
		AttributeSet dep = new AttributeSet();
		ind.addAttribute(new Attribute("s"));
		dep.addAttribute(new Attribute("t"));
		FunctionalDependency fd = new FunctionalDependency(ind, dep);
		fds.add(fd);
		
		AttributeSet ind1 = new AttributeSet();
		AttributeSet dep1 = new AttributeSet();
		ind1.addAttribute(new Attribute("v"));
		dep1.addAttribute(new Attribute("s"));
		dep1.addAttribute(new Attribute("c"));
		FunctionalDependency fd1 = new FunctionalDependency(ind1, dep1);
		fds.add(fd1);
		
		
		AttributeSet ind2 = new AttributeSet();
		AttributeSet dep2 = new AttributeSet();
		ind2.addAttribute(new Attribute("s"));
		ind2.addAttribute(new Attribute("d"));
		dep2.addAttribute(new Attribute("p"));
		dep2.addAttribute(new Attribute("v"));
		FunctionalDependency fd2 = new FunctionalDependency(ind2, dep2);
		fds.add(fd2);
		//run client code
		Set<AttributeSet> bcnf = BCNF.BCNF(attrs, fds);

		//verify output
		
		for(AttributeSet as:bcnf)
		{
			System.out.println(as.toString());
		}
	
	} 
	
	
	

}
