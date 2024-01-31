import sys
input = sys.stdin.readline

N = int(input())
talls = []

count = 0
tallest = 0

for i in range(N):
    tall = int(input())
    if len(talls) > 0:
        if tall < talls[-1]:
            count += len(talls)
            talls.append(tall)
        else:
            while True:
                talls.pop()
                if len(talls) == 0 or talls[-1] > tall:
                    break
            count += len(talls)
            talls.append(tall)
    else:
        talls.append(tall)

print(count)