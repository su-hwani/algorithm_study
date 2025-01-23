import sys
input = sys.stdin.readline

N = int(input())
graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

count_0 = 0
count_1 = 0

def only_color(start, size):
    color = graph[start[0]][start[1]]  # 첫 번째 값을 기준으로
    for i in range(start[0], start[0] + size):
        for k in range(start[1], start[1] + size):
            if graph[i][k] != color:
                return -1  # 섞인 경우
    return color

def group(start, size):
    global count_0
    global count_1
    r = only_color((start[0], start[1]), size)
    if r == 0:
        count_0 += 1
        return
    elif r == 1:
        count_1 += 1
        return

    # 4등분하여 재귀 호출
    half = size // 2
    for i in range(2):
        for j in range(2):
            group((start[0] + i * half, start[1] + j * half), half)

group((0, 0), N)
print(count_0)
print(count_1)