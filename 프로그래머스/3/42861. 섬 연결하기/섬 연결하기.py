def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, rank, a, b):
    rootA = find(parent, a)
    rootB = find(parent, b)
    
    if rootA != rootB:
        if rank[rootA] > rank[rootB]:
            parent[rootB] = rootA
        elif rank[rootA] < rank[rootB]:
            parent[rootA] = rootB
        else:
            parent[rootB] = rootA
            rank[rootA] += 1
            
            
    

def solution(n, costs):
    
    edges = sorted(costs, key=lambda x: x[2])
    
    parent = [i for i in range(n+1)]
    rank = [0] * n
    
    mst_cost = 0
    mst_edges = []
    
    for u, v, cost in edges:
        if find(parent, u) != find(parent, v):
            union(parent, rank, u, v)
            mst_cost += cost
            mst_edges.append( (u, v, cost) )
    
    return mst_cost