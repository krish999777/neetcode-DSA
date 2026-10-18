class MyStackData{
    int min,item;
    MyStackData(int item,int min){
        this.item=item;
        this.min=min;
    }
}
class MinStack {
    List<MyStackData> stack;
    public MinStack() {
        stack=new ArrayList<>();
    }
    
    public void push(int value) {
        int min;
        if(stack.size()==0){
            min=value;
        }else{
            min=Math.min(value,stack.get(stack.size()-1).min);
        }
        stack.add(new MyStackData(value,min));
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1).item;
    }
    
    public int getMin() {
        return stack.get(stack.size()-1).min;
    }
}