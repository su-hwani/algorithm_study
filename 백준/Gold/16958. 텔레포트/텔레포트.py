import sys

input = sys.stdin.readline

N, T = map(int, input().split())

cities = []
specials = []

for i in range(N):
    s, x, y = map(int, input().split())
    is_special = (s == 1)
    cities.append((x, y, is_special))
    if is_special:
        specials.append(i)

def dist(i, j):
    """맨하탄 거리"""
    return abs(cities[i][0] - cities[j][0]) + abs(cities[i][1] - cities[j][1])

# 전처리: 각 도시에서 가장 가까운 특별 도시까지 거리
min_special_dist = [float('inf')] * N

for i in range(N):
    if cities[i][2]:  # 자신이 특별 도시면 0
        min_special_dist[i] = 0
    else:
        for s in specials:
            min_special_dist[i] = min(min_special_dist[i], dist(i, s))

# 쿼리 처리
K = int(input())
for _ in range(K):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    
    # 직접 거리
    direct = dist(a, b)
    
    # 특별 도시 경유
    via_special = min_special_dist[a] + T + min_special_dist[b]
    
    print(min(direct, via_special))
