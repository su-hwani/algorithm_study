import sys
input = sys.stdin.readline

N, P = map(int, input().split())

stack = [[0] for i in range(7)]
count = 0

for i in range(N):
    n, p = map(int, input().split())
    if stack[n][-1] < p:
        stack[n].append(p)
        count += 1
    elif stack[n][-1] > p:
        while len(stack[n]) >= 1:
            stack[n].pop()
            count += 1

            if stack[n][-1] == p:
                break
            if stack[n][-1] < p:
                count += 1
                stack[n].append(p)
                break
print(count)
