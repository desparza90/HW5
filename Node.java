/**
 * @author despa
 */
public class Node<K extends Comparable<? super K>,V> implements Comparable<Node<K, V>>
{
	K key;
	V value;
	Node<K,V> next;
	
	public Node() {
		key = null;
		value = null;
		next = null;
	}

	public Node(K ke, V val, Node nextN)
	{
		this.key = ke;
		this.value = val;
		this.next = nextN;
	
	}

        @Override
        public int compareTo(Node<K,V> nod)
        {
            return key.compareTo(nod.key);
        }
}