


N = int(input())

numbers = list(map(int, input().split()))

graph = [numbers[0]]


from bisect import bisect_left

for num in numbers: 
    idx = bisect_left(graph, num)
    if idx == len(graph):
        graph.append(num)
    else:
        graph[idx] = num
        
print(len(graph))