package org.somox.filter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * See documentation at http://www.erik-rasmussen.com/blog/2008/01/18/the-filter-pattern-java-conditional-abstraction-with-iterables/
 * @author Steffen Becker
 * @param <T> type of the objects to be filtered
 */
public abstract class BaseFilter<T> {
	public abstract boolean passes(T object);

	public Iterator<T> filter(Iterator<T> iterator) {
		return new FilterIterator(iterator);
	}

	public Iterable<T> filter(final Iterable<T> iterable) {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return filter(iterable.iterator());
			}
		};
	}

	private class FilterIterator implements Iterator<T> {
		private Iterator<T> iterator;
		private T next;

		private FilterIterator(Iterator<T> iterator) {
			this.iterator = iterator;
			toNext();
		}

		public boolean hasNext() {
			return next != null;
		}

		public T next() {
			if (next == null)
				throw new NoSuchElementException();
			T returnValue = next;
			toNext();
			return returnValue;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		private void toNext() {
			next = null;
			while (iterator.hasNext()) {
				T item = iterator.next();
				if (item != null && passes(item)) {
					next = item;
					break;
				}
			}
		}
	}
}