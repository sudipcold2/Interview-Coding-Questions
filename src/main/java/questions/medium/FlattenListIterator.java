package questions.medium;

import utilclasses.NestedInteger;

import java.util.*;

/**
 * Implement the NestedIterator class:
 *
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 */
public class FlattenListIterator implements Iterator<Integer> {

    private Stack<ListIterator<NestedInteger>> lists;

    public FlattenListIterator(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    @Override
    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger()) {
                    lists.peek().previous();
                    return true;
                }

                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

}
