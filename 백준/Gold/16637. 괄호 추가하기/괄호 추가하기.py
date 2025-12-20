

import sys


input = sys.stdin.readline 

N = int(input())
context = input().strip() 

result = -1e9


def calculate(context): 
    all = []
    partial = []
    is_partial = False 
    
    
    for i in range(len(context)): 
        
        # print(f"all: {all} partial: {partial}")
        if context[i] == "(":
            is_partial = True 
        elif context[i] == ")":
            is_partial = False 
            if all: 
                second = all.pop()
                first = all.pop()
                third = partial.pop() 
                all.append(int(eval(f"{first}{second}{third}")))
            else: 
                all.append(partial.pop())
        
        else: 
            focus = partial if is_partial else all
            if context[i].isnumeric(): 
                if focus: 
                    second = focus.pop()
                    first = focus.pop() 
                    focus.append(int(eval(f"{first}{second}{context[i]}")))
                else:
                    focus.append(context[i])
            else: 
                focus.append(context[i])
                    
    return all[0]
                

def backtrack(context, index):
    global result
    
    if index >= len(context)-1: 
        # print(context)
        result = max(result, int(calculate(context)))
        
        return 
    
    
    backtrack(context[:index] + "(" + context[index:index+3] + ")" + context[index+3:], index+6)
    backtrack(context, index+2)
    
    
backtrack(context, 0)

print(result)