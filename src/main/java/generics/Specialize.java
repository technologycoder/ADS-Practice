package generics;

import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

interface ListString extends List<String> {
}

class ListStrings {
    public static ListString wrap(final List<String> list) {

        class Random extends AbstractList<String>
                implements ListString, RandomAccess {
            @Override
            public int size() {

                return list.size();
            }

            @Override
            public String get(int i) {

                return list.get(i);
            }

            @Override
            public String set(int i, String s) {

                return list.set(i, s);
            }

            @Override
            public String remove(int i) {

                return list.remove(i);
            }

            @Override
            public void add(int i, String s) {

                list.add(i, s);
            }
        }
        class Sequential extends AbstractSequentialList<String>
                implements ListString {
            @Override
            public int size() {

                return list.size();
            }

            @Override
            public ListIterator<String> listIterator(int index) {

                final ListIterator<String> it = list.listIterator(index);
                return new ListIterator<String>() {
                    @Override
                    public void add(String s) {

                        it.add(s);
                    }

                    @Override
                    public boolean hasNext() {

                        return it.hasNext();
                    }

                    @Override
                    public boolean hasPrevious() {

                        return it.hasPrevious();
                    }

                    @Override
                    public String next() {

                        return it.next();
                    }

                    @Override
                    public int nextIndex() {

                        return it.nextIndex();
                    }

                    @Override
                    public String previous() {

                        return it.previous();
                    }

                    @Override
                    public int previousIndex() {

                        return it.previousIndex();
                    }

                    @Override
                    public void remove() {

                        it.remove();
                    }

                    @Override
                    public void set(String s) {

                        it.set(s);
                    }
                };
            }
        }
        return list instanceof RandomAccess ? new Random() : new Sequential();
    }
}

class ArrayListString extends ArrayList<String> implements ListString {
    public ArrayListString() {

        super();
    }

    public ArrayListString(Collection<? extends String> c) {

        super(c);
    }

    public ArrayListString(int capacity) {

        super(capacity);
    }
}

class Test2 {
    public static void testDelegation() {

        List<? extends List<?>> lists = Arrays.asList(
                ListStrings.wrap(Arrays.asList("one", "two")),
                Arrays.asList(3, 4),
                Arrays.asList("five", "six"),
                ListStrings.wrap(Arrays.asList("seven", "eight")));
        ListString[] array = new ListString[2];
        int i = 0;
        for (List<?> list : lists)
            if (list instanceof ListString)
                array[i++] = (ListString) list;
        assert Arrays.toString(array)
                .equals("[[one, two], [seven, eight]]");
    }

    public static void testInheritance() {

        List<? extends List<?>> lists = Arrays.asList(
                new ArrayListString(Arrays.asList("one", "two")),
                Arrays.asList(3, 4),
                Arrays.asList("five", "six"),
                new ArrayListString(Arrays.asList("seven", "eight")));
        ListString[] array = new ListString[2];
        int i = 0;
        for (List<?> list : lists)
            if (list instanceof ListString)
                array[i++] = (ListString) list;
        assert Arrays.toString(array)
                .equals("[[one, two], [seven, eight]]");
    }

    public static void main(String[] args) {

        testDelegation();
        testInheritance();
    }
}
