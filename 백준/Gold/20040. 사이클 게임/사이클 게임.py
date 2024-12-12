# 6 5
# 0 1
# 1 2
# 2 3
# 5 4
# 0 4
import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

parent = {}
number = {}
high = 0

def find(x):
    # 경로 압축
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    global high
    a = find(a)
    b = find(b)
    if a != b:
        # 집합 크기를 비교하여 트리 높이를 최소화
        if number[a] < number[b]:
            a, b = b, a
        parent[b] = a
        number[a] += number[b]
        # 최대 크기 업데이트
        high = max(high, number[a])

n, m = map(int, input().split())
for _ in range(m):
    start, end = map(int, input().split())
    
    # 초기화 시 반복문을 최소화
    if start not in parent:
        parent[start] = start
        number[start] = 1
    
    if end not in parent:
        parent[end] = end
        number[end] = 1
    
    # 연결 여부 확인
    if find(start) == find(end):
        print(f"{_+1}")
        break
    union(start, end)
else:
    print(0)