package queue;
import list.*;

public class ArrayQueue<E> implements QueueADT<E>{

	List<E> values = new ArrayList<E>();
	int front = 0; 
	int back = 0;
	int qSize = 0;
	
	@Override
	public void add(E value) {
		if (qSize < values.size()) {
			values.set(back, value);
		}
		else {
			
			values.add(back, value);
			front = (front + 1) % values.size();
		}
		back = (back +1) % values.size();
		qSize++;
		
	}

	@Override
	public E remove() {
		E result = values.get(front);
		front = (front + 1) % values.size();
		qSize--;
		return result;
	}

	@Override
	public E peek() {
		if (qSize == 0){
			return null;
		}
		return values.get(front);
	}

	@Override
	public int size() {
		return qSize;
	}

	@Override
	public boolean isEmpty() {
		return values.size() == 0;
	}

	@Override
	public void clear() {
		values.clear();
	}

	public String toString() {
		String s = "[";
        for(int i=0;i<qSize;i++)
        {
            s+= values.get((front+i)%values.size());
            if(i+1 != qSize)
            s+= ", ";
        }
        return s + "]";
	}

}
