import sys
input = sys.stdin.readline

n = int(input())
gp = []
for _ in range(n):
    start, end = map(int, input().split())
    gp.append( (end, start) )
gp.sort()

now = 0
count = 0
for g in gp:
    end, start = g
    if now > start: 
        continue
    else:
        count += 1
        now = end
print(count)