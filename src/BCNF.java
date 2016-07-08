import java.util.*;


public class BCNF {

	/**
	 * Implement your algorithm here
	 **/
	
	
	public static Set<AttributeSet> BCNF(AttributeSet attrs, Set<FunctionalDependency> fds) {
		Set <AttributeSet> decomset=new HashSet<AttributeSet>();
		
		//begin powerset calculation
		List<Attribute> str=new ArrayList<Attribute>(attrs.getAttr());  //universal set
		List<List<Attribute>> powerset=new ArrayList<List<Attribute>>();
		List<List<Attribute>> newset = new ArrayList<List<Attribute>>();
		powerset=powerSet(str);
		 for(List<Attribute> l:powerset)
		    {
		    	if(l.size()>0)
		    	{
		    		newset.add(l);     //remove []
		    	}
		    }
		 
		 //sort by size
		Collections.sort(newset, new Comparator<List<Attribute>>(){
			    public int compare(List<Attribute> a1, List<Attribute> a2) {
			        return a1.size() - a2.size(); // assumes you want smallest to biggest
			    }
			}); 
		 // end of arranging in order
		 
		for(List<Attribute> x:newset)
		{
			AttributeSet temp_x=new AttributeSet(x);
			AttributeSet cl=closure(temp_x,fds);       // for each x, get it's closure
			AttributeSet u_comp=new AttributeSet(x);
			
			// remove extra from closure that are not in universal set
			AttributeSet newcl=new AttributeSet();
			for(Attribute a:cl.getAttr()){
					if(attrs.contains(a))
						newcl.addAttribute(a);		
				
			}
			
			//________________________
			
			if(newcl.equals(attrs)||newcl.equals(temp_x))    // if key or it implies itself
			{
				// done
			}
			else  //else split into X+ and XU(X+)c
			{
				// X+ = cl
				for(Attribute e:attrs.getAttr())
				{
					if(!newcl.contains(e))
					{
						u_comp.addAttribute(e);    // x union x complement
					}
				}
				Set<AttributeSet> result1=BCNF(newcl,fds);
				Set<AttributeSet> result2=BCNF(u_comp,fds);
				decomset.addAll(result1);
				decomset.addAll(result2);
				return decomset;
			}
		}
		decomset.add(attrs);
		return decomset;
	}

	/**
	 * Recommended helper method
	 **/
	
	public static AttributeSet closure(AttributeSet attrs, Set<FunctionalDependency> fds) {

		AttributeSet newdep;
		AttributeSet update;
		Set<FunctionalDependency> fd= new HashSet<FunctionalDependency>(fds);
		
		HashMap<FunctionalDependency,Integer> count=new HashMap<FunctionalDependency,Integer>(); //holds w->z |w|
		HashMap<String,Set<FunctionalDependency>> listA=new HashMap<String,Set<FunctionalDependency>>(); //list[A] with w->z
		Iterator<FunctionalDependency> iterator = fd.iterator();
		
		//initialization 
		while(iterator.hasNext())
		{
			FunctionalDependency f = (FunctionalDependency) iterator.next();
			Integer cardinality=f.getInd().size();
			count.put(f,cardinality);
			AttributeSet attrset=f.getInd();
			List<Attribute> list=attrset.getAttr();
			
			Iterator<Attribute> iterator1=list.iterator();
			Set<FunctionalDependency> current=null;
			while(iterator1.hasNext())
			{
				Attribute a=(Attribute)iterator1.next();
				current=listA.get(a.getName());
				if(current==null)
				{
					current=new HashSet<FunctionalDependency>();
					current.add(f);
				}
				else
				{
					current.add(f);
				}
				listA.put(a.getName(),current);
			}
			
			
		}
		newdep=attrs;
		update=attrs;
		
		//computation
		List<Attribute> updatelist=new ArrayList<Attribute>(update.getAttr());
		List<Attribute> newdeplist= new ArrayList<Attribute>(newdep.getAttr());

		while(updatelist.size() > 0)
		{
			 Attribute A=updatelist.get(0); //choose attribute A
			 updatelist.remove(A);  //update=update-A
			 Set<FunctionalDependency> setA=listA.get(A.getName());
			 if(setA!=null)
			 {
				 
				 Iterator<FunctionalDependency> iterator3=setA.iterator();
				 while(iterator3.hasNext())
				 {
					 FunctionalDependency d=(FunctionalDependency)iterator3.next();
					 Integer num=count.get(d);  //for each FD w->Z in list[A],
					 num=num-1;
					 count.put(d, num);        
					 if(num==0)
					 {
						// List<Attribute> add= new ArrayList<Attribute>(d.getDep().getAttr());
						 List<Attribute> add= new ArrayList<Attribute>();
						 if(newdeplist.isEmpty()==false)
						 { 
							 for(Attribute e:d.getDep().getAttr())
							 {
								 if(newdeplist.contains(e))
								 {
									 //add.remove(e);
									 //do nothing
								 }
								 else
								 {
									 add.add(e);  //retain only that are not in universal (Z complement)
								 }
							 }
						 }
						for(Attribute a:add)
						{
							newdeplist.add(a);
							updatelist.add(a);
						}	 
					 }
				 }
			 } 
			
		}
		return new AttributeSet(newdeplist);
	} 
	
	/**
	 *  method to calculate all subsets of X
	 **/
	public static List<List<Attribute>> powerSet(List<Attribute> originalSet) {
	    List<List<Attribute>> sets = new ArrayList<List<Attribute>>();
	    if (originalSet.isEmpty()) {
	    	sets.add(new ArrayList<Attribute>());
	    	return sets;
	    }
	    List<Attribute> list = new ArrayList<Attribute>(originalSet);
	    Attribute head = list.get(0);
	    List<Attribute> rest = new ArrayList<Attribute>(list.subList(1, list.size())); 
	    for (List<Attribute> set : powerSet(rest)) {
	    	List<Attribute> newSet = new ArrayList<Attribute>();
	    	if(head!=null)
	    	{
	    		newSet.add(head);
	    	}
	    	newSet.addAll(set);
	    	sets.add(newSet);
	    	sets.add(set);
	    }
	   
	    return sets;
	}
	
}
