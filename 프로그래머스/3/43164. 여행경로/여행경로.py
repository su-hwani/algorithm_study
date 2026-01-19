graph = {} # start: {end: count}
total_tickets = 0

def solution(tickets):
    global graph
    global total_tickets 
    
    total_tickets = len(tickets)
    
    for start, end in tickets: 
        if start in graph: 
            if end in graph[start]: 
                graph[start][end] += 1
            else: 
                graph[start][end] = 1
        else: 
            graph[start] = {end: 1}
    
    ans = dfs("ICN", 0)
    # print(f"ans: {ans}")
        
    
    return ans[1]

def dfs(start, used_tickets): 
    global total_tickets 
    # print(f"start: {start}")
    answer = [start]
    
    if used_tickets == total_tickets: 
        return True, answer 
    
    if start not in graph: 
        return False, answer
    
    end_node = list(graph[start].keys())
    end_node.sort() 
    
    # print(f"start: {start} end_node: {end_node} graph[start]: {graph[start]}")
    
    for i in range(len(end_node)): 
        # print(f"{answer} {graph[start]} ")
        if graph[start][end_node[i]] == 0: 
            continue 
            
        graph[start][end_node[i]] -= 1
        success, path = dfs(end_node[i], used_tickets + 1)
        if success: 
            answer.extend(path) 
            return True, answer
        else: 
            graph[start][end_node[i]] += 1
        
    
    return False, answer
        
        
        
        
    
    