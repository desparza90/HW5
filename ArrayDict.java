import java.util.ArrayList;
import java.util.Iterator;
/** 
	A class implementing an ADT DICTIONARY using an array
	@authoer Daniel Esparza
	@version 1.0
*/
public class ArrayDict<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>
{
	private final K[] KDict;
	private final V[] VDict;
	private static final int DEFAULT_CAPACITY = 10;
	int numItems;
	
	ArrayDict()
	{
            K[] tempDict = (K[])new Object[DEFAULT_CAPACITY];
            V[] tempVDict = (V[])new Object[DEFAULT_CAPACITY];
            numItems = 0;
            KDict = tempDict;
            VDict = tempVDict;
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
       if(numItems == 0)
       {
           KDict[0] = key;
	   VDict[0] = value;
	   numItems++;
	   return null;
       }
       else
       {
           if(numItems < 10)
           {
               int i = 0;
               switch(key.compareTo(KDict[i]))
               {
                   case 0: V temp = VDict[i];
                   VDict[i] = value;
                   return temp;
	
                   case 1: for(int j = 9; j >= 0; j--)
                   {
                       KDict[j] = KDict[j-1];
                       VDict[j] = VDict[j-1];
                   }
                   KDict[i] = key;
                   VDict[i] = value;
                   break;
                   
                   case -1: while (key.compareTo(KDict[i]) < 0 )
                       i++;
                       for(int j = 9; j > i; j--)
                       {
                           KDict[j] = KDict[j-1];
                           VDict[j] = VDict[j-1];
                       }
                       KDict[i] = key;
                       VDict[i] = value;
                       return null;
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
       for(int i = 0; i < 10; i++)
       {
           if (key == KDict[i])
           {
               V temp = VDict[i];
               KDict[i] = null;
               VDict[i] = null;
               return temp;
           }
        }
        return null;
   }
   
   /** Retrieves from this dictionary the value associated with a given
       search key.
       @param key  An object search key of the entry to be retrieved.
       @return  Either the value that is associated with the search key
                or null if no such object exists. */
   public V getValue(K key)
   {
       for(int i = 0; i < 10; i++)
       {
           if (key == KDict[i])
           {
               return VDict[i];
           }
       }
       return null;
   }
   
   /** Sees whether a specific entry is in this dictionary.
       @param key  An object search key of the desired entry.
       @return  True if key is associated with an entry in the dictionary. */
   public boolean contains(K key)
   {
       for(int i = 0; i < 10; i++)
       {
           if (key == KDict[i])
           {
               return true;
           }
       }
       return false;
   }
   
   /** Creates an iterator that traverses all search keys in this dictionary.
       @return  An iterator that provides sequential access to the search
                keys in the dictionary. */
   public Iterator<K> getKeyIterator()
   {
       ArrayList<K> arr = new ArrayList<K>();
       for(int i = 0; i < 10; i++)
       {
           arr.add(KDict[i]);
       }
       Iterator<K> keyIterator = arr.iterator();
       return keyIterator;
   }
   
   /** Creates an iterator that traverses all values in this dictionary.
       @return  An iterator that provides sequential access to the values
                in this dictionary. */
   public Iterator<V> getValueIterator()
   {
       ArrayList<V> arr = new ArrayList<V>();
       for(int i = 0; i < 10; i++)
       {
           arr.add(VDict[i]);
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
   public void clear(){
       
   }
} // end DictionaryInterface