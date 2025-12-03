import sys

input = sys.stdin.readline

N, M = map(int, input().split())

from collections import deque

visited = {}
q = deque([(N, ""), (1, "/")])  # number, result
visited[N] = (True, 0)
visited[1] = (True, 1)

result = []
if N == M:
    print(0)
else:
    while q:
        num, res = q.popleft()

        if num > M:
            continue
        elif num == M:
            result.append(res)
            continue

        if num * num not in visited or (
            num * num in visited and visited[num * num][1] > len(res)
        ):
            if num * num != M: 
                visited[num * num] = (True, len(res))
            q.append((num * num, res + "*"))

        if num * 2 not in visited or (
            num * 2 in visited and visited[num * 2][1] > len(res)
        ):
            if num * 2 != M:
                visited[num * 2] = (True, len(res)) 
            q.append((num * 2, res + "+")) 

    result.sort(key=lambda x: (len(x), x))
    print(-1 if len(result) == 0 else result[0])
