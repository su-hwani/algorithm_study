N, M = map(int, input().split())

graph = []

answer = []

for _ in range(N):
    line = input().strip()
    graph.append(line)

for _ in range(N):
    line = input().strip()
    answer.append(line)

count = 0


for i in range(N - 2):
    for k in range(M - 2):
        if graph[i][k] != answer[i][k]:
            for dx in range(0, 3):
                for dy in range(0, 3):
                    if graph[i + dx][k + dy] == "0":
                        graph[i + dx] = (
                            graph[i + dx][: k + dy] + "1" + graph[i + dx][k + dy + 1 :]
                        )
                    else:
                        graph[i + dx] = (
                            graph[i + dx][: k + dy] + "0" + graph[i + dx][k + dy + 1 :]
                        )

            count += 1

for i in range(N):
    for k in range(M):
        if graph[i][k] != answer[i][k]:
            count = -1
            break
    if count == -1:
        break

print(count)
