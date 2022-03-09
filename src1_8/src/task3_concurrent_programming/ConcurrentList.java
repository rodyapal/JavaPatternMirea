package task3_concurrent_programming;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentList <T> implements List<T> {

	private final List<T> data;
	private static final Lock lock = new ReentrantLock();

	public ConcurrentList() {
		data = new ArrayList<>();
	}

	@Override
	public int size() {
		try {
			lock.lock();
			return data.size();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean isEmpty() {
		try {
			lock.lock();
			return data.isEmpty();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean contains(Object o) {
		try {
			lock.lock();
			return data.contains(o);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public Iterator<T> iterator() {
		try {
			lock.lock();
			return data.iterator();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public Object[] toArray() {
		try {
			lock.lock();
			return data.toArray();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public <T1> T1[] toArray(T1[] a) {
		try {
			lock.lock();
			return data.toArray(a);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean add(T t) {
		try {
			lock.lock();
			return data.add(t);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean remove(Object o) {
		try {
			lock.lock();
			return data.remove(o);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		try {
			lock.lock();
			return data.containsAll(c);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		try {
			lock.lock();
			return data.addAll(c);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		try {
			lock.lock();
			return data.addAll(index, c);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		try {
			lock.lock();
			return data.removeAll(c);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		try {
			lock.lock();
			return data.retainAll(c);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void clear() {
		try {
			lock.lock();
			data.clear();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public T get(int index) {
		try {
			lock.lock();
			return data.get(index);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public T set(int index, T element) {
		try {
			lock.lock();
			return data.set(index, element);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void add(int index, T element) {
		try {
			lock.lock();
			data.add(index, element);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public T remove(int index) {
		try {
			lock.lock();
			return data.remove(index);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public int indexOf(Object o) {
		try {
			lock.lock();
			return data.indexOf(o);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public int lastIndexOf(Object o) {
		try {
			lock.lock();
			return data.lastIndexOf(o);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public ListIterator<T> listIterator() {
		try {
			lock.lock();
			return data.listIterator();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		try {
			lock.lock();
			return data.listIterator(index);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		try {
			lock.lock();
			return data.subList(fromIndex, toIndex);
		} finally {
			lock.unlock();
		}
	}
}
