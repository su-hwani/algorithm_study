import sys
input = sys.stdin.readline










from itertools import permutations 

N, M = map(str, input().split())
M = int(M)
result = -1

for i in list(permutations(N, len(N))):
    if i[0] == "0": 
        continue 
    num = int("".join(i))
    if num < M and num > result: 
        result = num
    
print(result)
