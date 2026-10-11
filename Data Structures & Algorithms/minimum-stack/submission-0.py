class MinStack:

    def __init__(self):
        self.Minstack= []
        self.stack=[]

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.Minstack:
            self.Minstack.append(min(val,self.Minstack[-1]))
        else:
            self.Minstack.append(val)
    def pop(self) -> None:
        self.stack.pop()
        self.Minstack.pop()
    def top(self) -> int:
        return self.stack[-1]
    def getMin(self) -> int:
        return self.Minstack[-1]
        
