// Ramazan Özdemir 111044051 


package Hiprit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*hiprit class local da bir arraylist tutulup hiprit bir class olusturuluyor*/
public class HipritClass<E> implements List{

	private LinkedList<ArrayList<E>> hipritList;
	private int size;
	/*local private data */
	private ArrayList<E> tempArray;

	/*no parameter constructor */
	public HipritClass() {
		super();
		this.hipritList= new LinkedList<ArrayList<E>>();
		this.tempArray=new ArrayList<E>();
		this.hipritList.add(tempArray);
		this.size=0;
		// TODO Auto-generated constructor stub
	}
	/* parameter constructor*/
	public HipritClass(LinkedList<ArrayList<E>> hipritList) {
		super();
		this.hipritList = hipritList;
		/*local size ataniyor */
		for(int i=0;i<this.hipritList.size();i++)
		{
			this.size+=this.hipritList.get(i).size();
		}
		/*local data ataniyor */
		this.tempArray=this.hipritList.get(this.hipritList.size()-1);
	}



	private int getSize() {
		return size;
	}
	private void setSize(int size) {
		this.size = size;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hipritList == null) ? 0 : hipritList.hashCode());
		result = prime * result + size;
		result = prime * result
				+ ((tempArray == null) ? 0 : tempArray.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HipritClass other = (HipritClass) obj;
		if (hipritList == null) {
			if (other.hipritList != null)
				return false;
		} else if (!hipritList.equals(other.hipritList))
			return false;
		if (size != other.size)
			return false;
		if (tempArray == null) {
			if (other.tempArray != null)
				return false;
		} else if (!tempArray.equals(other.tempArray))
			return false;
		return true;
	}
	/*setters and getters are private */
	private LinkedList<ArrayList<E>> getHipritList() {
		return hipritList;
	}

	private void setHipritList(LinkedList<ArrayList<E>> hipritList) {
		this.hipritList = hipritList;
	}

	private ArrayList<E> getTempArray() {
		return tempArray;
	}

	private void setTempArray(ArrayList<E> tempArray) {
		this.tempArray = tempArray;
	}

	@Override
	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		// local de ki array size i 5 oluncaya kadar ayni yere 5 den sonra 
		// yeni yere 
		
		if(this.tempArray.size()<5){
			Boolean temp= tempArray.add( (E) arg0);
			this.hipritList.set(this.hipritList.size()-1, tempArray);
			this.size++;
			return temp;
		
		}
		else{
			tempArray= new ArrayList<E>();
			Boolean temp= tempArray.add((E) arg0);
			this.hipritList.add(tempArray);
			this.size++;
			return temp;
			
		}
	}

	@Override
	public void add(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		// eger eklemek istedigi yerde yer varsa ekleriz yoksa false
		int location=arg0/5;
		int index=arg0%5;
		if(arg0<this.size)
		{
			/*eger sonda yer yoksa yeni sini almamaiz lazim*/
			if(this.hipritList.get(this.hipritList.size()-1).size()>=5){
				this.hipritList.add(new ArrayList<E>());
			}
			/*hala yer var demektir eklenir*/
			if(this.hipritList.get(location).size()<5)
				this.hipritList.get(location).add(index, (E) arg1);
			/*orda yer kalmamis demektir kaydirmamiz lazim*/
			else
			{
				this.hipritList.get(location).add(index, (E) arg1);
				
				for(int i=location+1;i<this.hipritList.size();i++)
				{
					E temp=this.hipritList.get(i-1).get(5);
					this.hipritList.get(i-1).remove(5);
					this.hipritList.get(i).add(0, temp);
					/*5 li datalari kauydirmak icin*/
					
				}
				// burdan ciktiktan sonra sonda 6 eleman olmusa o elemani yeni yere almamiz lazim
				if(this.hipritList.get(this.hipritList.size()-1).size()>5)
				{
					tempArray= new ArrayList<E>();
					tempArray.add(this.hipritList.get(this.hipritList.size()-1).get(5));
					this.hipritList.get(this.hipritList.size()-1).remove(5);
				}
			}
			/*local de ki arrayimizi atama yaptik */
			this.tempArray= this.hipritList.get(this.hipritList.size()-1);
			this.size++;
		}
		else
			throw new IndexOutOfBoundsException();
			
	}

	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		int i=this.size;
		Iterator<E> tempIte= arg0.iterator();
		while(tempIte.hasNext())
		{
			//System.out.println("girdi");
			this.add(tempIte.next());
			i++;
		}
		if(i==arg0.size())
			return true;
		else
			return false;
	}

	@Override
	public boolean addAll(int arg0, Collection arg1) {
		// TODO Auto-generated method stub
		int i=0;
		int previusSize=this.size;
		
		Iterator<E> tempIte= arg1.iterator();
		while(tempIte.hasNext())
		{
			E test=tempIte.next();
			this.add(arg0,test);
			//System.out.println("tst"+test);
			arg0++;
			i++;
		}
		// eger butun elemanlar eklenmisse true degilse false 
		if((previusSize+i)==this.size)
		{
			return true;
		}
		else 
			return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.hipritList= new LinkedList<ArrayList<E>>();
		this.tempArray= new ArrayList<E>();
		this.hipritList.add(tempArray);
		this.size=0;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.hipritList.size();i++)
		{
			if(this.hipritList.get(i).contains(arg0))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		Iterator<E> iter = arg0.iterator();	
		while(iter.hasNext()){
			if(!this.contains(iter.next()))
				return false;
			}
			return true;
		}

	
	
	// gives last index arg0
	@Override
	public Object get(int arg0) {
		
		// TODO Auto-generated method stub
		if(arg0<this.size && arg0>-1){
			int location=arg0/5;
			int index= arg0%5;
			return this.hipritList.get(location).get(index);
		}
		else
			throw new IndexOutOfBoundsException();
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<this.hipritList.size();i++)
		{
			for(int j=0;j<this.hipritList.get(i).size();j++)
			{
				if(this.hipritList.get(i).get(j).equals(arg0))
					return (i*5)+j;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.size==0)
			return true;
		else
			return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return this.hipritList.iterator();
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		for(int i=this.hipritList.size()-1;i>=0;i--)
		{
			for(int j=this.hipritList.get(i).size();j>=0;j--)
			{
				if(this.hipritList.get(i).get(j).equals(arg0))
					return (i*5)+j;
			}
		}
		return -1;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return this.hipritList.listIterator();
	}

	@Override
	public ListIterator listIterator(int arg0) {
		// TODO Auto-generated method stub
		return this.hipritList.listIterator(arg0);
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		
		int index=this.indexOf(arg0);
		// index of dan -1 gelebilir
		if(index==-1)
			throw new IndexOutOfBoundsException();
		if(this.remove(index)!=null)
			return true;
		else
			return false;
	}

	@Override
	public Object remove(int arg0) {
		// TODO Auto-generated method stub
		Object removeObj=null;
		if(arg0<size && arg0>=0){
			int location=arg0/5;
			int index=arg0%5;
			removeObj=this.hipritList.get(location).get(index);
			// kaydirma islemleri yapiliyor 
			for(int j=index;j<this.hipritList.get(location).size()-1;j++)
			{
				
				this.hipritList.get(location).set(j,this.hipritList.get(location).get(j+1));
			}
			
			for(int i=location+1;i<this.hipritList.size();i++){
					this.hipritList.get(i-1).set(this.hipritList.get(i-1).size()-1,this.hipritList.get(i).get(0));
					for(int j=0;j<this.hipritList.get(i).size()-1;j++)
					{
						this.hipritList.get(i).set(j, this.hipritList.get(i).get(j+1));
					}
					
			}
			this.hipritList.get(this.hipritList.size()-1).remove(
									this.hipritList.get(
											this.hipritList.size()-1
											).size()-1
											);
			
			if(this.hipritList.get(this.hipritList.size()-1).size()==0)
			{
				this.hipritList.removeLast();
			}
			this.tempArray= this.hipritList.get(this.hipritList.size()-1);
			this.size--;
			return removeObj;
		}
		else
			throw new IndexOutOfBoundsException();
	}

	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		Iterator<E> iter = arg0.iterator();
		int i=this.size;
		while(iter.hasNext())
		{
			this.remove(iter.next());
			i--;
		}
		if(i==this.size)return true;
		else return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		// remove collenction da olmayan elemanlari cikariyor
		int i=this.size;
		for(int k=0;k<this.hipritList.size();k++)
		{
			for(int j=0;j<this.hipritList.get(k).size();j++)
			{
				//System.out.print(this.hipritList.get(k).get(j));
				if(! (arg0.contains(this.hipritList.get(k).get(j)))  ){
					this.remove(this.hipritList.get(k).get(j));
					i--;
				}
				
			}
		}
		if(i==this.size)
			return true;
		else
			return false;
	}

	@Override
	// verilen elemni set ediyor
	public Object set(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg0>=this.size)
			throw new IndexOutOfBoundsException();
		int previusSize= this.size;
		this.add(arg0, arg1);
		this.remove(arg0+1);
		if(this.size==previusSize)
			return arg1;
		else
			return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public List subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		if(arg0<0 || arg0>=arg1 || arg1>size || arg0>size )
			throw new IndexOutOfBoundsException();
		
		return this.hipritList.subList(arg0, arg1);
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		
		return this.hipritList.toArray();
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return this.hipritList.toArray(arg0);
	}
	public void printData()
	{
		for(int i=0;i<this.hipritList.size();i++)
		{
			System.out.println("Yapi ===>");
			for(int j=0;j<this.hipritList.get(i).size();j++)
			{
				System.out.println("          : "+this.hipritList.get(i).get(j));
			}
		}
	}


}
