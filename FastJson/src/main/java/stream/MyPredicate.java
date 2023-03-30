package stream;

/**
 * @author ricky
 * @create 2023-03-29 20:17
 */
@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);

}