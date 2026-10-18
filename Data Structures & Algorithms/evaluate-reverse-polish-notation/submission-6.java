class Solution {
    public int evalRPN(String[] tokens) {
        List<Integer> stack=new ArrayList<>();
        for(String str:tokens){
            try{
                int num=Integer.parseInt(str);
                stack.add(num);
            }catch(Exception e){
                int num2=stack.get(stack.size()-1);
                stack.remove(stack.size()-1);
                int num1=stack.get(stack.size()-1);
                stack.remove(stack.size()-1);
                if(str.equals("+")){
                    stack.add(num1+num2);
                }else if(str.equals("-")){
                    stack.add(num1-num2);
                }else if(str.equals("*")){
                    stack.add(num1*num2);
                }else{
                    stack.add(num1/num2);
                }
            }
        }
        return stack.get(0);
    }
}
