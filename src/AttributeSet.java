import java.util.*;

/**
 * An unordered set of Attributes. This could very easily be a Java collection,
 * but an important operation (namely examining the powerset) is not easily done
 * with the Java collection.
 **/
public class AttributeSet {

	//a list of the backing attributes
	private List<Attribute> attr;

	//construct an empty AttributeSet
	public AttributeSet() {
		attr = new ArrayList<Attribute>();
	}

	//copy constructor
	public AttributeSet(AttributeSet other) {
		attr = new ArrayList<Attribute>(other.attr);
	}
	public AttributeSet(List<Attribute> other) {
		attr = other;
	}

	public void addAttribute(Attribute a) {
		if(!attr.contains(a))
			attr.add(a);
	}

	public boolean contains(Attribute a) {
		return attr.contains(a);
	}

	public int size() {
		return attr.size();
	}

	public boolean equals(Object other) {
		if(other == null || !(other instanceof AttributeSet))
			return false;
		
		AttributeSet newother=(AttributeSet)other;
		if(this.size()!=newother.size())
		{
			return false;
		}
		for(Attribute list:this.getAttr())
		{
			if(!newother.contains(list))
			{
				return false;
			}
		}
		return true;
		//TODO: you should probably implement this
		//return this == other;
	}

	public Iterator<Attribute> iterator() {
		return attr.iterator();
	}

	public String toString() {
		String out = "";
		Iterator<Attribute> iter = iterator();
		while(iter.hasNext())
			out += iter.next() + "\t";

		return out;
	}

	public List<Attribute> getAttr() {
		return attr;
	}

	public void setAttr(List<Attribute> attr) {
		this.attr = attr;
	}
	
}
