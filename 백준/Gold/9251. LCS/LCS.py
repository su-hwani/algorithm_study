import sys
input = sys.stdin.readline

a = str(input()).strip()
b = str(input()).strip()

len_a = len(a)
len_b = len(b)

graph = [ [0 for x in range(len_b+1)] for y in range(len_a+1) ]

for i in range(1, len_a+1):
    for k in range(1, len_b+1):
        if a[i-1] == b[k-1]:
            graph[i][k] = graph[i-1][k-1] + 1
        else:
            graph[i][k] = max(graph[i][k-1], graph[i-1][k])
    

print(graph[len_a][len_b])