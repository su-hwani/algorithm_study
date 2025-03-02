def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, u, v):
    rootA = find(parent, u)
    rootB = find(parent, v)
    
    if rootA != rootB:
        parent[rootA] = rootB

def solution(n, costs):
    edges = sorted(costs, key=lambda x:x[2])
    parent = [i for i in range(n+1)]
    mst_edges = []
    mst_cost = 0
    
    for u, v, cost in edges:
        if find(parent, u) != find(parent, v):
            union(parent, u, v)
            mst_cost += cost
            mst_edges.append( (u, v, cost) )
    
    answer = mst_cost
    return answer