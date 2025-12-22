






import sys
input = sys.stdin.readline 


N = int(input())

memo = {}
memo[1] = 1
memo[2] = 2 
memo[3] = 4


def fun(num): 
    
    if num in memo:
        return memo[num]
    
    return fun(num-1) + fun(num-2) + fun(num-3)
    
for _ in range(N):
    num = int(input())
    print(fun(num))
