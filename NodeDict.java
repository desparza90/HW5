import java.util.ArrayList;
import java.util.Iterator;
/** 
	A class implementing an ADT DICTIONARY using an array
	@authoer Daniel Esparza
	@version 1.0
*/
public class NodeDict<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>
{
	private Node<K,V> head;
	private Node<K,V> point;
	int numItems;
	
	NodeDict()
	{
            head = null;
			point = null;
            numItems = 0;
	}
	
	
   /** Adds a new entry to this dictionary. If the given search key already
       exists in the dictionary, replaces the corresponding value.
       @param key    An object search key of the new entry.
       @param value  An object associated with the search key.
       @return  Either null if the new entry was added to the dictionary
                or the value that was associated with key if that value
                was replaced. */
   public V add(K key, V value)
   {
	   point = head;
	   if(numItems == 0)
       {
		   head.key = key;
		   head.value = value;
		   numItems++;
		   point = head;
		   return null;
       }
       else
       {
           int i = 0;
           Node tNode = new Node(key, value, head);
           switch(key.compareTo(point.key))
           {
               
               case 0: V temp = point.value;
			   point.value = value;
			   numItems++;
			   return temp;
	
               case 1:
			   head = tNode;
			   numItems++;
			   return null;
                           
                   
               case -1: while (key.compareTo(point.key) < 0 && i != (numItems))
			   {
				   point = point.next;
				   i++;
			   }
			   Node tPoint = head;
			   while (tPoint.next != point) 
				   tPoint = tPoint.next;
			   tPoint.next = tNode;
			   if(point.next == null)
			   {
				   tNode.key = key;
                                   tNode.value = value;
                                   tNode.next = null;
			   }
			   else
                           {
                               tNode.key = key;
                               tNode.value = value;
                               tNode.next = point;
                           }
           }
       }
	   return null;
   }
   
   /** Removes a specific entry from this dictionary.
       @param key  An object search key of the entry to be removed.
       @return  Either the value that was associated with the search key
                or null if no such object exists. */
   public V remove(K key)
   {
	   point = head;
	   int i = 0;
       while (key.compareTo(point.key) != 0 && i != (numItems))
	   {
		   point = point.next;
		   i++;
	   }
	   if(i != numItems)
	   {
		   V temp = point.value;
		   point.value = null;
		   Node tPoint = head;
		   while (tPoint.next != point) 
			   tPoint = tPoint.next;
		   tPoint.next = point.next;
		   point = null;
		   numItems--;
		   return temp;
           }
	   else
		   return null;
   }
   
   /** Retrieves from this dictionary the value associated with a given
       search key.
       @param key  An object search key of the entry to be retrieved.
       @return  Either the value that is associated with the search key
                or null if no such object exists. */
   public V getValue(K key)
   {
       point = head;
	   int i = 0;
       while (key.compareTo(point.key) != 0 && i != (numItems))
	   {
		   point = point.next;
		   i++;
	   }
	   if(i != numItems)
		   return point.value;
	   else
		   return null;
   }
   
   /** Sees whether a specific entry is in this dictionary.
       @param key  An object search key of the desired entry.
       @return  True if key is associated with an entry in the dictionary. */
   public boolean contains(K key)
   {
       point = head;
	   int i = 0;
       while (key.compareTo(point.key) != 0 && i != (numItems))
	   {
		   point = point.next;
		   i++;
	   }
	   if(key.compareTo(point.key) == 0)
		   return true;
	   else
		   return false;
   }
   
   /** Creates an iterator that traverses all search keys in this dictionary.
       @return  An iterator that provides sequential access to the search
                keys in the dictionary. */
   public Iterator<K> getKeyIterator()
   {
	   point = head;
       ArrayList<K> arr = new ArrayList<K>();
       for(int i = 0; i < numItems; i++)
       {
           arr.add(point.key);
       }
       Iterator<K> keyIterator = arr.iterator();
       return keyIterator;
   }
   
   /** Creates an iterator that traverses all values in this dictionary.
       @return  An iterator that provides sequential access to the values
                in this dictionary. */
   public Iterator<V> getValueIterator()
   {
	   point = head;
       ArrayList<V> arr = new ArrayList<V>();
       for(int i = 0; i < numItems; i++)
       {
           arr.add(point.value);
       }
       Iterator<V> valIterator = arr.iterator();
       return valIterator;
   }
   
   /** Sees whether this dictionary is empty.
       @return  True if the dictionary is empty. */
   public boolean isEmpty()
   {
       return (numItems == 0);
   }
   
   /** Gets the size of this dictionary.
       @return  The number of entries (key-value pairs) currently
                in the dictionary. */
   public int getSize()
   {
	   return numItems;
   }
   
   /** Removes all entries from this dictionary. */
   public void clear()
   {
	   while(head.next != null)
       {
           head.value = null;
           head = head.next;
       }
       head = null;
       point = null;
   }
}