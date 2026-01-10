import sys

input = sys.stdin.readline

graph = {0: (1, 1)}
for i in range(1, 51):
    graph[i] = (graph[i - 1][0] * 2 + 3, graph[i - 1][1] * 2 + 1)

N, K = map(int, input().split())


def fun(N, K):
    if K <= 0:
        return 0

    if N == 0:
        return 1  # Level 0 = "P", K >= 1이면 패티 1개

    len_prev = graph[N - 1][0]
    patties_prev = graph[N - 1][1]

    if K == 1:
        return 0  # 첫 B만
    elif K <= len_prev + 1:
        return fun(N - 1, K - 1)  # B + Level(N-1) 일부
    elif K == len_prev + 2:
        return patties_prev + 1  # B + Level(N-1) + P
    else:
        # 두 번째 Level(N-1)의 먹는 양을 len_prev로 제한 (마지막 B 제외)
        second_eaten = min(K - len_prev - 2, len_prev)
        return patties_prev + 1 + fun(N - 1, second_eaten)


print(fun(N, K))
