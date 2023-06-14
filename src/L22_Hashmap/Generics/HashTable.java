package L22_Hashmap.Generics;

public class HashTable<K, V> {

	private class HTPair {
		K key;
		V value;

		HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		// override
		public boolean equals(Object other) {
			HTPair op = (HTPair) other;
			return this.key.equals(op.key);
		}

		// override, toString function will tell that ki aap object ka address mt print
		// karo, balki ye print karo
		public String toString() {
			return "{" + this.key + "->" + this.value + "}";
		}

	}

	public static final int DEFAULT_CAPACITY = 10;// if user didn't sent the size while making bucketArray, this default
													// capacity size is set as size of array
	private LinkedListGeneric<HTPair>[] bucketArray;
	private int size;

	public HashTable() {
		this(DEFAULT_CAPACITY);
	}

	public HashTable(int capacity) {
		this.bucketArray = (LinkedListGeneric<HTPair>[]) new LinkedListGeneric[capacity];
		this.size = 0;
	}

	public void put(K key, V value) throws Exception {
		int bi = hashFunction(key); // best index

		LinkedListGeneric<HTPair> bucket = this.bucketArray[bi];

		HTPair np = new HTPair(key, value);

		if (bucket == null) {
			bucket = new LinkedListGeneric<>();
			bucket.addlast(np);
			this.bucketArray[bi] = bucket;
			this.size++;
		} else {
			int findAt = bucket.getIndex(np);
			if (findAt == -1) { // key not present in list
				bucket.addlast(np);
				this.size++;
			} else { // key already present in list
				HTPair pair = bucket.getAt(findAt);
				pair.value = value;
			}
		}

		// for O(1)
		double lamda = (this.size * 1.0) / this.bucketArray.length;
		if (lamda > 2) {
			this.rehash();
		}

	}

	private void rehash() throws Exception {

		LinkedListGeneric<HTPair>[] oba = this.bucketArray;
		this.bucketArray = (LinkedListGeneric<HTPair>[]) new LinkedListGeneric[2 * oba.length];
		this.size = 0;

		for (LinkedListGeneric<HTPair> ob : oba) {
			while (ob != null && !ob.isEmpty()) {
				HTPair pair = ob.removeFirst();
				this.put(pair.key, pair.value);
			}
		}
	}

	public V get(K key) throws Exception {

		int bi = hashFunction(key);
		LinkedListGeneric<HTPair> bucket = this.bucketArray[bi];
		HTPair pair = new HTPair(key, null);

		if (bucket == null) {
			return null;
		} else {
			int findidx = bucket.getIndex(pair);

			if (findidx == -1) {
				return null;
			} else {
				HTPair p = bucket.getAt(findidx);
				return p.value;
			}

		}

	}

	public V remove(K key) throws Exception {

		int bi = hashFunction(key);
		LinkedListGeneric<HTPair> bucket = this.bucketArray[bi];
		HTPair pair = new HTPair(key, null);

		if (bucket == null) {
			return null;
		} else {
			int findidx = bucket.getIndex(pair);

			if (findidx == -1) {
				return null;
			} else {
				HTPair rp = bucket.removeAt(findidx);
				this.size--;
				return rp.value;
			}

		}

	}

	private int hashFunction(K key) {
		int hc = key.hashCode();// hashcode
		hc = Math.abs(hc);
		int bi = hc % this.bucketArray.length;
		return bi;
	}

	public void display() throws Exception {
		for (LinkedListGeneric<HTPair> bucket : this.bucketArray) {
			if (bucket != null && !bucket.isEmpty()) {
				bucket.display();
			} else {
				System.out.println("NULL");
				System.out.println("***************************");
			}
		}
		System.out.println("-----------------------------------------");
	}
}
