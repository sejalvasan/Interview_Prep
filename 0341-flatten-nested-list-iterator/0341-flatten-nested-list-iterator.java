/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> flatenList;
    int current = 0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flatenList = new ArrayList<>();
        
        for(NestedInteger integer:nestedList)
            helper(integer);
    }

    @Override
    public Integer next() {
        return flatenList.get(current++);
    }

    @Override
    public boolean hasNext() {
        if(current<flatenList.size())
            return true;
        
        return false;
    }
    
    public void helper(NestedInteger value){
        if(value.isInteger())
            flatenList.add(value.getInteger());
        else{
            for(NestedInteger integer:value.getList())
                helper(integer);
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */