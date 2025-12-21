import sys
input = sys.stdin.readline 


sys.setrecursionlimit(10**6)


N = int(input())



from collections import deque

q = deque([])

q.append( (N, 0) )


result = 0

while q: 
    
    num, count = q.popleft() 
    
    if num == 1: 
        result = count 
        break 

    if num % 3 == 0: 
        q.append( (num//3, count + 1) )
    
    if num % 2 == 0:
        q.append( (num//2, count + 1) )
        
    q.append( (num-1, count + 1) )
    
print(result)