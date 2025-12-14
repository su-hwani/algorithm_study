import sys
input = sys.stdin.readline




# 6
# 4 8 6 3 12 9


N = int(input())
numbers = list(map(int, input().split()))

graph = {
    i: True for i in numbers
}

def backtrack(num: int, path: list, depth: int): 
    # print(num, path, depth)
    if depth == N: 
        for i in range(N-1, -1, -1): 
            print(path[i], end =" ")
        
    
    if num % 2 == 0 and num // 2 in graph: 
        path.append(num // 2)
        backtrack(num // 2, path, depth + 1)
        path.pop()
    
    if num * 3 in graph: 
        path.append(num * 3)
        backtrack(num * 3, path, depth + 1)
        path.pop()
        

for i in numbers: 
    
    backtrack(i, [i], 1)
    
