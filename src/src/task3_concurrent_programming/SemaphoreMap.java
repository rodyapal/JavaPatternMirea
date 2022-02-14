package task3_concurrent_programming;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreMap <K, V> implements Map<K, V> {
	private final Map<K, V> data;
	private final Semaphore semaphore;

	SemaphoreMap(Semaphore semaphore) {
		this.semaphore = semaphore;
		data = new HashMap<>();
	}

	public boolean acquire() {
		try {
			semaphore.acquire();
			return true;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void release() {
		semaphore.release();
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return data.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return data.containsValue(value);
	}

	@Override
	public V get(Object key) {
		return data.get(key);
	}

	@Override
	public V put(K key, V value) {
		return data.put(key, value);
	}

	@Override
	public V remove(Object key) {
		return data.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		data.putAll(m);
	}

	@Override
	public void clear() {
		data.clear();
	}

	@Override
	public Set<K> keySet() {
		return data.keySet();
	}

	@Override
	public Collection<V> values() {
		return data.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return data.entrySet();
	}
}
