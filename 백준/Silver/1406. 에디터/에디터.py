# abcd
# 3
# P x
# L
# P y


import sys

input = sys.stdin.readline

from collections import deque


line = input().strip()
N = int(input())


left = deque(list(line))
right = deque([])


for _ in range(N):
    command = input().split()
    
    if command[0] == "L":
        if left: 
            item = left.pop()
            right.appendleft(item)
        
    elif command[0] == "B":
        if left: 
            left.pop()
            
        
    elif command[0] == "D":
        if right: 
            item = right.popleft()
            left.append(item) 
        
    else: 
        # P 
        left.append(command[1])

print("".join(left) + "".join(right))
        
        
        
