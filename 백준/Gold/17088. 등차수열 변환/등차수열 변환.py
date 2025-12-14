import sys
input = sys.stdin.readline



sys.setrecursionlimit(10**6)

# 4
# 24 21 14 10


N = int(input())

numbers = list(map(int, input().split()))

result = 1e9

def backtrack(idx: int, path: list, depth: int, count: int): 
    global result 
    
    if depth == N: 
        result = min(result, count)
        
        return 
    
    if idx == 0 or idx == 1: 
        path.append(numbers[idx])
        backtrack(idx+1, path, depth + 1, count)
        path.pop()
        
        path.append(numbers[idx] - 1)
        backtrack(idx + 1, path, depth + 1, count + 1)
        path.pop()
        
        path.append(numbers[idx] + 1)
        backtrack(idx + 1, path, depth + 1, count + 1)
        path.pop()
    
    else: 
        diff = path[-2] - path[-1]
        
        if path[-1] - numbers[idx] == diff: 
            path.append(numbers[idx])
            backtrack(idx + 1, path, depth + 1, count)
            path.pop()
        
        elif path[-1] - (numbers[idx] + 1) == diff: 
            path.append(numbers[idx] + 1)
            backtrack(idx + 1, path, depth + 1, count + 1)
            path.pop()
            
        elif path[-1] - (numbers[idx] - 1) == diff:
            path.append(numbers[idx] - 1)
            backtrack(idx + 1, path, depth + 1, count + 1)
            path.pop()
        


backtrack(0, [], 0, 0)

print(result if result != 1e9 else -1)