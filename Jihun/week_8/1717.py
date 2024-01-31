import sys
input = sys.stdin.readline

def find(a):
    temp = a
    while arr[a] != a:
        a = arr[a]
    
    while arr[temp] != temp:
        temp = arr[temp]
        arr[temp] = a

    return a

def union(a, b):
    ap = find(a)
    bp = find(b)
    
    if ap != bp:
        arr[ap] = bp

n, m = map(int, input().split())
arr = [i for i in range(n + 1)]

for i in range(m):
    op, a, b = map(int, input().split())
    
    if op:
        print("YES" if find(a) == find(b) else "NO")
    else:
        union(a, b)