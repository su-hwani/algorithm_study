import sys
input = sys.stdin.readline
import heapq

N = int(input())

lectures = []

for i in range(N):
    start, end = map(int, input().split())
    heapq.heappush(lectures, (start, end))


lectures.sort()
rooms = []

heapq.heappush(rooms, lectures[0][1])

for i in range(1, N):
    if rooms[0] > lectures[i][0]:
        heapq.heappush(rooms, lectures[i][1])
    else:
        heapq.heappop(rooms)
        heapq.heappush(rooms, lectures[i][1])

print(len(rooms))