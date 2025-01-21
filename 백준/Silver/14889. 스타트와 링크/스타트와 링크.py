import sys
input = sys.stdin.readline
        
        
N = int(input())
graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))
    
from itertools import combinations, permutations
a = list(combinations(range(N), N//2))

def get_score(array):
    count = 0
    a = list(combinations(array, 2))
    for i in a:
        count += graph[i[0]][i[1]]
        count += graph[i[1]][i[0]]
    return count

start = 0
last = len(a) - 1
answer = 1e9

while True:
    if start >= last:
        break
    answer = min(answer, get_score(a[start]) - get_score(a[last]) if get_score(a[start]) > get_score(a[last]) else get_score(a[last]) - get_score(a[start]))
    start += 1
    last -= 1

print(answer)