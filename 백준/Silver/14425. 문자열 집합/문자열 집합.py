


N, M = map(int, input().split())

group = {}
each = {}
answer = 0

for i in range(N):
    s1 = input()
    group[s1] = True
    
for i in range(M):
    s1 = input()
    if s1 in group: 
        answer += 1
        
print(answer)
        
    