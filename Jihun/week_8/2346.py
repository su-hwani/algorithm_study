from collections import deque

N = int(input())
q = deque()
result = []

numbers = list(map(int, input().split()))

for i in range(N):
    q.append((i + 1, numbers[i]))

for i in range(N):
    item = q.popleft()
    result.append(item[0])
    if item[1] > 0:
        q.rotate(-item[1]+1)
    else:
        q.rotate(-item[1])

for bal in result:
    print(bal, end=" ")
print()