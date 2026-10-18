class Solution {
    public boolean isValid(String s) {
        List<Character> stack=new ArrayList<>();
        for(char a:s.toCharArray()){
            if(a=='('||a=='{'||a=='['){
                stack.add(a);
            }else{
                if(stack.size()==0){
                    return false;
                }
                char popped=stack.get(stack.size()-1);
                if(a==')'&&popped!='('){
                    return false;
                }else if(a=='}'&&popped!='{'){
                    return false;
                }else if(a==']'&&popped!='['){
                    return false;
                }else{
                    stack.remove(stack.size()-1);
                }
            }
        }
        return stack.size()==0;
    }
}
